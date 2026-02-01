package com.challenger.literalura.view;

import com.challenger.literalura.model.Book;
import com.challenger.literalura.model.BookData;
import com.challenger.literalura.model.ResultsData;
import com.challenger.literalura.service.ApiRequest;
import com.challenger.literalura.service.BookService;
import com.challenger.literalura.service.DataConvert;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner userInput = new Scanner(System.in);
    private ApiRequest apiRequest = new ApiRequest();
    private DataConvert converter = new DataConvert();
    private final String URL_Base = "https://gutendex.com/books/?search=";
    private BookService bookService;

    public Principal(BookService bookService) {
        this.bookService = bookService;
    }

    public void showMenu() {
        int option = 1;
        while (option != 0) {
            String menu = """
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    0 - Salir
                    """;
            System.out.println(menu);
            option = userInput.nextInt();
            userInput.nextLine();

            switch (option) {
                case 1 -> webFindBook();
                case 2 -> listBooks();
                case 0 -> System.out.println("Cerrando la aplicación");
            }
        }
    }

    private void webFindBook() {
        System.out.println("Ingresa el nombre del libro a buscar");
        String nameBook = userInput.nextLine();
        String json = apiRequest.obtainRawData(URL_Base + nameBook.replace(" ", "+"));
        ResultsData data = converter.obtainData(json, ResultsData.class);

        if (data.results() != null && !data.results().isEmpty()) {
            BookData firstBookData = data.results().getFirst();
            bookService.saveBook(firstBookData);
        } else {
            System.out.println("Libro no encontrado en la API");
        }
    }

    private void listBooks() {
        List<Book> books = bookService.listRegisteredBooks();

        if (books.isEmpty()) {
            System.out.println("No existen libros registrados");
        } else {
            System.out.println("--- LIBROS REGISTRADOS ---");

            books.forEach(System.out::println);
        }

    }
}

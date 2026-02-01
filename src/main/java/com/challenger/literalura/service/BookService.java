package com.challenger.literalura.service;

import com.challenger.literalura.model.Author;
import com.challenger.literalura.model.AuthorData;
import com.challenger.literalura.model.Book;
import com.challenger.literalura.model.BookData;
import com.challenger.literalura.repository.AuthorRepository;
import com.challenger.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public void saveBook(BookData bookData){
        Optional<Book> existingBook = bookRepository.findByGutendexId(bookData.gutendexId());

        if (existingBook.isPresent()) {
            System.out.println("El libro " + bookData.title() + " ya fue registrado");
            return;
        }

        AuthorData firstAuthorData = bookData.authors().getFirst();

        Author author = authorRepository.findByNameIgnoreCase(firstAuthorData.name())
                .orElseGet(() -> {
                    Author newAuthor = new Author(firstAuthorData);
                    return authorRepository.save(newAuthor);
                });

        Book book = new Book(bookData);
        book.setAuthor(author);

        bookRepository.save(book);

        System.out.println(book);
    }

    public List<Book> listRegisteredBooks() {
        return bookRepository.findAll();
    }

    public List<Book> listBooksByLanguages(String language) {
        return bookRepository.findByLanguage(language);
    }
}

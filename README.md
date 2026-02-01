# LiterAlura - Book Catalog & Management System

LiterAlura is a Java-based console application developed as part of a programming challenge. It allows users to interact with the **Gutendex API** to search for books, retrieve metadata, and persist the information into a relational database (**PostgreSQL**).



## 🚀 Features

* **Book Search by Title:** Fetch data directly from the Gutendex API and store it locally.
* **Duplicate Prevention:** Automatically checks if a book is already registered before saving.
* **Author Management:** Handles Author data separately, including birth and death years.
* **Data Persistence:** Full integration with PostgreSQL using Spring Data JPA.
* **Advanced Filtering:**
    * List all registered books.
    * List all registered authors.
    * Filter authors alive in a specific year.
    * Filter books by language (e.g., 'es', 'en', 'fr').

## 🛠️ Tech Stack

* **Java 17+**
* **Spring Boot 3.x**
* **Spring Data JPA** (Hibernate)
* **PostgreSQL** (Database)
* **Jackson** (JSON Deserialization)
* **Gutendex API** (External Data Source)



## 📂 Project Structure

The project follows a clean architecture pattern:
* `model`: Contains JPA Entities (`Book`, `Author`) and DTOs/Records (`BookData`, `ResultsData`).
* `repository`: Interfaces for database communication.
* `service`: Business logic layer (API consumption, Data conversion, and DB operations).
* `view`: User interface layer (Console menu and interaction).

## ⚙️ Configuration

1.  **Database Setup:** Create a database in PostgreSQL named `literalura`.
2.  **Application Properties:** Update `src/main/resources/application.properties` with your credentials:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```

## 🖥️ How to Run

1.  Clone the repository.
2.  Ensure you have Maven installed.
3.  Run the application using your IDE or terminal:
    ```bash
    mvn spring-boot:run
    ```

## 📝 Example Usage

When you run the app, you'll see a menu like this:
```text
1 - Search book by title
2 - List registered books
3 - List registered authors
4 - List books by language
5 - List authors alive in a specific year
0 - Exit
```
Developed as part of the Alura Latam - Oracle Next Education (ONE) program.
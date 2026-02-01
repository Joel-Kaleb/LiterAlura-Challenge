package com.challenger.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long gutendexId;
    private String title;
    private String language;
    private Integer downloads;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(){}

    public Book(BookData bookData){
        this.gutendexId = bookData.gutendexId();
        this.title = bookData.title();
        this.language = (bookData.languages() != null && !bookData.languages().isEmpty())
                ? bookData.languages().getFirst()
                : "Desconocido";
        this.downloads = bookData.downloads();
    }

    // Getters
    public Long getId() {return id;}
    public Long getGutendexId() {return gutendexId;}
    public String getTitle() {return title;}
    public String getLanguages() {return language;}
    public Integer getDownloads() {return downloads;}
    public Author getAuthor() {return author;}

    // Setters
    public void setGutendexId(Long gutendexId) {this.gutendexId = gutendexId;}
    public void setTitle(String title) {this.title = title;}
    public void setLanguages(String languages) {this.language = languages;}
    public void setDownloads(Integer downloads) {this.downloads = downloads;}
    public void setAuthor(Author author) {this.author = author;}

    @Override
    public String toString() {
        return String.format(
                "----- LIBRO -----%n" +
                        "Título: %s%n" +
                        "Autor: %s%n" +
                        "Idioma: %s%n" +
                        "Descargas: %d%n" +
                        "-----------------",
                title,
                (author != null ? author.getName() : "Anónimo"),
                language,
                downloads
        );
    }
}

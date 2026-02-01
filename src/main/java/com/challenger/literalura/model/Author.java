package com.challenger.literalura.model;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public Author(){}

    public Author(AuthorData authorData){
        this.name = authorData.name();
        this.birthYear = authorData.birthYear();
        this.deathYear = authorData.deathYear();
    }

    // Getters
    public Long getId() {return id;}
    public String getName() {return name;}
    public Integer getBirthYear() {return birthYear;}
    public Integer getDeathYear() {return deathYear;}
    public List<Book> getBooks() {return books;}

    // Setters
    public void setName(String name) {this.name = name;}
    public void setBirthYear(Integer birthYear) {this.birthYear = birthYear;}
    public void setDeathYear(Integer deathYear) {this.deathYear = deathYear;}

    public void setBooks(List<Book> books) {
        books.forEach(b -> b.setAuthor(this));
        this.books = books;
    }

    @Override
    public String toString() {
        return String.format("Autor: %s (%s - %s)",
                name,
                birthYear != null ? birthYear : "N/A",
                deathYear != null ? deathYear : "Presente");
    }
}

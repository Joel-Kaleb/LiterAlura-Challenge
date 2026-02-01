package com.challenger.literalura.repository;

import com.challenger.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByGutendexId(Long gutendexId);
}

package com.challenger.literalura.repository;

import com.challenger.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    Optional<Author> findByNameIgnoreCase(String name);
}

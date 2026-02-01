package com.challenger.literalura.service;

import com.challenger.literalura.model.Author;
import com.challenger.literalura.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> listRegisteredAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> findAuthorsByYear(int year) {
        return authorRepository.findAuthorsAliveInYear(year);
    }
}

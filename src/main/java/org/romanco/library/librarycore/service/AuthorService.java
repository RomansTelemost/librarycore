package org.romanco.library.librarycore.service;

import org.romanco.library.librarycore.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {

    void createAuthor(Author author);

    Author findById(Long id);

    void deleteById(Long id);

    List<Author> findAll();
}

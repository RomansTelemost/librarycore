package org.romanco.library.librarycore.service;

import org.romanco.library.librarycore.entity.Author;

import java.util.List;

public interface AuthorService {

    void createAuthor(Author author);

    Author findByIdWithBooks(Long id);

    void deleteById(Long id);

    List<Author> findAll(boolean extended);

    void updateAuthor(Author author);
}

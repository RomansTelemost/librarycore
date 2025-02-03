package org.romanco.library.librarycore.service;

import org.romanco.library.librarycore.entity.Author;
import org.springframework.data.domain.Page;

public interface AuthorService {

    void createAuthor(Author author);

    Author findByIdWithBooks(Long id);

    void deleteById(Long id);

    Page<Author> findAll(boolean extended, Integer page, Integer size);

    void updateAuthor(Author author);
}

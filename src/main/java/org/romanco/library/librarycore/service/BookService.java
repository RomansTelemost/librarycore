package org.romanco.library.librarycore.service;

import org.romanco.library.librarycore.entity.Book;

public interface BookService {

    void createBook(Long authorId, Book book);

    void deleteById(Long id);

    Book findById(Long id);
}

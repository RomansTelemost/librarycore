package org.romanco.library.librarycore.repository;

import org.romanco.library.librarycore.entity.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findByAuthorId(Long authorId);
}

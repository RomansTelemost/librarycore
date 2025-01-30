package org.romanco.library.librarycore.repository;

import org.romanco.library.librarycore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}

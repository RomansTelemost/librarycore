package org.romanco.library.librarycore.repository;

import org.romanco.library.librarycore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO book (title, author_id) VALUES (:title, :authorId)", nativeQuery = true)
    void insertBook(@Param("authorId") Long authorId, @Param("title") String title);
}

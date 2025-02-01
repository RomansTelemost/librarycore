package org.romanco.library.librarycore.repository;

import org.romanco.library.librarycore.entity.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "SELECT a FROM Author a left join fetch a.books b")
    List<Author> findAllWithBooks();

    @Query(value = "SELECT a FROM Author a left join fetch a.books b WHERE a.id = :id")
    Optional<Author> findByIdWithBooks(@Param("id") Long id);
}

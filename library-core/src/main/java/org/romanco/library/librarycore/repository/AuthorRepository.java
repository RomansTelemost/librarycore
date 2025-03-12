package org.romanco.library.librarycore.repository;

import org.romanco.library.librarycore.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "SELECT a FROM Author a left join fetch a.bookList b")
    Page<Author> findAllWithBooks(Pageable pageable);

    @Override
    Page<Author> findAll(Pageable pageable);

    @Query(value = "SELECT a FROM Author a left join fetch a.bookList b WHERE a.id = :id")
    Optional<Author> findByIdWithBooks(@Param("id") Long id);
}

package org.romanco.library.librarycore.repository;

import org.romanco.library.librarycore.entity.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Override
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "books")
    List<Author> findAll();

    @Override
    @Query(value = "SELECT a FROM Author a left join fetch a.books b WHERE a.id = :id")
    Optional<Author> findById(@Param("id") Long id);
}

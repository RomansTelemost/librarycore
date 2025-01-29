package org.romanco.library.librarycore.repository;

import org.romanco.library.librarycore.entity.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository2 extends JpaRepository<Author, Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "books")
    List<Author> findAll();
}

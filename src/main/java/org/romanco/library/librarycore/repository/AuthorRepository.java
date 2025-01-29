package org.romanco.library.librarycore.repository;

import org.romanco.library.librarycore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    void save(Author author);

    List<Author> findAll();
    Optional<Author> findById(Long id);

    void deleteById(Long id);
}

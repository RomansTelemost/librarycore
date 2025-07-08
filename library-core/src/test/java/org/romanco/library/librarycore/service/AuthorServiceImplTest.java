package org.romanco.library.librarycore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.romanco.library.librarycore.entity.Author;
import org.romanco.library.librarycore.entity.Book;
import org.romanco.library.librarycore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Testcontainers
@ActiveProfiles({"test"})
class AuthorServiceImplTest {

    private final AuthorService authorService;

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImplTest(AuthorService authorService, AuthorRepository authorRepository) {
        this.authorService = authorService;
        this.authorRepository = authorRepository;
    }

    @Test
    void createAuthor() {
        List<Book> books = new ArrayList<>();

        Author author = new Author(
                "firstName2",
                "lastName2",
                "middleName2",
                LocalDate.of(1970, 10, 02),
                LocalDate.of(1980, 10, 02),
                books);
        authorService.createAuthor(author);

        Optional<Author> authorOptional = authorRepository.findById(author.getId());
        Assertions.assertTrue(authorOptional.isPresent());
    }
}
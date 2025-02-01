package org.romanco.library.librarycore.controller;

import lombok.RequiredArgsConstructor;
import org.romanco.library.librarycore.dto.AuthorDto;
import org.romanco.library.librarycore.entity.Author;
import org.romanco.library.librarycore.mapper.AuthorMapper;
import org.romanco.library.librarycore.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/author")
    public ResponseEntity<Void> createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(AuthorMapper.mapAuthor(authorService.findByIdWithBooks(id)), HttpStatus.OK);
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable(name = "id") Long id) {
        authorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return new ResponseEntity<>(authorService.findAllWithBooks().stream()
                .map(AuthorMapper::mapAuthor)
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @PutMapping("/author")
    public ResponseEntity<Void> updateAuthor(@RequestBody Author author) {
        authorService.updateAuthor(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

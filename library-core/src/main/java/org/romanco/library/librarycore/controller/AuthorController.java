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
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @PostMapping("/author")
    public ResponseEntity<Void> createAuthor(@RequestBody AuthorDto authorDto) {
        authorService.createAuthor(authorMapper.toEntity(authorDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(
                authorMapper.toDto(authorService.findByIdWithBooks(id)),
                HttpStatus.OK);
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable(name = "id") Long id) {
        authorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorDto>> getAllAuthors(
            @RequestParam(name = "extended") boolean extended,
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size") Integer size) {
        Function<Author, AuthorDto> function;
        if (extended) {
            function = authorMapper::toDtoWithBooks;
        } else {
            function = authorMapper::toDto;
        }
        return new ResponseEntity<>(authorService.findAll(extended, page, size).getContent().stream()
                .map(function)
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @PutMapping("/author")
    public ResponseEntity<Void> updateAuthor(@RequestBody AuthorDto authorDto) {
        authorService.updateAuthor(authorMapper.toEntity(authorDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

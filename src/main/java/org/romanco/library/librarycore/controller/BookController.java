package org.romanco.library.librarycore.controller;

import lombok.RequiredArgsConstructor;
import org.romanco.library.librarycore.dto.BookDto;
import org.romanco.library.librarycore.mapper.BookMapper;
import org.romanco.library.librarycore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @PostMapping("author/{authorId}/book")
    public ResponseEntity<Void> createBook(@PathVariable (name = "authorId") Long authorId, @RequestBody BookDto bookDto) {
        bookService.createBook(authorId, bookMapper.toEntity(bookDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable(name = "id") Long id) {
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDto> findById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(bookMapper.toDto(bookService.findById(id)), HttpStatus.OK);
    }
}

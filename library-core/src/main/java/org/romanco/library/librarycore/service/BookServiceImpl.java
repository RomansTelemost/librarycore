package org.romanco.library.librarycore.service;

import lombok.RequiredArgsConstructor;
import org.romanco.library.librarycore.entity.Book;
import org.romanco.library.librarycore.exception.AuthorNotFoundException;
import org.romanco.library.librarycore.exception.BookNotFoundException;
import org.romanco.library.librarycore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorService authorService;
    private final BookRepository bookRepository;

    @Override
    public void createBook(Long authorId, Book book) {
        Optional.ofNullable(authorId).orElseThrow(AuthorNotFoundException::new);
        authorService.findByIdWithBooks(authorId);
        bookRepository.insertBook(authorId, book.getTitle());
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }
}

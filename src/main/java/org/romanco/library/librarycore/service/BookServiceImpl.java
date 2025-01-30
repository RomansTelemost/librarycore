package org.romanco.library.librarycore.service;

import lombok.RequiredArgsConstructor;
import org.romanco.library.librarycore.entity.Book;
import org.romanco.library.librarycore.exception.AuthorNotFoundException;
import org.romanco.library.librarycore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorService authorService;
    private final BookRepository bookRepository;

    @Override
    public void createBook(Book book) {
        Optional.ofNullable(book.getAuthor()).orElseThrow(AuthorNotFoundException::new);
        authorService.findById(book.getAuthor().getId());
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}

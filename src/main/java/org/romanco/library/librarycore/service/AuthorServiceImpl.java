package org.romanco.library.librarycore.service;

import lombok.RequiredArgsConstructor;
import org.romanco.library.librarycore.entity.Author;
import org.romanco.library.librarycore.entity.Book;
import org.romanco.library.librarycore.exception.AuthorNotFoundException;
import org.romanco.library.librarycore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void updateAuthor(Author author) {
        Optional<Author> findAuthorOpt = authorRepository.findById(author.getId());

        if (findAuthorOpt.isPresent()) {
            Author findAuthor = findAuthorOpt.get();
            findAuthor.setFirstName(author.getFirstName());
            findAuthor.setMiddleName(author.getMiddleName());
            findAuthor.setLastName(author.getLastName());
            findAuthor.setBirthday(author.getBirthday());
            findAuthor.setDeathDate(author.getDeathDate());

            List<Book> books = new ArrayList<>();
            for (Book book : author.getBooks()) {
                book.setAuthor(author);
                books.add(book);
            }
            findAuthor.setBooks(books);
        }
        authorRepository.save(author);
    }
}

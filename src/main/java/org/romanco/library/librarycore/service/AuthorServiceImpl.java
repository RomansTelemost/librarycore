package org.romanco.library.librarycore.service;

import lombok.RequiredArgsConstructor;
import org.romanco.library.librarycore.entity.Author;
import org.romanco.library.librarycore.exception.AuthorNotFoundException;
import org.romanco.library.librarycore.repository.AuthorRepository;
import org.romanco.library.librarycore.repository.AuthorRepository2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository2 authorRepository;

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
        List<Author> authors = authorRepository.findAll();
        System.out.println(authors.get(0).getBooks().get(0).getTitle());

        return authors;
    }
}

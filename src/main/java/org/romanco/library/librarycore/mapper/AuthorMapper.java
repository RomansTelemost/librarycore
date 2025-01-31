package org.romanco.library.librarycore.mapper;

import org.romanco.library.librarycore.dto.AuthorDto;
import org.romanco.library.librarycore.entity.Author;

import java.util.stream.Collectors;

public class AuthorMapper {

    public static AuthorDto mapAuthor(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .firstName(author.getFirstName())
                .middleName(author.getMiddleName())
                .lastName(author.getLastName())
                .birthday(author.getBirthday())
                .deathDate(author.getDeathDate())
                .books(author.getBooks().stream()
                        .map(BookMapper::mapBook)
                        .collect(Collectors.toList()))
                .build();
    }
}

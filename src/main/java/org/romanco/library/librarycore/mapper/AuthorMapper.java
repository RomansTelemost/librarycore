package org.romanco.library.librarycore.mapper;

import org.romanco.library.librarycore.dto.AuthorDto;
import org.romanco.library.librarycore.entity.Author;

public class AuthorMapper {

    public static AuthorDto mapAuthor(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .firstName(author.getFirstName())
                .middleName(author.getMiddleName())
                .lastName(author.getLastName())
                .birthday(author.getBirthday())
                .deathDate(author.getDeathDate())
                .books(BookMapper.mapBooks(author.getBooks()))
                .build();
    }
}

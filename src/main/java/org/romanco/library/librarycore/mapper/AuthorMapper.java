package org.romanco.library.librarycore.mapper;

import org.mapstruct.Mapper;
import org.romanco.library.librarycore.dto.AuthorDto;
import org.romanco.library.librarycore.entity.Author;

@Mapper
public interface AuthorMapper {

    AuthorDto toDto(Author author);
}

package org.romanco.library.librarycore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.romanco.library.librarycore.dto.AuthorDto;
import org.romanco.library.librarycore.entity.Author;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AuthorMapper {

    AuthorDto toDto(Author author);
    @Mappings({
            @Mapping(source = "bookList", target = "books")
    })
    AuthorDto toDtoWithBooks(Author author);

    @Mappings({
            @Mapping(source = "books", target = "bookList")
    })
    Author toEntity(AuthorDto authorDto);
}

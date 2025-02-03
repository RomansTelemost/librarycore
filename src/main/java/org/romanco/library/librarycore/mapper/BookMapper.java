package org.romanco.library.librarycore.mapper;

import org.mapstruct.Mapper;
import org.romanco.library.librarycore.dto.BookDto;
import org.romanco.library.librarycore.entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto toDto(Book book);
    Book toEntity(BookDto bookDto);
}

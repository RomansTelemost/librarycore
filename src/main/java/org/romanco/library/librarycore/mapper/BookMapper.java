package org.romanco.library.librarycore.mapper;

import org.romanco.library.librarycore.dto.BookDto;
import org.romanco.library.librarycore.entity.Book;

public class BookMapper {

    public static BookDto mapBook(Book book) {
        return BookDto.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .build();
    }
}

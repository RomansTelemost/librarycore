package org.romanco.library.librarycore.mapper;

import org.romanco.library.librarycore.dto.BookDto;
import org.romanco.library.librarycore.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {

    public static List<BookDto> mapBooks(List<Book> books) {
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book : books) {
            bookDtoList.add(BookDto.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .build());
        }
        return bookDtoList;
    }
}

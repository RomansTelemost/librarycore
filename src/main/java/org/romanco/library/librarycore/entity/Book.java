package org.romanco.library.librarycore.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Book {

    private Long id;
    private String title;
    private Author author;
}

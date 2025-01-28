package org.romanco.library.librarycore.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Author {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthday;
    private LocalDate deathDate;
    private List<Book> books;
}

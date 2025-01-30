package org.romanco.library.librarycore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthday;
    private LocalDate deathDate;

    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;
}

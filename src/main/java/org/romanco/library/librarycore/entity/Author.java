package org.romanco.library.librarycore.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthday;
    private LocalDate deathDate;

    private List<Book> books;

    public Author(AuthorBuilder authorBuilder) {
        if (authorBuilder == null) {
            throw new IllegalArgumentException("AuthorBuilder has not found!");
        }
        this.id = authorBuilder.id;
        this.firstName = authorBuilder.firstName;
        this.lastName = authorBuilder.lastName;
        this.middleName = authorBuilder.middleName;
        this.birthday = authorBuilder.birthday;
        this.deathDate = authorBuilder.deathDate;
        this.books = authorBuilder.books;
    }

    public static class AuthorBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String middleName;
        private LocalDate birthday;
        private LocalDate deathDate;

        private List<Book> books;

        public AuthorBuilder() {
            super();
        }

        public AuthorBuilder authorId(Long id) {
            this.id = id;
            return this;
        }

        public AuthorBuilder authorFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AuthorBuilder authorLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AuthorBuilder authorMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public AuthorBuilder authorBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public AuthorBuilder authorDeathDate(LocalDate deathDate) {
            this.deathDate = deathDate;
            return this;
        }

        public AuthorBuilder authorBooks(List<Book> books) {
            this.books = books;
            return this;
        }

        public Author build() {
            Author author;
            if (validateAuthor()) {
                author = new Author(this);
            } else {
                throw new IllegalArgumentException("Не указаны необходимые параметры");
            }
            return author;
        }
        private boolean validateAuthor() {
            return (id != 0);
        }
    }
}

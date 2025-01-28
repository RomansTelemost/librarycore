package org.romanco.library.librarycore.repository;

import lombok.RequiredArgsConstructor;
import org.romanco.library.librarycore.entity.Author;
import org.romanco.library.librarycore.entity.Book;
import org.romanco.library.librarycore.exception.SqlProcessingException;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final static String INSERT_AUTHOR = "INSERT INTO author(id, firstName, lastName, middleName, birthday, deathDate) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_AUTHOR_BY_ID = "SELECT " +
            "author.id AS author_id, " +
            "author.first_name, " +
            "author.last_name, " +
            "author.middle_name, " +
            "author.birthday, " +
            "author.death_date, " +
            "book.id AS book_id, " +
            "book.title " +
            "FROM author " +
            "LEFT JOIN book ON author.id = book.author_id " +
            "WHERE author_id = ?";
    private static final String SELECT_ALL_AUTHOR = "SELECT " +
            "author.id AS author_id, " +
            "author.first_name, " +
            "author.last_name, " +
            "author.middle_name, " +
            "author.birthday, " +
            "author.death_date, " +
            "book.id AS book_id, " +
            "book.title " +
            "FROM author " +
            "LEFT JOIN book ON author.id = book.author_id";
    private final static String DELETE_BY_ID = "DELETE FROM author where id = ?";

    private final DataSource dataSource;

    @Override
    public void save(Author author) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_AUTHOR)) {

            statement.setLong(1, author.getId());
            statement.setString(2, author.getFirstName());
            statement.setString(3, author.getLastName());
            statement.setString(4, author.getMiddleName());
            statement.setTimestamp(5, Timestamp.valueOf(author.getBirthday().atStartOfDay()));
            statement.setTimestamp(6, Timestamp.valueOf(author.getDeathDate().atStartOfDay()));

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Author> findAll() {
        Map<Long, Author> authorResult = new HashMap<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHOR)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Book book = fillBook(rs);
                Long authorId = rs.getLong("author_id");
                Author author;
                if (authorResult.containsKey(authorId)) {
                    author = authorResult.get(authorId);
                } else {
                    author = fillAuthor(rs);
                    authorResult.put(authorId, author);
                }
                author.getBooks().add(book);
            }
            return new ArrayList<>(authorResult.values());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Author> findById(Long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AUTHOR_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            Author author = null;
            while (rs.next()) {
                if (author == null) {
                    author = fillAuthor(rs);
                }
                author.getBooks().add(fillBook(rs));
            }
            return Optional.ofNullable(author);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SqlProcessingException(e);
        }
    }

    private Author fillAuthor(ResultSet rs) throws SQLException {
        Author author = new Author();
        author.setId(rs.getLong("author_id"));
        author.setFirstName(rs.getString("first_name"));
        author.setLastName(rs.getString("last_name"));
        author.setMiddleName(rs.getString("middle_name"));
//                author.setBirthday(rs.getDate("id"));
//                author.setDeathDate(rs.getDate("id"));
        author.setBooks(new ArrayList<>());
        return author;
    }

    private Book fillBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getLong("book_id"));
        book.setTitle(rs.getString("title"));
        return book;
    }
}

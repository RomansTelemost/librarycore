package org.romanco.library.librarycore.repository;

import lombok.RequiredArgsConstructor;
import org.romanco.library.librarycore.entity.Author;
import org.romanco.library.librarycore.exception.SqlProcessingException;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final static String INSERT_AUTHOR = "INSERT INTO author(id, firstName, lastName, middleName, birthday, deathDate) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_AUTHOR_BY_ID = "SELECT * FROM author WHERE id = ?";
    private static final String SELECT_ALL_AUTHOR = "SELECT * FROM author";
    private final static String DELETE_BY_ID = "DELETE FROM author where id = ?";

    private final DataSource dataSource;

    private final BookRepository bookRepository;

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
        List<Author> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHOR)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result.add(fillAuthor(rs));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Author> findById(Long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AUTHOR_BY_ID)) {

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(fillAuthor(rs));
            }
            return Optional.empty();
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

    private Author fillAuthor(ResultSet rs) throws SQLException{
        Author author = new Author();
        author.setId(rs.getLong("id"));
        author.setFirstName(rs.getString("first_name"));
        author.setLastName(rs.getString("last_name"));
        author.setMiddleName(rs.getString("middle_name"));
//                author.setBirthday(rs.getDate("id"));
//                author.setDeathDate(rs.getDate("id"));
        author.setBooks(bookRepository.findByAuthorId(author.getId()));
        return author;
    }
}

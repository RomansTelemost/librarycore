package org.romanco.library.librarycore.repository;

import lombok.RequiredArgsConstructor;
import org.romanco.library.librarycore.entity.Author;
import org.romanco.library.librarycore.entity.Book;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private static final String FIND_BY_AUTHOR_ID = "SELECT id, title FROM book WHERE author_id = ?";

    private final DataSource dataSource;

    @Override
    public List<Book> findByAuthorId(Long authorId) {
        List<Book> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_AUTHOR_ID)) {
            preparedStatement.setLong(1, authorId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Book book = Book.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .build();
                result.add(book);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.amponsem.librarymanagementsystem.services;

import com.amponsem.librarymanagementsystem.models.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {
    private Connection connection;

    @BeforeEach
    public void setUp() throws SQLException {
        String url = "jdbc:h2:mem:testdb";
        String user = "sa";
        String password = "";

        BookService.setDatabaseConfig(url, user, password);
        connection = DriverManager.getConnection(url, user, password);
        createTables();
    }

    private void createTables() throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            // Drop tables if they exist
            stmt.execute("DROP TABLE IF EXISTS book");
            stmt.execute("DROP TABLE IF EXISTS category");

            // Create tables
            String createCategoryTable = "CREATE TABLE category (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL" +
                    ")";

            String createBookTable = "CREATE TABLE book (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "title VARCHAR(255) NOT NULL, " +
                    "category_id INT, " +
                    "publication_date DATE, " +
                    "copies_owned INT, " +
                    "FOREIGN KEY (category_id) REFERENCES category(id)" +
                    ")";

            stmt.execute(createCategoryTable);
            stmt.execute(createBookTable);

            // Insert initial category data
            String insertCategory = "INSERT INTO category (id, name) VALUES (1, 'Test Category')";
            stmt.execute(insertCategory);
        }
    }

    @AfterEach
    public void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    public void testSaveBookToDatabase() throws SQLException {
        BookService.saveBookToDatabase("Test Book", 1, LocalDate.of(2023, 1, 1), 10);

        String query = "SELECT COUNT(*) FROM book WHERE title = 'Test Book' AND category_id = 1 AND publication_date = '2023-01-01' AND copies_owned = 10";
        try (Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(query)) {
            resultSet.next();
            int count = resultSet.getInt(1);
            assertEquals(1, count);
        }
    }

    @Test
    public void testUpdateBook() throws SQLException {
        BookService.saveBookToDatabase("Test Book", 1, LocalDate.of(2023, 1, 1), 10);

        String selectQuery = "SELECT * FROM book WHERE title = 'Test Book'";
        Book book;
        try (Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(selectQuery)) {
            assertTrue(resultSet.next());
            book = new Book(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getInt("category_id"),
                    resultSet.getDate("publication_date").toLocalDate(),
                    resultSet.getInt("copies_owned"),
                    "Test Category"
            );
        }

        book.setTitle("Updated Book");
        book.setCopiesOwned(20);
        boolean updated = BookService.updateBook(book);
        assertTrue(updated);

        String query = "SELECT * FROM book WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, book.getId());
            try (ResultSet resultSet = pstmt.executeQuery()) {
                assertTrue(resultSet.next());
                assertEquals("Updated Book", resultSet.getString("title"));
                assertEquals(20, resultSet.getInt("copies_owned"));
            }
        }
    }

    @Test
    public void testGetAllBooks() throws SQLException {
        BookService.saveBookToDatabase("Test Book 1", 1, LocalDate.of(2023, 1, 1), 10);
        BookService.saveBookToDatabase("Test Book 2", 1, LocalDate.of(2023, 2, 1), 5);

        List<Book> books = BookService.getAllBooks();
        assertEquals(2, books.size());
    }

    @Test
    public void testDeleteBook() throws SQLException {
        BookService.saveBookToDatabase("Test Book", 1, LocalDate.of(2023, 1, 1), 10);

        String selectQuery = "SELECT * FROM book WHERE title = 'Test Book'";
        int bookId;
        try (Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(selectQuery)) {
            assertTrue(resultSet.next());
            bookId = resultSet.getInt("id");
        }

        boolean deleted = BookService.deleteBook(bookId);
        assertTrue(deleted);

        String query = "SELECT COUNT(*) FROM book WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, bookId);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                resultSet.next();
                int count = resultSet.getInt(1);
                assertEquals(0, count);
            }
        }
    }
}

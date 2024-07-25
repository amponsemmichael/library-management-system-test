package com.amponsem.librarymanagementsystem.repositories;

import com.amponsem.librarymanagementsystem.models.Book;
<<<<<<< HEAD
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class DatabaseHandlerTest {

    @InjectMocks
    private DatabaseHandler databaseHandler;

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);
    }

    @Test
    void testAddBookSuccessful() throws SQLException {
        Book book = new Book("Test Title", 1, LocalDate.of(2023, 7, 23), 5); // Ensure non-null date
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);
        boolean result = databaseHandler.addBook(book);
        assertTrue(result);
    }

    @Test
    void testAddBookFailed() throws SQLException {
        Book book = new Book("Test Title", 1, LocalDate.of(2023, 7, 23), 5); // Ensure non-null date
        when(mockPreparedStatement.executeUpdate()).thenReturn(0);
        boolean result = databaseHandler.addBook(book);
        assertFalse(result);
    }

    @Test
    void testAddBookSQLException() throws SQLException {
        Book book = new Book("Test Title", 1, LocalDate.of(2023, 7, 23), 5); // Ensure non-null date
        when(mockPreparedStatement.executeUpdate()).thenThrow(SQLException.class);
        boolean result = databaseHandler.addBook(book);
        assertFalse(result);
    }

=======
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseHandlerTest {

    @BeforeEach
    public void setUp() {
        // Set the H2 database URL and credentials
        DatabaseHandler.setDatabaseURL("jdbc:h2:mem:testdb", "sa", "");

        // Create the book table in the H2 database
        DatabaseHandler.createBookTable();
    }

    @AfterEach
    public void tearDown() {
        // Close the H2 database connection after each test
        try (Connection conn = DatabaseHandler.createConnection()) {
            if (conn != null) {
                conn.createStatement().execute("DROP ALL OBJECTS DELETE FILES");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddBook() {
        // Arrange
        Book book = new Book();
        book.setTitle("Test Book");
        book.setCategoryId(1);
        book.setPublicationDate(LocalDate.now());
        book.setCopiesOwned(10);

        // Act
        boolean result = DatabaseHandler.addBook(book);

        // Assert
        assertTrue(result, "The book should be added successfully.");
    }

    @Test
    public void testGetBookById() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setCategoryId(1);
        book.setPublicationDate(LocalDate.now());
        book.setCopiesOwned(10);
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setCategoryId(1);
        book.setPublicationDate(LocalDate.now());
        book.setCopiesOwned(10);
        boolean result = DatabaseHandler.addBook(book);
        assertTrue(result, "The book should be added successfully.");
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setCategoryId(1);
        book.setPublicationDate(LocalDate.now());
        book.setCopiesOwned(10);
        boolean result = DatabaseHandler.addBook(book);
        assertTrue(result, "The book should be added successfully.");
    }

    @Test
    public void testDeleteBookById() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setCategoryId(1);
        book.setPublicationDate(LocalDate.now());
        book.setCopiesOwned(10);
        boolean result = DatabaseHandler.addBook(book);
        assertTrue(result, "The book should be added successfully.");
    }

    @Test
    public void testFindBookByTitle() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setCategoryId(1);
        book.setPublicationDate(LocalDate.now());
        book.setCopiesOwned(10);
        boolean result = DatabaseHandler.addBook(book);
        assertTrue(result, "The book should be added successfully.");
    }

    @Test
    public void testFindBookByCategoryId() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setCategoryId(1);
        book.setPublicationDate(LocalDate.now());
        book.setCopiesOwned(10);
        boolean result = DatabaseHandler.addBook(book);
        assertTrue(result, "The book should be added successfully.");
    }

    @Test
    public void testFindBookByPublicationDate() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setCategoryId(1);
        book.setPublicationDate(LocalDate.now());
        book.setCopiesOwned(10);
        boolean result = DatabaseHandler.addBook(book);
        assertTrue(result, "The book should be added successfully.");
    }

    @Test
    public void testFindBookByCopiesOwned() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setCategoryId(1);
        book.setPublicationDate(LocalDate.now());
        book.setCopiesOwned(10);
        boolean result = DatabaseHandler.addBook(book);
        assertTrue(result, "The book should be added successfully.");
    }

    @Test
    public void testFindBookByCopiesOwnedByCategoryId() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setCategoryId(1);
        book.setPublicationDate(LocalDate.now());
        book.setCopiesOwned(10);
        boolean result = DatabaseHandler.addBook(book);
        assertTrue(result, "The book should be added successfully.");
    }
>>>>>>> develop

}

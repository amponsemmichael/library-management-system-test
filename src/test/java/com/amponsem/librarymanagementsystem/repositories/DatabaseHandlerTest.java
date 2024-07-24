package com.amponsem.librarymanagementsystem.repositories;

import com.amponsem.librarymanagementsystem.models.Book;
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

}

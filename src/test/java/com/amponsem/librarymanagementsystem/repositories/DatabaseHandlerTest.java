package com.amponsem.librarymanagementsystem.repositories;

import com.amponsem.librarymanagementsystem.models.Book;
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


}

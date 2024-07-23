package com.amponsem.librarymanagementsystem.repositories;

import com.amponsem.librarymanagementsystem.models.Book;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseHandler {

    private static DatabaseHandler handler = null;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/librarydb";
    private static final String USER = "root";
    private static final String PASSWORD = "micky!!@@020";
    private Connection conn = null;

    private DatabaseHandler() {
        createConnection();
    }

    public static DatabaseHandler getInstance() {
        if (handler == null) {
            handler = new DatabaseHandler();
        }
        return handler;
    }

    void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

     public Connection getConnection(){
        return conn;
     }
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean addBook(Book book) {
        String query = "INSERT INTO book (title, category_id, publication_date, copies_owned) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, book.getTitle());
            stmt.setInt(2, book.getCategoryId());
            LocalDate pubDate = book.getPublicationDate();
            if (pubDate != null) {
                stmt.setDate(3, Date.valueOf(pubDate));
            } else {
                stmt.setNull(3, Types.DATE); // Set null for SQL DATE type
            }
            stmt.setInt(4, book.getCopiesOwned());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}

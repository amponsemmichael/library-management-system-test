package com.amponsem.librarymanagementsystem.services;

import com.amponsem.librarymanagementsystem.models.Book;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private static String url = "jdbc:mysql://localhost:3306/librarydb";
    private static String user = "root";
    private static String password = "micky!!@@020";

    public static void setDatabaseConfig(String dbUrl, String dbUser, String dbPassword) {
        url = dbUrl;
        user = dbUser;
        password = dbPassword;
    }

    public static void saveBookToDatabase(String title, int categoryId, LocalDate publicationDate, int copiesOwned) {
        String sql = "INSERT INTO book (title, category_id, publication_date, copies_owned) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setInt(2, categoryId);
            pstmt.setDate(3, java.sql.Date.valueOf(publicationDate));
            pstmt.setInt(4, copiesOwned);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean updateBook(Book book) throws SQLException {
        String query = "UPDATE book SET title = ?, category_id = ?, publication_date = ?, copies_owned = ? WHERE id = ?";
        Connection conn = DriverManager.getConnection(url, user, password);
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, book.getTitle());
            stmt.setInt(2, book.getCategoryId());
            stmt.setDate(3, Date.valueOf(book.getPublicationDate()));
            stmt.setInt(4, book.getCopiesOwned());
            stmt.setInt(5, book.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Book> getAllBooks() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM book";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setCategoryId(rs.getInt("category_id"));
                book.setPublicationDate(rs.getDate("publication_date").toLocalDate());
                book.setCopiesOwned(rs.getInt("copies_owned"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static boolean deleteBook(int bookId) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        String query = "DELETE FROM book WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, bookId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

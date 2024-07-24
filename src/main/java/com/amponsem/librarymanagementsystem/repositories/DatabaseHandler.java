package com.amponsem.librarymanagementsystem.repositories;

import com.amponsem.librarymanagementsystem.models.Book;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseHandler {

    //private static DatabaseHandler handler = null;
    private static String DB_URL = "jdbc:mysql://localhost:3306/librarydb";
    private static String USER = "root";
    private static String PASSWORD = "micky!!@@020";
    //private Connection conn = null;


    public static void setDatabaseURL(String url, String user, String password) {
        DB_URL = url;
        USER = user;
        PASSWORD = password;
    }

    public static Connection createConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Database connection established");
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
        return conn;
    }

//    public static void createBookTable() {
//        String createTable = "CREATE TABLE IF NOT EXISTS book ("
//                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
//                + "title VARCHAR(255) NOT NULL,"
//                + "categoryId INTEGER NOT NULL,"
//                + "publicationDate DATE NOT NULL,"
//                + "copiesOwned INTEGER NOT NULL"+
//        ");";
//
//        try{
//            Statement stmt = createConnection().createStatement();
//            stmt.executeUpdate(createTable);
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//    }

    public static void createBookTable() {
        // Adjust the SQL statement for the specific RDBMS
        String createTable = "CREATE TABLE IF NOT EXISTS book ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "title VARCHAR(255) ,"
                + "category_id INT NOT NULL,"
                + "publication_date DATE,"
                + "copies_owned INT NOT NULL"
                + ");";

        try (Statement stmt = createConnection().createStatement()) {
            stmt.executeUpdate(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static boolean addBook(Book book) {
        String query = "INSERT INTO book (title, category_id, publication_date, copies_owned) VALUES (?, ?, ?, ?)";
        Connection conn = createConnection();
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

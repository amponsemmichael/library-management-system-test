
package com.amponsem.librarymanagementsystem.controllers;

import com.amponsem.librarymanagementsystem.models.Book;
import com.amponsem.librarymanagementsystem.repositories.DatabaseHandler;
import com.amponsem.librarymanagementsystem.services.BookService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
<<<<<<< HEAD
=======
import java.sql.Connection;
>>>>>>> develop
import java.sql.SQLException;
import java.util.Optional;

public class BookListController {

    @FXML
    private TableView<Book> bookTableView;

    private final ObservableList<Book> bookData = FXCollections.observableArrayList();

<<<<<<< HEAD
    private DatabaseHandler databaseHandler;
=======
    private static Connection databaseHandler;
>>>>>>> develop
    private BookService bookService;

    @FXML
    public void initialize() throws SQLException {
<<<<<<< HEAD
        databaseHandler = DatabaseHandler.getInstance();
=======
        databaseHandler = DatabaseHandler.createConnection();
>>>>>>> develop
        bookService = new BookService();

        // Initialize columns
        bookTableView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        bookTableView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("title"));
        bookTableView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("publicationDate"));
        bookTableView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        bookTableView.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("copiesOwned"));

        // Load data
        loadBooks();
    }

    private void loadBooks() throws SQLException {
        bookData.clear();
        bookData.addAll(bookService.getAllBooks());
        bookTableView.setItems(bookData);
    }

    // Add Code to open AddBook dialog and add a book
    @FXML
    private void handleAddBook(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/amponsem/librarymanagementsystem/views/AddBookView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);

            AddBookController controller = loader.getController();
            controller.setStage(stage); // Set the stage in AddBookController if necessary

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception loading FXML or initializing stage
        }
    }

    // Add Code to open EditBook dialog and edit a book
    @FXML
    private void handleEditBook() {
        Book selectedBook = bookTableView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/amponsem/librarymanagementsystem/views/EditBookView.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Edit Book");
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(new Scene(loader.load()));

                EditBookController controller = loader.getController();
                controller.setStage(stage);
                controller.setBook(selectedBook);
                stage.showAndWait();
                loadBooks();  // Refresh the table view after editing a book
            } catch (IOException | SQLException e) {
                e.printStackTrace();
                showAlert("Error", "Failed to load the Edit Book view.");
            }
        } else {
            showAlert("No Selection", "Please select a book to edit.");
        }
    }

    // Add Code to delete the selected book
    @FXML
    private void handleDeleteBook() throws SQLException {
        Book selectedBook = bookTableView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Deletion");
            alert.setHeaderText("Are you sure you want to delete the selected book?");
            alert.setContentText("This action cannot be undone.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                bookService.deleteBook(selectedBook.getId());
                loadBooks();  // Refresh the table view after deleting a book
            }
        } else {
            showAlert("No Selection", "Please select a book to delete.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


}


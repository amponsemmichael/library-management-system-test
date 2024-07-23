package com.amponsem.librarymanagementsystem.controllers;

import com.amponsem.librarymanagementsystem.models.Book;
import com.amponsem.librarymanagementsystem.repositories.DatabaseHandler;
import com.amponsem.librarymanagementsystem.services.BookService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class EditBookController {

    @FXML
    private TextField titleField;
    @FXML
    private TextField publicationDateField;
    @FXML
    private TextField categoryField;
    @FXML
    private TextField copiesOwnedField;

    private Stage stage;
    private Book book;
    private DatabaseHandler databaseHandler;

    @FXML
    private void initialize() {
        databaseHandler = DatabaseHandler.getInstance();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setBook(Book book) {
        this.book = book;
        titleField.setText(book.getTitle());
        publicationDateField.setText(String.valueOf(book.getPublicationDate()));
        categoryField.setText(book.getCategoryName());
        copiesOwnedField.setText(String.valueOf(book.getCopiesOwned()));
    }

    @FXML
    private void handleSave() {
        String title = titleField.getText();
        String publicationDate = publicationDateField.getText();
        String category = categoryField.getText();
        String copiesOwnedText = copiesOwnedField.getText();

        if (title.isEmpty() || publicationDate.isEmpty() || category.isEmpty() || copiesOwnedText.isEmpty()) {
            showAlert("Invalid Fields", "Please fill all fields.");
            return;
        }

        try {
            int copiesOwned = Integer.parseInt(copiesOwnedText);
            LocalDate pubDate = LocalDate.parse(publicationDate);

            book.setTitle(title);
            book.setPublicationDate(pubDate);
            book.setCategoryName(category);
            book.setCopiesOwned(copiesOwned);

            BookService.updateBook(book);
            stage.close();
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid number for copies owned.");
        } catch (DateTimeParseException e) {
            showAlert("Invalid Input", "Please enter a valid date (yyyy-mm-dd).");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleCancel() {
        stage.close();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

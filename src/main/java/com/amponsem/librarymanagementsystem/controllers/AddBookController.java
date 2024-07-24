package com.amponsem.librarymanagementsystem.controllers;

import com.amponsem.librarymanagementsystem.services.BookService;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class AddBookController {

    @FXML
    private TextField titleField;
    @FXML
    private TextField categoryIdField;
    @FXML
    private DatePicker publicationDatePicker;
    @FXML
    private TextField copiesOwnedField;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void handleSave() {
        String title = titleField.getText();
        int categoryId = Integer.parseInt(categoryIdField.getText());
        LocalDate publicationDate = publicationDatePicker.getValue();
        int copiesOwned = Integer.parseInt(copiesOwnedField.getText());


        BookService.saveBookToDatabase(title, categoryId, publicationDate, copiesOwned);
    }

    @FXML
    private void handleCancel() {
        stage.close();
    }
}



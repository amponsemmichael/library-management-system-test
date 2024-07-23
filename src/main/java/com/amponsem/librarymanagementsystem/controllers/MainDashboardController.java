package com.amponsem.librarymanagementsystem.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class MainDashboardController {

    private Stage primaryStage;

    @FXML
    private void handleManageBooks(ActionEvent event) {
        loadView("/com/amponsem/librarymanagementsystem/views/BookListView.fxml");
    }

    @FXML
    private void handleManageAuthors(ActionEvent event) {
        loadView("/com/amponsem/librarymanagementsystem/views/AuthorListView.fxml");
    }

    @FXML
    private void handleManageMembers(ActionEvent event) {
        loadView("/com/amponsem/librarymanagementsystem/views/MemberListView.fxml");
    }

    @FXML
    private void handleManageReservations(ActionEvent event) {
        loadView("/com/amponsem/librarymanagementsystem/views/ReservationListView.fxml");
    }

    @FXML
    private void handleManageFinePayments(ActionEvent event) {
        loadView("/com/amponsem/librarymanagementsystem/views/FinePaymentListView.fxml");
    }

    @FXML
    private void handleManageLoans(ActionEvent event) {
        loadView("/com/amponsem/librarymanagementsystem/views/LoanListView.fxml");
    }

    @FXML
    private void handleManageFines(ActionEvent event) {
        loadView("/com/amponsem/librarymanagementsystem/views/FineListView.fxml");
    }

    @FXML
    private void handleAddBookClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/AddBookView.fxml"));
            Parent root = loader.load();
            AddBookController addBookController = loader.getController();
            addBookController.setStage(primaryStage);

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add New Book");
            dialogStage.setScene(new Scene(root));
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            showErrorDialog("Error loading Add Book dialog", "An error occurred while loading the Add Book dialog.");
        }
    }

    private void showErrorDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void loadView(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


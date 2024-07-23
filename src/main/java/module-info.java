
module com.amponsem.librarymanagementsystem {
        requires javafx.controls;
        requires javafx.fxml;
        requires javafx.base;
        requires java.sql;
    requires mysql.connector.j;

    opens com.amponsem.librarymanagementsystem to javafx.fxml;
        opens com.amponsem.librarymanagementsystem.models to javafx.base;

        exports com.amponsem.librarymanagementsystem;
        exports com.amponsem.librarymanagementsystem.controllers;
        opens com.amponsem.librarymanagementsystem.controllers to javafx.fxml;
}


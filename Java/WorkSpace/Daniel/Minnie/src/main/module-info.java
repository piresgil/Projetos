module main.aplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens main.aplication to javafx.fxml;
    exports main.aplication;
    exports main.aplication.controller;
    opens main.aplication.controller to javafx.fxml;
}
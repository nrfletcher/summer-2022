// Various methods to allow logout confirmation in a cleaner GUI format

package com.example.firstapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("first.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(event -> logout(stage));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void logout(Stage stage) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); // Gives us a secondary window for confirmation
        alert.setTitle("Alert");
        alert.setHeaderText("Caution: logging out");
        alert.setContentText("Confirm logout");

        if(alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("Logged out.");
            stage.close();
        }
    }
}

package com.example.firstapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FirstController {

    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane scenePane;

    Stage stage;

    public void logout(ActionEvent e) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); // Gives us a secondary window for confirmation
        alert.setTitle("Alert");
        alert.setHeaderText("Caution: logging out");
        alert.setContentText("Confirm logout");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Logged out.");
            stage.close();
        }
    }
}

// FXML
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.layout.AnchorPane?>

<AnchorPane fx:id="scenePane" maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/18" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.firstapp.FirstController">
   <children>
      <Button fx:id="logoutButton" layoutX="274.0" layoutY="188.0" mnemonicParsing="false" onAction="#logout" text="Logout" />
   </children>
</AnchorPane>

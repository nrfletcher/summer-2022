package com.example.firstapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}



package com.example.firstapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class FirstController {

    @FXML
    TextField nameTextField;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void login(ActionEvent event) throws IOException {

        String userName = nameTextField.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
        root = loader.load();

        SecondController scene2 = loader.getController();
        scene2.displayName(userName);

        // root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("first.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}



package com.example.firstapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SecondController {

    @FXML
    Label nameLabel;

    public void displayName(String name) {
        nameLabel.setText("Hello " + name);
    }
}


// Controller
package com.example.firstapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class HelloController {

    // We want to have a reusable FX setup with our root -> scene -> stage
    private Stage stage;
    private Scene scene;
    private Parent root;

    // Create action event tied to button using SceneBuilder which creates new scene with each interaction
    public void switchToSceneOne(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml"))); // Sets our root when using SceneBuilder
        stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Finds the scene our ActionEvent is associated to and casts as stage
        scene = new Scene(root); // Same logic as our application
        stage.setScene(scene);
        stage.show();
    }

    // Mirrors switchToSceneOne but uses other fxml
    public void switchToSceneTwo(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("second.fxml")));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Circle myCircle;
    private double x;
    private double y;

    public void up(ActionEvent e) {
        System.out.println("UP");
        myCircle.setCenterY(y = y - 1);
    }

    public void down(ActionEvent e) {
        System.out.println("DOWN");
        myCircle.setCenterY(y = y + 1);
    }

    public void left(ActionEvent e) {
        myCircle.setCenterX(x = x + 1);
        System.out.println("LEFT");
    }

    public void right(ActionEvent e) {
        myCircle.setCenterX(x = x - 1);
        System.out.println("Right");
    }

}


// Application
package com.example.firstapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    @Override // a stage simplistically is a window desktop application, which inside we can place a scene
    public void start(Stage stage) throws IOException {

        try {
            // In our Controller we have two fxmls, this is our default or on-open scene
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            Scene scene = new Scene(root, 650, 650);
            // Reusable variable to plug in our CSS
            scene.getStylesheets().add("styles.css");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

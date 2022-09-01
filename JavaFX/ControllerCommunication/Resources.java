<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.PasswordField?>
<?import javafx.scene.layout.AnchorPane?>

<AnchorPane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/18" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.firstapp.FirstController">
   <children>
      <PasswordField fx:id="nameTextField" layoutX="216.0" layoutY="175.0" onAction="#login" />
      <Button fx:id="loginButton" layoutX="265.0" layoutY="217.0" mnemonicParsing="false" onAction="#login" text="Login" />
   </children>
</AnchorPane>


<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Label?>
<?import javafx.scene.layout.AnchorPane?>
<?import javafx.scene.text.Font?>

<AnchorPane prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/18" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.firstapp.SecondController">
   <children>
      <Label fx:id="nameLabel" layoutX="202.0" layoutY="143.0" prefHeight="102.0" prefWidth="372.0" text="Label">
         <font>
            <Font size="50.0" />
         </font>
      </Label>
   </children>
</AnchorPane>


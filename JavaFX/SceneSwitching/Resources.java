// Not Java code, using extension for syntax highlighting
// Scene 1 
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.layout.AnchorPane?>

<AnchorPane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/18" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.firstapp.HelloController">
   <children>
      <Label fx:id="tab1" layoutY="106.0" prefHeight="17.0" prefWidth="600.0" text="Styling Example" />
      <Label fx:id="tab2" layoutX="272.0" layoutY="270.0" text="Programming" />
      <Button layoutX="102.0" layoutY="175.0" mnemonicParsing="false" text="Swap to 2" />
      <Button layoutX="274.0" layoutY="150.0" mnemonicParsing="false" onAction="#switchToSceneTwo" text="Button" />
   </children>
</AnchorPane>

// Scene 2
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.layout.AnchorPane?>

<AnchorPane prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/18" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.firstapp.HelloController">
   <children>
      <Button layoutX="259.0" layoutY="157.0" mnemonicParsing="false" onAction="#switchToSceneOne" text="Switch" />
      <Button layoutY="89.0" mnemonicParsing="false" text="Button" />
   </children>
</AnchorPane>

// CSS (unfinished, was testing)
.root{
    -fx-background-color: #92a8d1;
}

.label{
    -fx-font-size:20;
    -fxf-font-family: "Lucida Console";
}

#tab1{

}

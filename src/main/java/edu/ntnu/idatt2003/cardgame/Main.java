package edu.ntnu.idatt2003.cardgame;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

  private Hand hand;

  @Override
  public void start(Stage stage) throws Exception {

    Text text = new Text("Card Game");
    text.setFont(Font.font("Arial", FontWeight.LIGHT, 20));
    text.setFill(Color.WHITE);
    StackPane textBox = new StackPane(text);
    textBox.setStyle(
        "-fx-background-color: #40c140; " +
        "-fx-background-radius: 5;" +
        "-fx-padding:20; " +
        "-fx-border-radius: 5;"
    );
    textBox.setLayoutX(25.0);
    textBox.setLayoutY(25.0);

    DeckOfCards deck = new DeckOfCards();

    Text handText = new Text("Dealt Hand: ");
    handText.setFont(Font.font("Arial", FontWeight.LIGHT, 12));
    handText.setFill(Color.BLACK);
    handText.setLayoutX(25.0);
    handText.setLayoutY(25.0);

    Text flushText = new Text("Flush: ");
    flushText.setFont(Font.font("Arial", FontWeight.LIGHT, 12));
    flushText.setFill(Color.BLACK);
    flushText.setLayoutX(750.0);
    flushText.setLayoutY(25.0);

    Text sumText = new Text("Face Sum: ");
    sumText.setFont(Font.font("Arial", FontWeight.LIGHT, 12));
    sumText.setFill(Color.BLACK);
    sumText.setLayoutX(750.0);
    sumText.setLayoutY(50.0);

    Button dealButton = new Button("Deal Hand");
    dealButton.setOnAction(e -> {
        hand = deck.dealHand(5);
        System.out.println("Dealt hand: " + hand.getHand());
        handText.setText("Deal hand: " + hand.getHand());
    });

    Button flushButton = new Button("Check Flush");
    flushButton.setOnAction(e -> {
      if (hand == null) {
        System.out.println("No hand dealt yet!");
        flushText.setText("Flush: No hand dealt yet!");
      } else {
        boolean flush = hand.isFlush();
        System.out.println("Flush: " + flush);
        flushText.setText("Flush: " + flush);
      }
    });

    Button sumButton = new Button("Face sum");
    sumButton.setOnAction(e -> {
      if (hand == null) {
        System.out.println("No hand dealt yet!");
        sumText.setText("Deal hand: No hand dealt yet!");
      } else {
        int sum = hand.getSum();
        System.out.println("Face Sum: " + sum);
        sumText.setText("Face Sum: " + sum);
      }
    });

    ButtonBar buttonBar = new ButtonBar();
    buttonBar.getButtons().addAll(dealButton, flushButton, sumButton);
    buttonBar.setStyle(
        "-fx-focus-color: transparent; " +
        "-fx-faint-focus-color: transparent;"
    );
    StackPane buttonBox = new StackPane(buttonBar);
    buttonBox.setStyle(
        "-fx-background-color: #40c140; " +
        "-fx-background-radius: 5;" +
        "-fx-padding: 20; " +
        "-fx-border-radius: 5;"
    );
    buttonBox.setLayoutX(555.0);
    buttonBox.setLayoutY(25.0);

    Pane gameBox = new Pane();
    gameBox.setStyle(
        "-fx-background-color: white;" +
        "-fx-background-radius: 5;" +
        "-fx-border-radius: 5;" +
        "-fx-border-color: #40c140;" +
        "-fx-border-width: 2;"
    );
    gameBox.setPrefSize(850,460);
    gameBox.setLayoutX(25.0);
    gameBox.setLayoutY(115.0);
    gameBox.getChildren().addAll(handText, flushText, sumText);

    Group root = new Group();
    ObservableList<Node> children = root.getChildren();
    children.add(textBox);
    children.add(buttonBox);
    children.add(gameBox);

    Scene scene = new Scene(root,900, 600);
    scene.setFill(Color.LIGHTGREY);

    stage.setTitle("Card Game");
    stage.setScene(scene);
    stage.show();


  }

  public static void main(String[] args) {
    launch(args);
  }
}

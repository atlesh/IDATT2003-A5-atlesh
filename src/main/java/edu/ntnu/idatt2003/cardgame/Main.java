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

    DeckOfCards deck = new DeckOfCards();

    //TEXT

    Text text = new Text("Card Game");
    text.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
    text.setFill(Color.WHITE);

    Text handText = new Text("Dealt Hand: ");
    handText.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    handText.setLayoutX(15.0);
    handText.setLayoutY(25.0);

    Text flushText = new Text("Flush: ");
    flushText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
    flushText.setLayoutX(150.0);
    flushText.setLayoutY(25.0);

    Text sumText = new Text("Face Sum: ");
    sumText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
    sumText.setLayoutX(150.0);
    sumText.setLayoutY(50.0);

    Text heartsText = new Text("Cards of hearts: ");
    heartsText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
    heartsText.setLayoutX(250.0);
    heartsText.setLayoutY(25.0);

    Text spadeQueenText = new Text("Queen of spades: ");
    spadeQueenText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
    spadeQueenText.setLayoutX(250.0);
    spadeQueenText.setLayoutY(50.0);

    Text nullText = new Text();
    nullText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
    nullText.setLayoutX(150.0);
    nullText.setLayoutY(85.0);

    //CONTROLLERS

    Button dealButton = new Button("Deal Hand");
    dealButton.setOnAction(e -> {
        nullText.setText("");
        hand = deck.dealHand(5);
        handText.setText("Dealt hand:\n" + hand);
    });

    Button flushButton = new Button("Check hand");
    flushButton.setOnAction(e -> {
      if (hand == null) {
        nullText.setText("No hand dealt yet!");
      } else {
        boolean flush = hand.isFlush();
        flushText.setText("Flush: " + flush);
        int sum = hand.getSum();
        sumText.setText("Face Sum: " + sum);
      }
    });

    ButtonBar buttonBar = new ButtonBar();
    buttonBar.getButtons().addAll(dealButton, flushButton);
    buttonBar.setStyle(
        "-fx-focus-color: transparent; " +
        "-fx-faint-focus-color: transparent;"
    );

    //STACKPANE

    StackPane textBox = new StackPane(text);
    textBox.setStyle(
        "-fx-background-color: #40c140; " +
            "-fx-background-radius: 5;" +
            "-fx-padding:20; " +
            "-fx-border-radius: 5;"
    );
    textBox.setLayoutX(25.0);
    textBox.setLayoutY(25.0);

    StackPane buttonBox = new StackPane(buttonBar);
    buttonBox.setStyle(
        "-fx-background-color: #40c140; " +
        "-fx-background-radius: 5;" +
        "-fx-padding: 18; " +
        "-fx-border-radius: 5;"
    );
    buttonBox.setLayoutX(200.0);
    buttonBox.setLayoutY(25.0);

    Pane gameBox = new Pane();
    gameBox.setStyle(
        "-fx-background-color: white;" +
        "-fx-background-radius: 5;" +
        "-fx-border-radius: 5;" +
        "-fx-border-color: #40c140;" +
        "-fx-border-width: 2;"
    );
    gameBox.setPrefSize(400,100);
    gameBox.setLayoutX(25.0);
    gameBox.setLayoutY(115.0);

    gameBox.getChildren().addAll(handText, flushText, sumText,
        heartsText, spadeQueenText, nullText);

    Group root = new Group();
    ObservableList<Node> children = root.getChildren();
    children.addAll(textBox, buttonBox, gameBox);

    //SCENE

    Scene scene = new Scene(root,460,240);
    scene.setFill(Color.LIGHTGREY);
    stage.setTitle("Card Game");
    stage.setScene(scene);
    stage.show();


  }

  public static void main(String[] args) {
    launch(args);
  }
}

package edu.ntnu.idatt2003.cardgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Main extends Application {

  @Override
  public void start(Stage stage){
    Label label = new Label("Card Game starter!");
    Scene scene = new Scene(label, 400, 300);
    stage.setScene(scene);
    stage.setTitle("Card Game");
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}

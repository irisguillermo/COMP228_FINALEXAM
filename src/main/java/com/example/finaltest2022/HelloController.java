package com.example.finaltest2022;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
  protected void onHelloButtonClick() {
       welcomeText.setText("Welcome to JavaFX Application!");
   }
}




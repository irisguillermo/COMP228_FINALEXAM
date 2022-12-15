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
 //   protected void onHelloButtonClick() {
    //    welcomeText.setText("Welcome to JavaFX Application!");
   // }
//}

    public void OnAddButton(ActionEvent actionEvent) throws SQLException, IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 920, 480);
        stage.setTitle("Player And Game");
        stage.setScene(scene);
        stage.show();
    }
}
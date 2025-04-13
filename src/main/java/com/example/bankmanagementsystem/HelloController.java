package com.example.bankmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button welcomeButton;

    @FXML
    protected void onWelcomeButtonClick() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) welcomeButton.getScene().getWindow();
            Scene scene = new Scene(root, 800, 600);
            stage.setTitle("Bank Account Management System");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
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
            // Load the account view
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-view.fxml"));
            Parent root = fxmlLoader.load();
            
            // Get the current stage
            Stage stage = (Stage) welcomeButton.getScene().getWindow();
            
            // Create new scene and set it
            Scene scene = new Scene(root, 800, 600);
            stage.setTitle("Bank Account Management System");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
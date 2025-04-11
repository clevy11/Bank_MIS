package com.example.bankmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private void openAccountView() {
        try {
            // Load the account view FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("account-view.fxml"));
            Parent root = loader.load();
            
            // Create a new stage for the account view
            Stage stage = new Stage();
            stage.setTitle("Bank Account Management");
            stage.setScene(new Scene(root, 800, 600));
            
            // Show the new stage
            stage.show();
            
            // Close the current stage (welcome screen)
            Stage currentStage = (Stage) root.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
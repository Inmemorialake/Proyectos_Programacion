package com.project1.project1.controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

// Class that controls the stage ans communicates with the view
public class StageController {
    private Button startButton;
    private TextField secretWordTextField;

    // Constructor of the class
    public StageController(Button startButton, TextField SecretWordTextField) {
        this.startButton = startButton;
        this.secretWordTextField = SecretWordTextField;
        handleStart();
    }

    // Method that handles the start button
    private void handleStart() {
        startButton.setOnAction(actionEvent -> {
            System.out.println(secretWordTextField.getText());
        });
    }
}

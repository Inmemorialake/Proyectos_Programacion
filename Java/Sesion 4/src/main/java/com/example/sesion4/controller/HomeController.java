package com.example.sesion4.controller;

import com.example.sesion4.model.Palabra;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HomeController {
    private Button playButton;
    private TextField secretWordTextField;

    public HomeController(Button playButton, TextField SecretWordTextField) {
        this.playButton = playButton;
        this.secretWordTextField = SecretWordTextField;
        handlePlay();
    }

    private void handlePlay() {
        playButton.setOnAction(ActionEvent -> {
            Palabra secretWord = new Palabra(secretWordTextField.getText());
            System.out.println(secretWord.getLongitud());
        });
    }

}

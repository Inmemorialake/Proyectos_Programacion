package com.project1.project1.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameScreen extends Stage {
    private VBox root;
    private HBox hBox;
    private Scene scene;
    private TextField userLetterTextField;
    private Label[] GuessedWordLabel;
    private Label errorLabel;

    public GameScreen() {
        root = new VBox();
        scene = new Scene(root, 1000, 600);
        userLetterTextField = new TextField();
        initStage();
    }

    private void initStage() {
        setTitle("Miniproyecto 1");
        setResizable(false);
        setScene(scene);
        show();
    }
}

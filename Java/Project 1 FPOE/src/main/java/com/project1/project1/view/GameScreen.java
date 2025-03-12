package com.project1.project1.view;

import com.project1.project1.controller.StageController;
import com.project1.project1.model.GameStage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameScreen extends Stage {
    private VBox root;
    private Scene scene;
    //todo private StageController controller;
    private TextField userWordTextField;

    public GameScreen() {
        root = new VBox();
        scene = new Scene(root, 1000, 600);
        userWordTextField = new TextField();
        //todo initStage();
    }

}

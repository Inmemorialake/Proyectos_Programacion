package com.example.sesion4.view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeStage extends Stage {
    private VBox root;
    private Scene scene;

    public HomeStage() {
        root = new VBox();
        scene = new Scene(root, 512, 256);
        initStage();
    }

    private void initStage() {
        setTitle("Miniproyecto 1");
        setResizable(false);
        setScene(scene);
        show();
    }
}

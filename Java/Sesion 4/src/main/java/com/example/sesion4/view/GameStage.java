package com.example.sesion4.view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameStage extends Stage {
    private Scene scene;
    private VBox root;

    public GameStage () {
        root = new VBox();
        scene = new Scene(root, 512, 256);
        initStage();
    }

    private void initStage() {
        setTitle("Miniproyecto 1");
        setResizable(false);
        getIcons().add(new Image(String.valueOf(getClass().getResource("/com/example/sesion4/favicon.png"  ))));
        setScene(scene);
        show();
    }


}

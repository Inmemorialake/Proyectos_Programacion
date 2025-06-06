package com.example.sesion4.view;

import com.example.sesion4.controller.HomeController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HomeStage extends Stage {
    private VBox root;
    private Scene scene;
    private TextField secretWordTextField;
    private Button playButton;
    private HomeController homeController;

    public HomeStage() {
        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        scene = new Scene(root, 512, 256);
        initStage();
        ShowHome();
        initController();
    }

    private void initStage() {
        setTitle("Miniproyecto 1");
        setResizable(false);
        getIcons().add(new Image(String.valueOf(getClass().getResource("/com/example/sesion4/favicon.png"  ))));
        setScene(scene);
        show();
    }

    private void ShowHome() {
        Label tittleLabel = new Label("Digite la palabra secreta");
        tittleLabel.setTextFill(Color.MIDNIGHTBLUE);
        tittleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        secretWordTextField = new TextField();
        playButton = new Button("Iniciar");
        root.getChildren().addAll(tittleLabel, secretWordTextField, playButton);
    }

    private void initController() {
        homeController = new HomeController(playButton, secretWordTextField);
    }
}

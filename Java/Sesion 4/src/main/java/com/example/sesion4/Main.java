package com.example.sesion4;

import com.example.sesion4.view.HomeStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage primaryStage) {
        new HomeStage();
    }
}

package com.project1.project1;

import com.project1.project1.view.StartScreen;
import javafx.application.Application;
import javafx.stage.Stage;

// Main class that starts the application
public class Main extends Application {

    // Main method that starts the application
    public static void main(String[] args) {
        launch(args);
    }

    // Method that starts the application
    @Override
    public void start(Stage primaryStage) {
        new StartScreen();
    }
}
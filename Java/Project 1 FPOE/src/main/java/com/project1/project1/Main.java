package com.project1.project1;

/**
 * Class that starts the application
 * @autor: Inmemorialake (2416541)
 */

// Imports
import com.project1.project1.controller.StageController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Main method that starts the application
     * @param args The arguments of the application
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Method that starts the application
     * @param primaryStage The primary stage of the application
     */
    @Override
    public void start(Stage primaryStage) {
        new StageController();
    }
}
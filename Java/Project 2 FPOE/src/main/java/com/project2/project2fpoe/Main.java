package com.project2.project2fpoe;
import com.project2.project2fpoe.view.StageSudoku;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void Main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        new StageSudoku();
    }
}
package com.project2.project2fpoe.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageSudoku extends Stage {

    public StageSudoku() throws IOException {
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(getClass().getResource("/com/project2/project2fpoe/Project2FPOE.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        setTitle("Sudoku");
        setResizable(false);
        setScene(scene);
        show();
    }
}

package com.project2.project2fpoe.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SudokuController implements Initializable {

    @FXML
    private GridPane grid;

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        createGrid();
    }

    //Method that create the textfields in the grid
    private void createGrid(){
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                TextField textField = new TextField();
                textField.setPrefSize(100, 100);
                textField.getStyleClass().add("sudokuCell");
                grid.add(textField, col, row);

            }
        }
    }
}

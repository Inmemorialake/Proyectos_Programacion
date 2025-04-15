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

    private void createGrid() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                TextField cell = new TextField();
                cell.setPrefSize(60, 60);
                cell.getStyleClass().add("sudokuCell");

                StringBuilder borderStyle = new StringBuilder("-fx-border-color: #358bfc;");
                borderStyle.append("-fx-border-width: ");

                double top = (row % 2 == 0) ? 3 : 0.5;
                double left = (col % 3 == 0) ? 3 : 0.5;
                double bottom = (row == 5) ? 3 : 0.5;
                double right = (col == 5) ? 3 : 0.5;

                borderStyle.append(top).append(" ")
                        .append(right).append(" ")
                        .append(bottom).append(" ")
                        .append(left).append(";");

                cell.setStyle(borderStyle.toString());

                grid.add(cell, col, row);
            }
        }
    }
}

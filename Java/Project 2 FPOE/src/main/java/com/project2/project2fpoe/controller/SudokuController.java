package com.project2.project2fpoe.controller;

import com.project2.project2fpoe.model.Sudoku;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class SudokuController implements Initializable {

    @FXML
    private GridPane sudokuGrid;

    @FXML
    private Button helpButton;

    @FXML
    private Label bottomLabel;

    private Sudoku sudoku; // Instancia de la lógica del Sudoku

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sudoku = new Sudoku(); // Inicializar la lógica del Sudoku
        sudoku.generatePlayableBoard(); // Generar un tablero resoluble
        createGrid();
        helpButton.setOnAction(e -> showHint());
    }

    private void createGrid() {

        // Crear un Timeline para verificar si el Sudoku está resuelto
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> {
            if (sudoku.isSolved()) {
                disableSudoku();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE); // Repetir indefinidamente
        timeline.play();

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                TextField cell = new TextField();
                cell.setPrefSize(60, 60);
                cell.getStyleClass().add("sudokuCell");

                // Estilo de bordes 3x2
                StringBuilder borderStyle = new StringBuilder("-fx-border-color: #358bfc;");
                double top = (row % 2 == 0) ? 3 : 0.5;
                double left = (col % 3 == 0) ? 3 : 0.5;
                double bottom = (row == 5) ? 3 : 0.5;
                double right = (col == 5) ? 3 : 0.5;
                borderStyle.append("-fx-border-width: ")
                        .append(top).append(" ")
                        .append(right).append(" ")
                        .append(bottom).append(" ")
                        .append(left).append(";");
                cell.setStyle(borderStyle.toString());

                int finalRow = row;
                int finalCol = col;
                int cellValue = sudoku.getBoard().get(row).get(col);

                if (cellValue != 0) {
                    // Valor generado por el modelo → celda predefinida
                    cell.setText(String.valueOf(cellValue));
                    cell.setEditable(false);
                    cell.getStyleClass().add("predefined");
                } else {
                    // Celda editable → permite entrada del usuario
                    cell.textProperty().addListener((observable, oldValue, newValue) -> {
                        if (newValue.matches("[1-6]?")) { // solo 1 a 6 o vacío
                            if (!newValue.isEmpty()) {
                                int value = Integer.parseInt(newValue);
                                if (!sudoku.setCell(finalRow, finalCol, value)) {
                                    cell.setStyle("-fx-background-color: #ff0000;");
                                } else {
                                    cell.setStyle("-fx-background-color: #90cbff;");
                                    // Verificar si el Sudoku está resuelto
                                    if (sudoku.isSolved()) {
                                        disableSudoku();
                                    }
                                }
                            } else {
                                sudoku.getBoard().get(finalRow).set(finalCol, 0); // reset
                            }
                        } else {
                            cell.setText(""); // borrar si no es válido
                        }
                    });
                }

                // Manejador de teclado para mover el foco
                cell.setOnKeyPressed(event -> {
                    switch (event.getCode()) {
                        case UP -> moveFocus(finalRow - 1, finalCol);
                        case DOWN -> moveFocus(finalRow + 1, finalCol);
                        case LEFT -> moveFocus(finalRow, finalCol - 1);
                        case RIGHT -> moveFocus(finalRow, finalCol + 1);
                    }
                });

                sudokuGrid.add(cell, col, row);
            }
        }
    }

    // Método para mover el foco a una celda específica
    private void moveFocus(int row, int col) {
        if (row >= 0 && row < 6 && col >= 0 && col < 6) {
            for (javafx.scene.Node node : sudokuGrid.getChildren()) {
                if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col && node instanceof TextField textField) {
                    textField.requestFocus();
                    break;
                }
            }
        }
    }

    // Metodo para desactivar el sudoku porque ya se resolvió
    public void disableSudoku() {
        for (javafx.scene.Node node : sudokuGrid.getChildren()) {
            if (node instanceof TextField textField) {
                textField.setEditable(false);
                textField.setStyle("-fx-background-color: #90cbff; -fx-text-fill: white;");
            }
        }
        bottomLabel.setText("¡Felicidades! Has resuelto el Sudoku.");
    }

    private void showHint() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                if (sudoku.getBoard().get(row).get(col) == 0) {
                    for (int value = 1; value <= 6; value++) {
                        if (sudoku.isValidMove(sudoku.getBoard() ,row, col, value)) {
                            // Colorear la celda sugerida
                            for (javafx.scene.Node node : sudokuGrid.getChildren()) {
                                if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col && node instanceof TextField textField) {
                                    textField.setText(String.valueOf(value));
                                    textField.setStyle("-fx-background-color: #4da6ff; -fx-text-fill: white;");
                                }
                            }
                            return;
                        }
                    }
                }
            }
        }
    }
}
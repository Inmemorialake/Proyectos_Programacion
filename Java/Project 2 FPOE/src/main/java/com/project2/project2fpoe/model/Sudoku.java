package com.project2.project2fpoe.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sudoku {
    private final List<List<Integer>> board; // Tablero 6x6 representado como lista de listas
    private List<List<Integer>> boardCopy; // Copia del tablero para resolver
    private static final int SIZE = 6; // Tamaño del tablero

    public Sudoku() {
        board = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < SIZE; j++) {
                row.add(0); // Inicializar con ceros
            }
            board.add(row);
        }
    }

    public void generatePlayableBoard() {
        do {
            clearBoard(); // Limpia el tablero
            fillBlocksWithTwoNumbers(); // Llena cada bloque con 2 números aleatorios
        } while (!isResolvable()); // Repite hasta que el tablero sea resoluble
        printBoard();
        System.out.println("<---------->");
        printBoardCopy();
    }

    private void fillBlocksWithTwoNumbers() {
        for (int blockRow = 0; blockRow < SIZE; blockRow += 2) {
            for (int blockCol = 0; blockCol < SIZE; blockCol += 3) {
                int numbersToPlace = 2; // Dos números por bloque
                while (numbersToPlace > 0) {
                    int row = blockRow + (int) (Math.random() * 2); // Fila dentro del bloque
                    int col = blockCol + (int) (Math.random() * 3); // Columna dentro del bloque
                    if (board.get(row).get(col) == 0) { // Verifica que la celda esté vacía
                        int value = (int) (Math.random() * SIZE) + 1; // Número aleatorio entre 1 y 6
                        if (isValidMove(board ,row, col, value)) { // Verifica si el número es válido
                            board.get(row).set(col, value);
                            numbersToPlace--;
                        }
                    }
                }
            }
        }
    }

    // Método para verificar si el tablero es resoluble
    private boolean isResolvable() {
        boardCopy = new ArrayList<>();
        for (List<Integer> row : board) {
            List<Integer> newRow = new ArrayList<>(row);
            boardCopy.add(newRow);
        }
        return solve();
    }

    // Método para limpiar el tablero
    private void clearBoard() {
        for (List<Integer> row : board) {
            Collections.fill(row, 0);
        }
    }

    // Método para obtener el tablero
    public List<List<Integer>> getBoard() {
        return board;
    }

    // Método para establecer un valor en una celda
    public boolean setCell(int row, int col, int value) {
        if (isValidMove(board ,row, col, value)) {
            board.get(row).set(col, value);
            return true;
        }
        return false;
    }

    // Validar si un movimiento es válido
    public boolean isValidMove(List<List<Integer>> board, int row, int col, int value) {
        if (value < 1 || value > SIZE || board.get(row).get(col) != 0) {
            return false;
        }

        // Validar fila
        if (board.get(row).contains(value)) {
            return false;
        }

        // Validar columna
        for (int i = 0; i < SIZE; i++) {
            if (board.get(i).get(col) == value) {
                return false;
            }
        }

        // Validar bloque 3x2
        int blockRowStart = (row / 2) * 2;
        int blockColStart = (col / 3) * 3;
        for (int i = blockRowStart; i < blockRowStart + 2; i++) {
            for (int j = blockColStart; j < blockColStart + 3; j++) {
                if (board.get(i).get(j) == value) {
                    return false;
                }
            }
        }

        return true;
    }

    // Método para verificar si el tablero está resuelto
    public boolean isSolved() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                int value = board.get(row).get(col);
                if (value == 0 || !isValidMove(board ,row, col, value)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Método para imprimir el tablero (para depuración)
    public void printBoard() {
        for (List<Integer> row : board) {
            for (Integer cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    //Metodo para imprimir la copia del tablero (depuración y trampa)
    public void printBoardCopy() {
        for (List<Integer> row : boardCopy) {
            for (Integer cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    // Método para resolver el Sudoku (backtracking)
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (boardCopy.get(row).get(col) == 0) {
                    for (int value = 1; value <= SIZE; value++) {
                        if (isValidMove(boardCopy ,row, col, value)) {
                            boardCopy.get(row).set(col, value);
                            if (solve()) {
                                return true;
                            }
                            boardCopy.get(row).set(col, 0); // Retroceder
                        }
                    }
                    return false; // No hay solución
                }
            }
        }
        return true; // Resuelto
    }
}
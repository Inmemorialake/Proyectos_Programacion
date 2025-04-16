package com.project2.project2fpoe.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sudoku {
    private final List<List<Integer>> board; // Tablero 6x6 representado como lista de listas
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

    // Método para generar un tablero inicial válido con 2 valores por bloque
    public void generateBoard() {
        clearBoard(); // Limpiar el tablero antes de generar uno nuevo
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= SIZE; i++) {
            numbers.add(i);
        }

        // Llenar cada bloque 3x2 con exactamente 2 valores
        for (int blockRow = 0; blockRow < SIZE; blockRow += 2) {
            for (int blockCol = 0; blockCol < SIZE; blockCol += 3) {
                int valuesToPlace = 2; // Dos valores por bloque
                while (valuesToPlace > 0) {
                    int row = blockRow + (int) (Math.random() * 2); // Fila dentro del bloque
                    int col = blockCol + (int) (Math.random() * 3); // Columna dentro del bloque
                    if (board.get(row).get(col) == 0) { // Verificar que la celda esté vacía
                        Collections.shuffle(numbers); // Mezclar los números
                        for (int value : numbers) {
                            if (isValidMove(row, col, value)) {
                                board.get(row).set(col, value);
                                valuesToPlace--;
                                break;
                            }
                        }
                    }
                }
            }
        }
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
        if (isValidMove(row, col, value)) {
            board.get(row).set(col, value);
            return true;
        }
        return false;
    }

    // Validar si un movimiento es válido
    public boolean isValidMove(int row, int col, int value) {
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
                if (value == 0 || !isValidMove(row, col, value)) {
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

    // Método para resolver el Sudoku (backtracking)
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board.get(row).get(col) == 0) {
                    for (int value = 1; value <= SIZE; value++) {
                        if (isValidMove(row, col, value)) {
                            board.get(row).set(col, value);
                            if (solve()) {
                                return true;
                            }
                            board.get(row).set(col, 0); // Retroceder
                        }
                    }
                    return false; // No hay solución
                }
            }
        }
        return true; // Resuelto
    }
}
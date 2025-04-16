package com.project2.project2fpoe.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sudoku {
    private final List<List<Integer>> board;
    private List<List<Integer>> boardCopy;
    private static final int SIZE = 6;

    public Sudoku() {
        board = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < SIZE; j++) {
                row.add(0);
            }
            board.add(row);
        }
    }

    public void generatePlayableBoard() {
        do {
            clearBoard();
            fillBlocksWithTwoNumbers();
        } while (!isResolvable());
        printBoard();
        System.out.println("<---------->");
        printBoardCopy();
        System.out.println("<---------->");
        System.out.println(isSolved());
    }

    private void fillBlocksWithTwoNumbers() {
        for (int blockRow = 0; blockRow < SIZE; blockRow += 2) {
            for (int blockCol = 0; blockCol < SIZE; blockCol += 3) {
                int numbersToPlace = 2;
                while (numbersToPlace > 0) {
                    int row = blockRow + (int) (Math.random() * 2);
                    int col = blockCol + (int) (Math.random() * 3);
                    if (board.get(row).get(col) == 0) {
                        int value = (int) (Math.random() * SIZE) + 1;
                        if (isValidMove(board ,row, col, value)) {
                            board.get(row).set(col, value);
                            numbersToPlace--;
                        }
                    }
                }
            }
        }
    }

    private boolean isResolvable() {
        boardCopy = new ArrayList<>();
        for (List<Integer> row : board) {
            List<Integer> newRow = new ArrayList<>(row);
            boardCopy.add(newRow);
        }
        return solve();
    }

    private void clearBoard() {
        for (List<Integer> row : board) {
            Collections.fill(row, 0);
        }
    }

    public List<List<Integer>> getBoard() {
        return board;
    }

    public boolean setCell(int row, int col, int value) {
        if (isValidMove(board ,row, col, value)) {
            board.get(row).set(col, value);
            return true;
        }
        return false;
    }

    public boolean isValidMove(List<List<Integer>> board, int row, int col, int value) {
        if (value < 1 || value > SIZE || board.get(row).get(col) != 0) {
            return false;
        }

        if (board.get(row).contains(value)) {
            return false;
        }

        for (int i = 0; i < SIZE; i++) {
            if (board.get(i).get(col) == value) {
                return false;
            }
        }

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

    public boolean isSolved() {
        for (int row = 0; row < SIZE; row++) {
            boolean[] seen = new boolean[SIZE + 1];
            for (int col = 0; col < SIZE; col++) {
                int value = board.get(row).get(col);
                if (value == 0 || seen[value]) {
                    return false;
                }
                seen[value] = true;
            }
        }

        for (int col = 0; col < SIZE; col++) {
            boolean[] seen = new boolean[SIZE + 1];
            for (int row = 0; row < SIZE; row++) {
                int value = board.get(row).get(col);
                if (value == 0 || seen[value]) {
                    return false;
                }
                seen[value] = true;
            }
        }

        for (int blockRow = 0; blockRow < SIZE; blockRow += 2) {
            for (int blockCol = 0; blockCol < SIZE; blockCol += 3) {
                boolean[] seen = new boolean[SIZE + 1];
                for (int row = blockRow; row < blockRow + 2; row++) {
                    for (int col = blockCol; col < blockCol + 3; col++) {
                        int value = board.get(row).get(col);
                        if (value == 0 || seen[value]) {
                            return false;
                        }
                        seen[value] = true;
                    }
                }
            }
        }

        return true;
    }

    public void printBoard() {
        for (List<Integer> row : board) {
            for (Integer cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public void printBoardCopy() {
        for (List<Integer> row : boardCopy) {
            for (Integer cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

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
                            boardCopy.get(row).set(col, 0);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
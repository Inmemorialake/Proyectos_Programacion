package com.project1.project1.model;

import java.util.Scanner;

public class GameStage {
    private final String SecretWord;
    private int Attempts;
    private int HelpAttempts;
    private boolean GameOver;

    public GameStage(String secretWord) {
        SecretWord = secretWord;
        Attempts = 8;
        HelpAttempts = 4;
        GameOver = false;
    }

    public void StartGame() {
        System.out.println("Perfecto! Ahora adivina la palabra secreta: ");
        while (!GameOver && Attempts > 0) {
            String UserWord = new Scanner(System.in).nextLine().trim();
            if (VerifyWord(UserWord)) {
                GameOver = true;
            }
        }
    }

    public boolean VerifyWord(String word) {
        if (word.equals(SecretWord)) {
            System.out.println("Felicidades! Has adivinado la palabra secreta: " + SecretWord);
            return true;
        } else {
            Attempts--;
            if (Attempts == 0) {
                System.out.println("Has perdido! La palabra secreta era: " + SecretWord);
            }
            else {
                System.out.println("Palabra incorrecta, intentos restantes: " + Attempts);
                System.out.println("Intentalo de nuevo : ");
            }
            return false;
        }
    }

}

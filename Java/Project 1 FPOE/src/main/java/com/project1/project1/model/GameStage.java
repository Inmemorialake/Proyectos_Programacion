package com.project1.project1.model;

import java.util.Scanner;

public class GameStage {
    private final String SecretWord;
    private int Attempts;
    private boolean[] LetterFound;
    private Scanner scanner = new Scanner(System.in);


    public GameStage(String secretWord) {
        SecretWord = secretWord;
        Attempts = 8;
        LetterFound = new boolean[SecretWord.length()];
    }

    public void StartGame() {
        System.out.println("Perfecto! Ahora adivina la palabra secreta: ");
        String word = scanner.nextLine().toLowerCase();
        while (!word.equals(SecretWord) && Attempts > 1) {
            checkLetters(word);
            word = AskInNewAttempt();
        }
        if (word.equals(SecretWord)) {
            System.out.println("Felicidades! Adivinaste la palabra secreta: " + SecretWord);
        }
        if (Attempts == 0) {
            System.out.println("Perdiste! La palabra secreta era: " + SecretWord);
        }
    }

    public void checkLetters(String word) {
        for (int i = 0; i < SecretWord.length(); i++) {
            if (SecretWord.charAt(i) == word.charAt(i)) {
                LetterFound[i] = true;
            }
        }
    }

    public String AskInNewAttempt(){
        Attempts--;
        System.out.println("Tus aciertos fueron:");
        for (int i = 0; i < SecretWord.length(); i++) {
            if (LetterFound[i]) {
                System.out.print(SecretWord.charAt(i));
            }
            else {
                System.out.print("_");
            }
        }
        System.out.println("\nIntentos restantes: " + Attempts);
        System.out.println("Ingrese lo que falta de la palabra: ");
        return scanner.nextLine().toLowerCase();
    }
}


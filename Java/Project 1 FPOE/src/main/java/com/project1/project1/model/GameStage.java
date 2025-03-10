package com.project1.project1.model;

import java.util.Scanner;

public class GameStage {
    private final String SecretWord;
    private int Attempts;
    private int counter;
    private int LastPosition;
    private boolean[] LetterFound;

    public GameStage(String secretWord) {
        SecretWord = secretWord;
        Attempts = 8;
        counter = 8;
        LastPosition = 0;
        LetterFound = new boolean[SecretWord.length()];
    }

    public void StartGame() {
        System.out.println("Perfecto! Ahora adivina la palabra secreta: ");
        String word = new Scanner(System.in).nextLine();
        while (!LetterFound[SecretWord.length()-1]) {
            if (Attempts == 0){
                System.out.println("Perdiste! La palabra secreta era: " + SecretWord);
                break;
            }
            else {
                if (LastPosition == 0) {
                    checkLetters(word);
                }
                else {
                    word = AskInNewAttempt();
                    checkLetters(word);
                }
            }

        }
    }

    public void checkLetters(String word) {
        if (Attempts == counter) {
            for (int i = LastPosition; i < SecretWord.length(); i++) {
                if (SecretWord.charAt(i) == word.charAt(i)) {
                    LetterFound[i] = true;
                } else {
                    --Attempts;
                    System.out.println("Letra incorrecta en la posición " + (i + 1) + ", intentos restantes: " + Attempts);
                    LastPosition = i;
                    break;
                }
            }
        }
        else {
            word = AskInNewAttempt();
            --counter;
            checkLetters(word);
        }
    }

    public String AskInNewAttempt() {
        System.out.println("Tus aciertos fueron:");
        for (int i = 0; i < SecretWord.length(); i++) {
            if (LetterFound[i]) {
                System.out.print(SecretWord.charAt(i));
            }
            else {
                System.out.print("_");
            }
        }
        System.out.println("\nIngrese lo que falta de la palabra: ");
        return new Scanner(System.in).nextLine();
    }
}


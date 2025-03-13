package com.project1.project1.model;

public class GameStage {
    private final String SecretWord;
    private final String NormalizedSecretWord;
    private int Attempts;
    private boolean[] LetterFound;


    public GameStage(String secretWord) {
        SecretWord = secretWord;
        NormalizedSecretWord = secretWord.toLowerCase();
        Attempts = 8;
        LetterFound = new boolean[SecretWord.length()];
    }

    public String GetSecretWord() {
        return SecretWord;
    }

    public String GetNormalizedSecretWord() {
        return NormalizedSecretWord;
    }

    public int GetAttempts() {
        return Attempts;
    }

    public boolean[] GetLetterFound() {
        return LetterFound;
    }

    public void SetAttempts(int attempts) {
        Attempts = attempts;
    }

    public void SetLetterFound(int index, boolean value) {
        LetterFound[index] = value;
    }

    public boolean IsWordGuessed() {
        for (boolean letter : LetterFound) {
            if (!letter) {
                return false;
            }
        }
        return true;
    }

    public boolean IsGameOver() {
        return Attempts == 0;
    }

    public void DecrementAttempts() {
        Attempts--;
    }

    public boolean CheckLetter(char letter) {
        boolean found = false;
        for (int i = 0; i < SecretWord.length(); i++) {
            if (NormalizedSecretWord.charAt(i) == letter) {
                LetterFound[i] = true;
                found = true;
            }
        }
        if (!found) {
            DecrementAttempts();
        }
        return found;
    }

}
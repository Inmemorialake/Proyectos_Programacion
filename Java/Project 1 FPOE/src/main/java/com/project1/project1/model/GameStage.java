package com.project1.project1.model;

public class GameStage {
    private final String SecretWord;
    private final String NormalizedSecretWord;
    private int Attempts;
    private boolean[] LetterFound;
    private String[] GuessedLetters;
    private int helpCount;
    private static final int MAX_HELP_USES = 4;



    public GameStage(String secretWord) {
        SecretWord = secretWord;
        NormalizedSecretWord = secretWord.toLowerCase();
        Attempts = 8;
        GuessedLetters = new String[27];
        LetterFound = new boolean[SecretWord.length()];
        helpCount = 0;
    }

    public String getSecretWord() {
        return SecretWord;
    }

    public String getNormalizedSecretWord() {
        return NormalizedSecretWord;
    }

    public int getAttempts() {
        return Attempts;
    }

    public boolean[] getLetterFound() {
        return LetterFound;
    }

    public void setAttempts(int attempts) {
        Attempts = attempts;
    }

    public void setLetterFound(int index, boolean value) {
        LetterFound[index] = value;
    }

    public boolean isWordGuessed() {
        for (boolean letter : LetterFound) {
            if (!letter) {
                return false;
            }
        }
        return true;
    }

    public boolean isGameOver() {
        return Attempts == 0 || isWordGuessed();

    }

    public void decrementAttempts() {
        Attempts--;
    }

    public boolean checkLetter(char letter) {
        boolean found = false;
        for (int i = 0; i < SecretWord.length(); i++) {
            if (NormalizedSecretWord.charAt(i) == letter) {
                LetterFound[i] = true;
                found = true;
            }
        }
        if (!found) {
            decrementAttempts();
        }
        return found;
    }

    public boolean hasGuessedLetter(String letter) {
        for (String guessed : GuessedLetters) {
            if (letter.equals(guessed)) {
                return true;
            }
        }
        return false;
    }


    public void addGuessedLetters(String letter) {
        for (int i = 0; i < 27; i++) {
            if (GuessedLetters[i] == null) {
                GuessedLetters[i] = letter;
                return;
            }
        }
    }

    public int getHelpCount() {
        return helpCount;
    }

    public int getMAX_HELP_USES() {
        return MAX_HELP_USES;
    }

    public void revealLetter() {
        for (int i = 0; i < SecretWord.length(); i++) {
            if (!LetterFound[i]) {
                LetterFound[i] = true;
                helpCount++;
                break;
            }
        }
    }
}
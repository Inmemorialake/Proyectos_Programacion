package com.project1.project1.model;

/**
 * Class that controls the program's logic
 * @autor: Inmemorialake (2416541)
 */

public class GameStage {
    private final String SecretWord;
    private final String NormalizedSecretWord;
    private int Attempts;
    private boolean[] LetterFound;
    private String[] GuessedLetters;
    private int helpCount;
    private static final int MAX_HELP_USES = 4;

    /**
     * Constructor of the class
     */
    public GameStage(String secretWord) {
        SecretWord = secretWord;
        NormalizedSecretWord = secretWord.toLowerCase();
        Attempts = 8;
        GuessedLetters = new String[27];
        LetterFound = new boolean[SecretWord.length()];
        helpCount = 0;
    }

    /**
     * Method that verifies if the word entered by user was entered previously
     * @return false if entered by user was not entered previously
     * @return true if entered by user was entered previously
     */

    public boolean isWordGuessed() {
        for (boolean letter : LetterFound) {
            if (!letter) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method that verifies if the game is over
     * @return false if the game is not over
     * @return true if the game is over
     */

    public boolean isGameOver() {
        return Attempts == 0 || isWordGuessed();

    }

    /**
     * Method that decrements the attempts
     */
    public void decrementAttempts() {
        Attempts--;
    }

    /**
     * Method that checks if the letter is in the secret word
     * @param letter The letter to check
     * @return true if the letter is in the secret word
     * @return false if the letter is not in the secret word
     */
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

    /**
     * Method that verifies if the letter was guessed
     * @param letter The letter to verify
     * @return true if the letter was guessed
     * @return false if the letter was not guessed
     */

    public boolean hasGuessedLetter(String letter) {
        for (String guessed : GuessedLetters) {
            if (letter.equals(guessed)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Method that adds the letter to the Guessed Letters Array
     * @param letter the letter to add to the Guessed Letters Array
     */
    public void addGuessedLetters(String letter) {
        for (int i = 0; i < 27; i++) {
            if (GuessedLetters[i] == null) {
                GuessedLetters[i] = letter;
                return;
            }
        }
    }

    /**
     * Method that reveals a letter
     */
    public void revealLetter() {
        for (int i = 0; i < SecretWord.length(); i++) {
            if (!LetterFound[i]) {
                LetterFound[i] = true;
                helpCount++;
                break;
            }
        }
    }

    public String getSecretWord() {
        return SecretWord;
    }

    public int getAttempts() {
        return Attempts;
    }

    public boolean[] getLetterFound() {
        return LetterFound;
    }
    public int getHelpCount() {
        return helpCount;
    }

    public int getMAX_HELP_USES() {
        return MAX_HELP_USES;
    }
}
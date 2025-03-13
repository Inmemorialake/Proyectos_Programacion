package com.project1.project1.controller;

/**
 * Class that controls the program's logic with the model and communicates with the view
 * @autor: Inmemorialake (2416541)
 */

// Imports
import com.project1.project1.model.GameStage;
import com.project1.project1.view.GameScreen;
import com.project1.project1.view.StartScreen;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class StageController {
    private StartScreen startScreen;
    private GameScreen gameScreen;
    GameStage gameStage;

    /**
     * Constructor of the class
     */
    public StageController() {
        this.startScreen = new StartScreen();
        DefaultCursor defaultCursor = new DefaultCursor();
        defaultCursor.setMouseStyle(startScreen.getPlayButton());
        handleStart();
    }

    /**
     * Method that handles the start button and verifies if the secret word is valid
     */
    private void handleStart() {
        startScreen.getPlayButton().setOnAction(actionEvent -> {
            if (startScreen.getSecretWordTextField().getText().length() >= 8) {
                gameStage = new GameStage(startScreen.getSecretWordTextField().getText().trim());
                startScreen.close();
                gameScreen = new GameScreen(gameStage);
                configureListenerTextField(gameScreen.getUserLetterTextField(), gameScreen.getUserLetterTextField(), gameScreen.getErrorLabel());
                handleHelp();
            }
            else {
                startScreen.getErrorLabel().setText("La palabra debe ser de 8 o mas letras, por favor intenta de nuevo");
            }
        });
    }

    /**
     * Method that handles the help button
     */
    private void handleHelp() {
        gameScreen.getHelpButton().setOnAction(actionEvent -> {
            if (gameStage.getHelpCount() < gameStage.getMAX_HELP_USES()){
                gameStage.revealLetter();
                gameScreen.updateGameScreen();
            }
            else {
                gameScreen.getErrorLabel().setText("⚠ No puedes usar esa opción ahora mismo");
                gameScreen.getErrorLabel().setTextFill(Color.RED);
            }
            if (gameStage.getHelpCount() == gameStage.getMAX_HELP_USES()){
                gameScreen.getHelpButton().setDisable(true);
            }

        });
    }

    /**
     * Inner class that sets the default cursor style
     */
    private class DefaultCursor implements IMouseStyler{
        /**
         * Method that sets the mouse style
         * @param button The button to set the style
         */
        @Override
        public void setMouseStyle(Button button) {
            // The mouse and button style when the mouse enters the button
            button.setOnMouseEntered(e -> {
                button.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), null)));
                button.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
                button.setTextFill(Color.web("#9e53e2"));
                button.setCursor(Cursor.HAND);
            });

            // The mouse and button style when the mouse exits the button (and by default)
            button.setOnMouseExited(e -> {
                button.setBackground(new Background(new BackgroundFill(Color.web("#9e53e2"), new CornerRadii(10), null)));
                button.setBorder(new Border(new BorderStroke(Color.web("#9e53e2"), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
                button.setTextFill(Color.WHITE);
                button.setCursor(Cursor.DEFAULT);
            });

            // The mouse and button style when the mouse is clicked on the button
            button.setOnMouseClicked(e -> {
                button.setBackground(new Background(new BackgroundFill(Color.web("#6b3099"), new CornerRadii(10), null)));
                button.setBorder(new Border(new BorderStroke(Color.web("#6b3099"), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
                button.setTextFill(Color.WHITE);
                button.setCursor(Cursor.HAND);
            });
        }
    }

    /**
     * Method that configures the listener of the text field
     * @param textField The text field to configure
     * @param userLetterTextField The user letter text field
     * @param errorLabel The error label
     */
    public void configureListenerTextField(TextField textField, TextField userLetterTextField, Label errorLabel) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            String letter = newValue.trim().toLowerCase();

            // Validate if the letter is valid
            if (letter.length() != 1 || !letter.matches("[a-záéíóúñ]")) {
                errorLabel.setText("⚠ Solo puedes ingresar UNA letra válida");
                errorLabel.setTextFill(Color.RED);
                return;
            }

            // Validate if the letter has already been guessed
            if (gameStage.hasGuessedLetter(letter)) {
                errorLabel.setText("⚠ Ya has ingresado esta letra");
                errorLabel.setTextFill(Color.RED);
                return;
            }

            // Add the letter to the guessed letters
            gameStage.addGuessedLetters(letter);
            if (gameStage.checkLetter(letter.charAt(0))) {
                errorLabel.setText("✅ Letra correcta");
                errorLabel.setTextFill(Color.GREEN);
            } else {
                errorLabel.setText("❌ Letra incorrecta");
                errorLabel.setTextFill(Color.RED);
            }

            // Refresh the game screen
            userLetterTextField.clear();
            gameScreen.updateGameScreen();

            // Validate if the game is over
            if (gameStage.isGameOver()) {
                gameScreen.showGameOver();
            }
        });
    }

};

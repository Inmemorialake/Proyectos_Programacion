package com.project1.project1.controller;

import com.project1.project1.model.GameStage;
import com.project1.project1.view.GameScreen;
import com.project1.project1.view.StartScreen;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

// Class that controls the stage and communicates with the view
public class StageController {
    private StartScreen startScreen;
    private GameScreen gameScreen;
    GameStage gameStage;

    // Constructor of the class
    public StageController() {
        this.startScreen = new StartScreen();
        DefaultCursor defaultCursor = new DefaultCursor();
        defaultCursor.setMouseStyle(startScreen.getPlayButton());
        handleStart();
    }

    // Method that handles the start button
    private void handleStart() {
        startScreen.getPlayButton().setOnAction(actionEvent -> {
            gameStage = new GameStage(startScreen.getSecretWordTextField().getText());
            startScreen.close();
            gameScreen = new GameScreen(gameStage);


        });
    }

    private class DefaultCursor implements IMouseStyler{
        @Override
        public void setMouseStyle(Button button) {
            button.setOnMouseEntered(e -> {
                button.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), null)));
                button.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
                button.setTextFill(Color.web("#9e53e2"));
                button.setCursor(Cursor.HAND);
            });

            button.setOnMouseExited(e -> {
                button.setBackground(new Background(new BackgroundFill(Color.web("#9e53e2"), new CornerRadii(10), null)));
                button.setBorder(new Border(new BorderStroke(Color.web("#9e53e2"), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
                button.setTextFill(Color.WHITE);
                button.setCursor(Cursor.DEFAULT);
            });

            button.setOnMouseClicked(e -> {
                button.setBackground(new Background(new BackgroundFill(Color.web("#6b3099"), new CornerRadii(10), null)));
                button.setBorder(new Border(new BorderStroke(Color.web("#6b3099"), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
                button.setTextFill(Color.WHITE);
                button.setCursor(Cursor.DEFAULT);
            });

        }
    }
}

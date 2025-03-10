package com.project1.project1;

import com.project1.project1.model.GameStage;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main extends Application {
    static String SecretWord = "";

    public static void main(String[] args) {
        System.out.println("Bienvenido al juego \"Eclipse Lunar\"!");
        System.out.println("Ingrese la palabra secreta (Palabra a adivinar): ");
        SecretWord = new Scanner(System.in).nextLine();
        GameStage gameStage = new GameStage(SecretWord);
        gameStage.StartGame();
        System.out.println("Feliz dia!");
    }

    @Override
    public void start(Stage primaryStage) {
    }
}

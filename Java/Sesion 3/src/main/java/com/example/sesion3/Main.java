package com.example.sesion3;

import com.example.sesion3.model.Cat;
import com.example.sesion3.model.Dog;
import com.example.sesion3.model.Smartphone;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        //launch(args);
        Dog dog = new Dog();
        dog.makeSound();

        Cat cat = new Cat();
        cat.makeSound();

        Smartphone smartphone = new Smartphone();
        smartphone.getAproximateCoordinates();
        smartphone.getCoordinates();
        smartphone.nextMusicPlayer();
        smartphone.nextRadio();
    }


    @Override
    public void start(Stage primaryStage) {

    }
}

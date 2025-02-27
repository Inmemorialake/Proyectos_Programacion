package com.example.sesion4;

import com.example.sesion4.model.Cat;
import com.example.sesion4.model.Dog;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        //launch(args);
        Dog dog = new Dog();
        dog.makeSound();

        Cat cat = new Cat();
        cat.makeSound();
    }


    @Override
    public void start(Stage primaryStage) {

    }
}

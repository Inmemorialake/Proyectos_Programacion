package com.example.sesion4.model;

public interface IAnimal {
    void makeSound();

    String TYPE = "Animal";

    default void sleep() {
        System.out.println("El animal esta durmiendo");
    }
}

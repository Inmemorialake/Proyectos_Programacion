package com.example.sesion4.model;

public class Dog implements IAnimal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

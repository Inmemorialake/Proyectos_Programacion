package com.example.sesion4.model;

public interface IMusicPlayer {
    default public void next(){
        System.out.println("Next Song");
    }
}

package com.example.sesion3.model;

public interface IMusicPlayer {
    default public void next(){
        System.out.println("Next Song");
    }
}

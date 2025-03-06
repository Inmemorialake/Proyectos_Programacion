package com.example.sesion4.model;

public interface IRadio {
    void playRadio();

    default public void next(){
        System.out.println("Next Station");
    }
}

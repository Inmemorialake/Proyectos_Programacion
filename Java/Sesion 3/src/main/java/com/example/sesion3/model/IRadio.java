package com.example.sesion3.model;

public interface IRadio {
    void playRadio();

    default public void next(){
        System.out.println("Next Station");
    }
}

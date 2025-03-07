package com.example.sesion4.model;

public class Palabra {
    String palabra;

    public Palabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public byte getLongitud() {
        return (byte) palabra.length();
    }
}

package com.example.sesion4.model;

public class Smartphone implements IGps, IRadio, IMusicPlayer {
    @Override
    public void getCoordinates() {
        System.out.println("Getting coordinates");
    }

    @Override
    public void getAproximateCoordinates() {
        System.out.println("Getting aproximate coordinates");
    }

    @Override
    public void playRadio() {
        System.out.println("Playing radio");
    }

    public void nextRadio() {
        IRadio.super.next();
    }

    public void stopRadio() {
        System.out.println("Stopping radio");
    }

    public void nextMusicPlayer(){
        IMusicPlayer.super.next();
    }
}

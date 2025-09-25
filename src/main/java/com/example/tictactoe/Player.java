package com.example.tictactoe;

public class Player {
    private final String name;
    private final Marker marker;

    public Player(String name, Marker marker) {
        this.name = name;
        this.marker = marker;
    }

    public String name() {
        return name;
    }

    public Marker marker() {
        return marker;
    }
}
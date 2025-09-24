package com.example.tictactoe;

public enum Marker {
    X, O, EMPTY;

    @Override
    public String toString() {
        return this == EMPTY ? " " : name();
    }
}
package com.example.tictactoe;

public class Main {
    public static void main(String[] args) {
        String p1 = args.length > 0 ? args[0] : "Player 1";
        String p2 = args.length > 1 ? args[1] : "Player 2";
        new Game(p1, p2).playLoop();
    }
}

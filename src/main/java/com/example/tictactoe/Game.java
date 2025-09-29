package com.example.tictactoe;

import java.util.Scanner;

public class Game {
    private final Board board = new Board();
    private final Player p1;
    private final Player p2;
    private Player current;

    public Game(String player1Name, String player2Name) {
        this.p1 = new Player(player1Name, Marker.X);
        this.p2 = new Player(player2Name, Marker.O);
        this.current = p1;
    }

    public Board board() {
        return board;
    }

    public void playLoop() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome to Tic-Tac-Toe!");
            System.out.println(board);

            while (!board.hasWinner() && !board.isFull()) {
                System.out.printf("%s (%s), enter row and col (1-3 1-3): ",
                        current.name(), current.marker());
                int r = sc.nextInt() - 1;
                int c = sc.nextInt() - 1;

                try {
                    board.place(r, c, current.marker());
                    System.out.println(board);

                    if (board.hasWinner()) {
                        System.out.printf("🎉 %s wins!\n", current.name());
                        break;
                    } else if (board.isFull()) {
                        System.out.println("It's a draw.");
                        break;
                    }

                    toggle();
                } catch (RuntimeException ex) {
                    System.out.println("Invalid move: " + ex.getMessage());
                }
            }
        }
    }

    private void toggle() {
        current = (current == p1) ? p2 : p1;
    }
}
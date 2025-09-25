package com.example.tictactoe;

import java.util.Arrays;

public class Board {
    private final Marker[][] grid = new Marker[3][3];

    public Board() {
        for (Marker[] row : grid) {
            Arrays.fill(row, Marker.EMPTY);
        }
    }

    public boolean isInBounds(int r, int c) {
        return r >= 0 && r < 3 && c >= 0 && c < 3;
    }

    public Marker get(int r, int c) {
        if (!isInBounds(r, c)) throw new IndexOutOfBoundsException("Out of bounds");
        return grid[r][c];
    }

    public boolean isEmpty(int r, int c) {
        return get(r, c) == Marker.EMPTY;
    }

    public void place(int r, int c, Marker m) {
        if (m == Marker.EMPTY) throw new IllegalArgumentException("Cannot place EMPTY");
        if (!isInBounds(r, c)) throw new IndexOutOfBoundsException("Out of bounds");
        if (!isEmpty(r, c)) throw new IllegalStateException("Cell already taken");
        grid[r][c] = m;
    }

    public boolean isFull() {
        for (var row : grid) {
            for (var cell : row) {
                if (cell == Marker.EMPTY) return false;
            }
        }
        return true;
    }

    public Marker winner() {
        // rows and columns
        for (int i = 0; i < 3; i++) {
            if (line(grid[i][0], grid[i][1], grid[i][2])) return grid[i][0];
            if (line(grid[0][i], grid[1][i], grid[2][i])) return grid[0][i];
        }
        // diagonals
        if (line(grid[0][0], grid[1][1], grid[2][2])) return grid[0][0];
        if (line(grid[0][2], grid[1][1], grid[2][0])) return grid[0][2];
        return Marker.EMPTY;
    }

    public boolean hasWinner() {
        return winner() != Marker.EMPTY;
    }

    private boolean line(Marker a, Marker b, Marker c) {
        return a != Marker.EMPTY && a == b && b == c;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        for (int r = 0; r < 3; r++) {
            sb.append(" ");
            for (int c = 0; c < 3; c++) {
                sb.append(grid[r][c].toString());
                if (c < 2) sb.append(" | ");
            }
            if (r < 2) sb.append("\n---+---+---\n");
        }
        return sb.toString();
    }
}
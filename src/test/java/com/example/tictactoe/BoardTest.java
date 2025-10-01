package com.example.tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class BoardTest {

    @Test
    void placeValidMoveOccupiesCell() {
        Board b = new Board();
        b.place(0, 0, Marker.X);
        assertEquals(Marker.X, b.get(0, 0));
        assertFalse(b.isEmpty(0, 0));
    }

    @Test
    void placingOnTakenCellThrows() {
        Board b = new Board();
        b.place(1, 1, Marker.O);
        assertThrows(IllegalStateException.class, () -> b.place(1, 1, Marker.X));
    }

    @Test
    void detectRowWin() {
        Board b = new Board();
        b.place(2, 0, Marker.X);
        b.place(2, 1, Marker.X);
        b.place(2, 2, Marker.X);
        assertTrue(b.hasWinner());
        assertEquals(Marker.X, b.winner());
    }

    @Test
    void detectDiagonalWin() {
        Board b = new Board();
        b.place(0, 0, Marker.O);
        b.place(1, 1, Marker.O);
        b.place(2, 2, Marker.O);
        assertEquals(Marker.O, b.winner());
    }

    @Test
    void boardFullDrawNoWinner() {
        Board b = new Board();
        
        b.place(0,0, Marker.X); b.place(0,1, Marker.O); b.place(0,2, Marker.X);
        b.place(1,0, Marker.X); b.place(1,1, Marker.X); b.place(1,2, Marker.O);
        b.place(2,0, Marker.O); b.place(2,1, Marker.X); b.place(2,2, Marker.O);

        assertTrue(b.isFull());
        assertFalse(b.hasWinner());
        assertEquals(Marker.EMPTY, b.winner());
    }
}
package com.example.tictactoe;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class GameLogicTest {

    @Test
    void cannotPlaceEmptyMarker() {
        Board b = new Board();
        assertThrows(IllegalArgumentException.class, () -> b.place(0, 0, Marker.EMPTY));
    }

    @Test
    void outOfBoundsThrows() {
        Board b = new Board();
        assertThrows(IndexOutOfBoundsException.class, () -> b.place(3, 3, Marker.X));
    }
}
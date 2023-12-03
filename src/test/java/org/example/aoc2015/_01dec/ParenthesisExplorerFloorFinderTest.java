package org.example.aoc2015._01dec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesisExplorerFloorFinderTest {

    ParenthesisExplorerFloorFinder parenthesisExplorerFloorFinder;

    @BeforeEach
    void setUp() {
        parenthesisExplorerFloorFinder = new ParenthesisExplorerFloorFinder();
    }

    @Test
    void calculateFloor() {
        assertEquals(0, parenthesisExplorerFloorFinder.calculateFloor("()()"));
        assertEquals(3, parenthesisExplorerFloorFinder.calculateFloor("))((((("));
        assertEquals(-3, parenthesisExplorerFloorFinder.calculateFloor(")())())"));
    }
}
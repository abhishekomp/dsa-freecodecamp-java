package org.example.puzzles.jumpingreachingendofarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalyzeJumpTest {
    AnalyzeJump analyzeJump;

    @BeforeEach
    void setUp() {
        analyzeJump = new AnalyzeJump();
    }

    @Nested
    @DisplayName("Tests for verifying for reaching the end")
    class ReachEndVerifier{
        @Test
        void canReachTheEnd_true() {
            int[] inputArr = {2, 3, 1, 1, 4};
            assertTrue(analyzeJump.canReachTheEnd(inputArr));
        }

        @Test
        void canReachTheEnd_false() {
            int[] inputArr = {3, 2, 1, 0, 4};
            assertTrue(analyzeJump.canReachTheEnd(inputArr));
        }
    }

    @Test
    void returnInt() {
        assertEquals(1, analyzeJump.returnInt());
    }
}
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
    @DisplayName("Can you reach the end of the array, Can you reach the end of the staircase")
    class ReachEndVerifier{

        @Test
        void canReachTheEnd_true_test() {
            //int[] inputArr = {1, 1, 2, 5};    //true
            //int[] inputArr = {3, 0, 0, 5};  //true
            //int[] inputArr = {2, 0, 1, 5};  //true
            int[] inputArr = {2, 0, 0, 5};
            assertFalse(analyzeJump.canReachTheEnd(inputArr));
        }

        @Test
        void canReachTheEnd_true() {
            int[] inputArr = {2, 3, 1, 1, 4};
            assertTrue(analyzeJump.canReachTheEnd(inputArr));
        }

        @Test
        void canReachTheEnd_true_another() {
            int[] inputArr = {1, 1, 2, 5, 2, 1, 0, 0, 1, 3};
            assertTrue(analyzeJump.canReachTheEnd(inputArr));
        }

        @Test
        void canReachTheEnd_false() {
            int[] inputArr = {3, 2, 1, 0, 4};
            assertFalse(analyzeJump.canReachTheEnd(inputArr));
        }

        @Test
        void canReachTheEnd_false_2nd_attempt() {
            int[] inputArr = {1, 1, 2, 4, 2, 1, 0, 0, 1, 3};
            assertFalse(analyzeJump.canReachTheEnd(inputArr));
        }

        @Test
        void canReachTheEnd_true_one_element() {
            int[] inputArr = {2};
            assertTrue(analyzeJump.canReachTheEnd(inputArr));
        }
    }

    @Nested
    @DisplayName("Can you reach the end of the array, Can you reach the end of the staircase")
    class MinimumNumberOfStepsToReachTheEnd{
        @Test
        void minimumStepsToReachTheEnd() {
            int[] inputArr = {2, 3, 1, 1, 4};
            assertEquals(2, analyzeJump.minimumStepsToReachTheEnd(inputArr));
            // 2 -> 3 -> 4 gives 2 jumps as the minimum number of jumps needs to reach the end.
        }

        @Test
        void minimumStepsToReachTheEnd_2() {
            int[] inputArr = {2, 4, 1, 2, 3, 1, 1, 2};
            assertEquals(3, analyzeJump.minimumStepsToReachTheEnd(inputArr));
            // 2 -> 4 -> 3 -> 2 gives 3 as the minimum number of jumps needs to reach the end.
        }

        @Test
        void minimumStepsToReachTheEnd_3() {
            int[] inputArr = {2, 4, 1, 2, 3, 4, 1, 2, 2};
            assertEquals(3, analyzeJump.minimumStepsToReachTheEnd(inputArr));
            // 2 -> 4 -> 4 -> 2 gives 3 jumps as the minimum number of jumps needs to reach the end.
        }

        @Test
        void minimumStepsToReachTheEnd_4() {
            int[] inputArr = {2, 3, 1, 2, 3, 4, 1, 2, 2};
            assertEquals(4, analyzeJump.minimumStepsToReachTheEnd(inputArr));
            // 2 -> 3 -> 3 -> 4 -> 2 gives 4 jumps as the minimum number of jumps needs to reach the end.
        }


    }

    @Test
    void returnInt() {
        assertEquals(1, analyzeJump.returnInt());
    }
}
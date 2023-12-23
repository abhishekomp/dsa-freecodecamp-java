package org.example.puzzles.longest_increasing_sequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSequenceTest {

    LongestIncreasingSequence longestIncreasingSequence;

    @BeforeEach
    void setUp() {
        longestIncreasingSequence = new LongestIncreasingSequence();
    }

    @Test
    void longestIncreasingSequenceLength() {
        int[] input = {2, 4, 0, 5};
        int length = longestIncreasingSequence.longestIncreasingSequenceLength(input);
        System.out.println(length);
        assertEquals(3, length);
    }

    @Test
    void longestIncreasingSequenceLength_2() {
        int[] input = {3, 4, -1, 0, 6, 2, 3};
        int length = longestIncreasingSequence.longestIncreasingSequenceLength(input);
        System.out.println(length);
        assertEquals(4, length);
    }

    @Test
    void longestIncreasingSequenceLength_3() {
        int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
        int length = longestIncreasingSequence.longestIncreasingSequenceLength(input);
        System.out.println(length);
        assertEquals(4, length);
    }

    @Test
    void longestIncreasingSequenceLength_4() {
        int[] input = {0, 1, 0, 3, 2, 3};
        int length = longestIncreasingSequence.longestIncreasingSequenceLength(input);
        System.out.println(length);
        assertEquals(4, length);
    }

    @Test
    void longestIncreasingSequenceLength_5() {
        int[] input = {7, 7, 7, 7, 7, 7};
        int length = longestIncreasingSequence.longestIncreasingSequenceLength(input);
        System.out.println(length);
        assertEquals(1, length);
    }

    @Test
    void longestIncreasingSequenceLength_6() {
        int[] input = {7, 8};
        int length = longestIncreasingSequence.longestIncreasingSequenceLength(input);
        System.out.println(length);
        assertEquals(2, length);
    }

    @Test
    void longestIncreasingSequenceLength_7() {
        int[] input = {4};
        int length = longestIncreasingSequence.longestIncreasingSequenceLength(input);
        System.out.println(length);
        assertEquals(1, length);
    }


}



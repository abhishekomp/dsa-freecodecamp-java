package org.example.puzzles.fruitsInBasket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LongestContiguousSequenceTest {

    LongestContiguousSequence longestContiguousSequence;

    @BeforeEach
    void setUp() {
        longestContiguousSequence = new LongestContiguousSequence();
    }

    @Test
    void extractLongestContiguousSeq() {
        int[] inputArr = {1, 2, 1};
        int[] ints = longestContiguousSequence.extractLongestContiguousSeq(inputArr);
        System.out.println(Arrays.toString(ints));
        int[] expectedArr = {1, 2, 1};
        assertArrayEquals(expectedArr, ints);
    }

    @Test
    void extractLongestContiguousSeq_2() {
        int[] inputArr = {0, 1, 2, 2};
        int[] ints = longestContiguousSequence.extractLongestContiguousSeq(inputArr);
        System.out.println(Arrays.toString(ints));
        int[] expectedArr = {1, 2, 2};
        assertArrayEquals(expectedArr, ints);
    }

    @Test
    void extractLongestContiguousSeq_3() {
        int[] inputArr = {1, 2, 3, 2, 2};
        int[] ints = longestContiguousSequence.extractLongestContiguousSeq(inputArr);
        System.out.println(Arrays.toString(ints));
        int[] expectedArr = {2, 3, 2, 2};
        assertArrayEquals(expectedArr, ints);
    }

    @Test
    void extractLongestContiguousSeq_4() {
        int[] inputArr = {1, 2, 1, 1, 3, 4, 2, 2, 2, 2, 4};
        int[] ints = longestContiguousSequence.extractLongestContiguousSeq(inputArr);
        System.out.println(Arrays.toString(ints));
        int[] expectedArr = {4, 2, 2, 2, 2, 4};
        assertArrayEquals(expectedArr, ints);
    }

    @Test
    void extractLongestContiguousSeq_5() {
        int[] inputArr = {1};
        int[] ints = longestContiguousSequence.extractLongestContiguousSeq(inputArr);
        System.out.println(Arrays.toString(ints));
        int[] expectedArr = {1};
        assertArrayEquals(expectedArr, ints);
    }


}
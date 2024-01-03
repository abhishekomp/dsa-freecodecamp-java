package org.example.puzzles.repeatedSubArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedSubArrayTest {

    RepeatedSubArray repeatedSubArray;

    @BeforeEach
    void setUp() {
        repeatedSubArray = new RepeatedSubArray();
    }

    @Test
    void lengthOfLongestCommonSubArray() {
        int[] arrOne = {1, 2, 3, 2, 1};
        int[] arrTwo = {3, 2, 1, 4, 7};
        repeatedSubArray.lengthOfLongestCommonSubArray(arrOne, arrTwo);
    }
}
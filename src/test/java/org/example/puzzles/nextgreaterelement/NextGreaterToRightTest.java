package org.example.puzzles.nextgreaterelement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author  : Abhishek
 * @since   : 2024-01-29, Monday
 **/
class NextGreaterToRightTest {
    private NextGreaterToRight nextGreaterToRight;

    @BeforeEach
    void setUp() {
        nextGreaterToRight = new NextGreaterToRight();
    }

    @Test
    void nextGreaterToRight() {
        int[] input = {10, 8, 6, 4, 2};
        int[] resultArray = nextGreaterToRight.nextGreaterToRight(input);
        int[] expectedArray = {-1, -1, -1, -1, -1};
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(resultArray));
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    void nextGreaterToRight_2() {
        int[] input = {10, 8, 60, 4, 2};
        int[] resultArray = nextGreaterToRight.nextGreaterToRight(input);
        int[] expectedArray = {60, 60, -1, -1, -1};
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(resultArray));
        assertArrayEquals(expectedArray, resultArray);
    }
}
package org.example.puzzles.nextgreaterelement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author  : Abhishek
 * @since   : 2024-01-26, Friday
 **/
class NextGreaterElementTest {

    NextGreaterElement nextGreaterElement;

    @BeforeEach
    void setUp() {
        nextGreaterElement = new NextGreaterElement();
    }

    @Test
    void nextGreaterElements() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] nextGreaterElements = nextGreaterElement.nextGreaterElements(nums1, nums2);
        System.out.println(Arrays.toString(nextGreaterElements));
        int[] expectedNextGreaterElements = {-1, 3, -1};
        assertArrayEquals(expectedNextGreaterElements, nextGreaterElements);
    }

    @Test
    void nextGreaterElements_2() {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] nextGreaterElements = nextGreaterElement.nextGreaterElements(nums1, nums2);
        System.out.println(Arrays.toString(nextGreaterElements));
        int[] expectedNextGreaterElements = {3, -1};
        assertArrayEquals(expectedNextGreaterElements, nextGreaterElements);
    }

    //
    @Test
    void nextGreaterElements_3() {
        //int[] nums1 = {2, 4};
        int[] nums2 = {73,74,75,71,69,72,76,73};
        int[] nextGreaterElements = nextGreaterElement.nextGreaterElements(nums2);
        System.out.println(Arrays.toString(nextGreaterElements));
        int[] expectedNextGreaterElements = {74, 75, 76, 72, 72, 76, -1, -1};
        assertArrayEquals(expectedNextGreaterElements, nextGreaterElements);
    }
}
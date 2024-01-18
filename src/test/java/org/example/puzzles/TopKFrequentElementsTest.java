package org.example.puzzles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Abhishek
 * @since : 2024-01-18, Thursday
 **/
class TopKFrequentElementsTest {
    TopKFrequentElements topKFrequentElements;

    @BeforeEach
    void setUp() {
        topKFrequentElements = new TopKFrequentElements();
    }

    @Test
    void topKFrequentElements() {
        int[] input = {1, 1, 1, 2, 2, 3};
        int[] ints = topKFrequentElements.topKFrequentElements(input, 1);
        System.out.println(Arrays.toString(ints));
        int[] expectedToElements = {1};
        assertArrayEquals(expectedToElements, ints);
    }

    @Test
    void topKFrequentElements_2() {
        int[] input = {1, 1, 1, 2, 2, 3};
        int[] ints = topKFrequentElements.topKFrequentElements(input, 2);
        System.out.println(Arrays.toString(ints));
        int[] expectedToElements = {1, 2};
        assertArrayEquals(expectedToElements, ints);
    }
    @Test
    void topKFrequentElements_3() {
        int[] input = {4, 4, 4, 2, 2, 3};
        int[] ints = topKFrequentElements.topKFrequentElements(input, 1);
        System.out.println(Arrays.toString(ints));
        int[] expectedToElements = {4};
        assertArrayEquals(expectedToElements, ints);
    }
    @Test
    void topKFrequentElements_4() {
        int[] input = {1, 1, 1, 2, 2, 3, 3, 4};
        int[] ints = topKFrequentElements.topKFrequentElements(input, 2);
        //System.out.println(Arrays.toString(ints));
        int[] expectedToElements = {1, 2, 3};
        assertArrayEquals(expectedToElements, ints);
    }
    @Test
    void topKFrequentElements_5() {
        int[] input = {100, 100, 100, 200, 200, 400, 400, 500};
        int[] ints = topKFrequentElements.topKFrequentElements(input, 2);
        //System.out.println(Arrays.toString(ints));
        int[] expectedToElements = {100, 200, 400};
        //assertArrayEquals(expectedToElements, ints);
        assertThat(ints).containsOnly(expectedToElements);
    }
}
package org.example.puzzles.fruitsInBasket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    void extractLongestContiguousSeq_3a() {
        int[] inputArr = {1, 2, 3, 2, 2, 8, 8, 6, 8};
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


    @Test
    void extractLongestContiguousStringWith2DistinctCharacter() {
        String input = "Akassa";
        String result = longestContiguousSequence.extractLongestContiguousStringWith2DistinctCharacter(input);
        System.out.println(result);
        String expectedString = "assa";
        assertEquals(expectedString, result);
    }

    @Test
    void extractLongestContiguousStringWith2DistinctCharacter_2() {
        String input = "YellowBanana";
        String result = longestContiguousSequence.extractLongestContiguousStringWith2DistinctCharacter(input);
        System.out.println(result);
        String expectedString = "anana";
        assertEquals(expectedString, result);
    }

    @Test
    void extractLongestContiguousStringWith2DistinctCharacter_3() {
        String input = "YellowBanana";
        String result = longestContiguousSequence.extractLongestContiguousStringWithNDistinctCharacter(input, 2);
        System.out.println(result);
        String expectedString = "anana";
        assertEquals(expectedString, result);
    }

    @Test
    void extractLongestContiguousStringWith3DistinctCharacter() {
        String input = "YellowBananapapaya";
        String result = longestContiguousSequence.extractLongestContiguousStringWithNDistinctCharacter(input, 3);
        System.out.println(result);
        String expectedString = "ananapapa";
        assertEquals(expectedString, result);
    }

    @Test
    void extractLongestContiguousStringWith3DistinctCharacter_2() {
        String input = "akassa";
        String result = longestContiguousSequence.extractLongestContiguousStringWithNDistinctCharacter(input, 2);
        System.out.println(result);
        String expectedString = "assa";
        assertEquals(expectedString, result);
    }

    @Test
    void test_sort_a_list_of_strings_based_on_their_length(){
        List<String> strings = List.of("aka", "assa");  //To do: what if this list is empty then how will you handle the longest string.
        List<String> collect = strings.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println(collect.get(0));
    }
}
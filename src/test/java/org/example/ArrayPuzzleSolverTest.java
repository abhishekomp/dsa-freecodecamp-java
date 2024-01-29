package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author  : Abhishek
 * @since   : 2024-01-29, Monday
 **/
class ArrayPuzzleSolverTest {

    private ArrayPuzzleSolver arrayPuzzleSolver;

    @BeforeEach
    void setUp() {
        arrayPuzzleSolver = new ArrayPuzzleSolver();
    }

    @Test
    void subArrayWithGivenSum() {
        int[] input = {10, 15, -5, 30, 10};
        int expectedSum = 20;
        String resultString = arrayPuzzleSolver.subArrayWithGivenSum(input, expectedSum);
        String expectedString = "Sub-Array found with start index: 0 end: 2";
        assertEquals(expectedString, resultString);
    }

    @Test
    void subArrayWithGivenSum_2() {
        int[] input = {10, 15, -5, 30, 10};
        int expectedSum = 10;
        String resultString = arrayPuzzleSolver.subArrayWithGivenSum(input, expectedSum);
        String expectedString = "Sub-Array found with start index: 0 end: 0";
        assertEquals(expectedString, resultString);
    }

    @Test
    void subArrayWithGivenSum_3() {
        int[] input = {10, 20, 30};
        int expectedSum = 50;
        String resultString = arrayPuzzleSolver.subArrayWithGivenSum(input, expectedSum);
        String expectedString = "Sub-Array found with start index: 1 end: 2";
        assertEquals(expectedString, resultString);
    }

    @Test
    void subArrayWithGivenSum_4() {
        int[] input = {10, 20, 30,40};
        int expectedSum = 40;
        String resultString = arrayPuzzleSolver.subArrayWithGivenSum(input, expectedSum);
        String expectedString = "Sub-Array found with start index: 3 end: 3";
        assertEquals(expectedString, resultString);
    }

    @Test
    void subArrayWithGivenSum_5() {
        int[] input = {10, 20, 30,40};
        int expectedSum = 45;
        String resultString = arrayPuzzleSolver.subArrayWithGivenSum(input, expectedSum);
        String expectedString = "Not found";
        assertEquals(expectedString, resultString);
    }

//    @Test
//    void shortestSubArrayWithGivenSum() {
//        int[] input = {10, 20, 30, 40};
//        int expectedSum = 30;
//        String resultString = arrayPuzzleSolver.shortestSubArrayWithGivenSum(input, expectedSum);
//        String expectedString = "Sub-Array found with start index: 2 end: 2";
//        assertEquals(expectedString, resultString);
//    }

    @Test
    void sumOfAllSubArraysOfGivenLength() {
        int[] input = {10, 20, 30, 40};
        int sum = arrayPuzzleSolver.sumOfAllSubArraysOfGivenLength(input, 3);
        System.out.println(sum);
        assertEquals(150, sum);
    }

    @Test
    void sumOfAllSubArraysOfGivenLength_2() {
        int[] input = {10, 20, 30, 40, -50};
        int sum = arrayPuzzleSolver.sumOfAllSubArraysOfGivenLength(input, 4);
        System.out.println(sum);
        assertEquals(140, sum);
    }

    @Test
    void sumOfAllSubArraysOfGivenLength_3() {
        int[] input = {-10, 20, 30, 40};
        int sum = arrayPuzzleSolver.sumOfAllSubArraysOfGivenLength(input, 3);
        System.out.println(sum);
        assertEquals(130, sum);
    }

}
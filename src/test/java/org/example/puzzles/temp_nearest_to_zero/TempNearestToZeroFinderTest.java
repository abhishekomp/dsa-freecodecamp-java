package org.example.puzzles.temp_nearest_to_zero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TempNearestToZeroFinderTest {

    TempNearestToZeroFinder program;

    @BeforeEach
    void setUp(){
        program = new TempNearestToZeroFinder();
    }

    @Test
    void findTempNearestToZero() {
        int[] intTemp = new int[]{-1, 5};
        int nearest = program.findTempNearestToZero(intTemp);
        System.out.println("nearest = " + nearest);
        assertEquals(-1, nearest);
    }

    @Test
    void findTempNearestToZeroTry2() {
        int[] intTemp = new int[]{-10, -2, 4, 5};
        int nearest = program.findTempNearestToZero(intTemp);
        System.out.println("nearest = " + nearest);
        assertEquals(-2, nearest);
    }

    @Test
    void findTempNearestToZeroTry3() {
        int[] intTemp = new int[]{-16, -10, -6, 4, 5, 8};
        int nearest = program.findTempNearestToZero(intTemp);
        System.out.println("nearest = " + nearest);
        assertEquals(4, nearest);
    }

    @Test
    void findTempNearestToZeroWithDecimalValues() {
        Float[] floatTemp = new Float[]{-0.5f, 2.5f};
        //int nearest = program.findTempNearestToZeroGeneric(floatTemp);
        double nearest = TempNearestToZeroFinder.findTempNearestToZeroGeneric(floatTemp, 0);
        System.out.println("nearest = " + nearest);
        assertEquals(-0.5f, nearest);
    }


    @Test
    void findTempNearestToZeroWithDecimalValuesTry2() {
        Float[] floatTemp = new Float[]{-1.5f, -0.02f, 0.4f, 1.5f};
        //int nearest = program.findTempNearestToZeroGeneric(floatTemp);
        double nearest = TempNearestToZeroFinder.findTempNearestToZeroGeneric(floatTemp, 0);
        System.out.println("nearest = " + nearest);
        assertEquals(Double.parseDouble(String.format("%.2f", -0.019999)), nearest);
    }
}
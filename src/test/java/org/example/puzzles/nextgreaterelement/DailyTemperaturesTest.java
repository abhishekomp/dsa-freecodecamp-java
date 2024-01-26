package org.example.puzzles.nextgreaterelement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author  : Abhishek
 * @since   : 2024-01-26, Friday
 **/
class DailyTemperaturesTest {

    DailyTemperatures dailyTemperatures;

    @BeforeEach
    void setUp() {
        dailyTemperatures = new DailyTemperatures();
    }

    @Test
    void nextHigherTemperatureAfterNumberOfDays() {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] nextHigherTemperatureAfterNumberOfDays = dailyTemperatures.nextHigherTemperatureAfterNumberOfDays(temperatures);
        int[] expectedResult = {1,1,4,2,1,1,0,0};
        System.out.println(Arrays.toString(temperatures));
        System.out.println(Arrays.toString(nextHigherTemperatureAfterNumberOfDays));
        assertArrayEquals(expectedResult, nextHigherTemperatureAfterNumberOfDays);
    }

    @Test
    void nextHigherTemperatureAfterNumberOfDays_2() {
        int[] temperatures = {30,40,50,60};
        int[] nextHigherTemperatureAfterNumberOfDays = dailyTemperatures.nextHigherTemperatureAfterNumberOfDays(temperatures);
        int[] expectedResult = {1,1,1,0};
        System.out.println(Arrays.toString(temperatures));
        System.out.println(Arrays.toString(nextHigherTemperatureAfterNumberOfDays));
        assertArrayEquals(expectedResult, nextHigherTemperatureAfterNumberOfDays);
    }

    @Test
    void nextHigherTemperatureAfterNumberOfDays_3() {
        int[] temperatures = {30,60,90};
        int[] nextHigherTemperatureAfterNumberOfDays = dailyTemperatures.nextHigherTemperatureAfterNumberOfDays(temperatures);
        int[] expectedResult = {1,1,0};
        System.out.println(Arrays.toString(temperatures));
        System.out.println(Arrays.toString(nextHigherTemperatureAfterNumberOfDays));
        assertArrayEquals(expectedResult, nextHigherTemperatureAfterNumberOfDays);
    }
}
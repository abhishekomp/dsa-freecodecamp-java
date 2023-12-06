package org.example.puzzles.aoc2023._05dec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationCalculatorTest {

    LocationCalculator locationCalculator;

    @BeforeEach
    void setUp() {
        locationCalculator = new LocationCalculator();
    }

    @Test
    void calculateLowestLocation() {
        locationCalculator.calculateLowestLocation("day5", "Day5Sample.txt");
    }

    @Test
    void calculateLowestLocation_part1() {
        locationCalculator.calculateLowestLocation("day5", "Day5Part1Input.txt");
    }
}
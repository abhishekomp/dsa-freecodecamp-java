package org.example.puzzles.aoc2023._05dec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeedNumberFetcherTest {

    SeedNumberFetcher seedNumberFetcher;

    @BeforeEach
    void setUp() {
        seedNumberFetcher = new SeedNumberFetcher();
    }

    @Test
    void fetchSeedNumbers() {
        List<Long> seedNumbers = seedNumberFetcher.fetchSeedNumbers("day5", "Day5Sample.txt");
        System.out.println(seedNumbers);
        assertEquals(27, seedNumbers.size());
        //assertIterableEquals(List.of(79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67), seedNumbers);
    }
}
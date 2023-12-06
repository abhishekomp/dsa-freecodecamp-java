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
        assertIterableEquals(List.of(79, 14, 55, 13), seedNumbers);
    }
}
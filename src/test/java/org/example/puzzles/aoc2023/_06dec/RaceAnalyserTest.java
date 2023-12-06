package org.example.puzzles.aoc2023._06dec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceAnalyserTest {

    RaceAnalyser raceAnalyser;

    @BeforeEach
    void setUp(){
        raceAnalyser = new RaceAnalyser();
    }

    @Test
    void numberOfWaysToBreakTheRecord() {
        int numberOfWaysToBreakTheRecord = raceAnalyser.numberOfWaysToBreakTheRecord(new Race(7, 9));
        assertEquals(4, numberOfWaysToBreakTheRecord);
    }

    @Test
    void numberOfWaysToBreakTheRecord2() {
        int numberOfWaysToBreakTheRecord = raceAnalyser.numberOfWaysToBreakTheRecord(new Race(15, 40));
        assertEquals(8, numberOfWaysToBreakTheRecord);
    }

    @Test
    void numberOfWaysToBreakTheRecord3() {
        int numberOfWaysToBreakTheRecord = raceAnalyser.numberOfWaysToBreakTheRecord(new Race(30, 200));
        assertEquals(9, numberOfWaysToBreakTheRecord);
    }

    @Test
    void readFileAndCreateRaces() {
        List<Race> races = raceAnalyser.readFileAndCreateRaces("day6", "Day6Sample.txt");
        races.forEach(System.out::println);
    }
}
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

    @Test
    void readFileAndCreateRacesSample2() {
        List<Race> races = raceAnalyser.readFileAndCreateRaces("day6", "Day6Sample2.txt");
        races.forEach(System.out::println);
    }

    @Test
    void readFileAndCreateRacesPart2() {
        //Double value = Double.parseDouble("499221010971440");
        List<Race> races = raceAnalyser.readFileAndCreateRaces("day6", "Day6InputPart2.txt");
        races.forEach(System.out::println);
        //Race{totalAllowedDuration=5.6977793E7, currentRecord=4.9922101097144E14}
    }

    @Test
    void numberOfWaysToBreakTheRecordSample2() {
        int numberOfWaysToBreakTheRecord = raceAnalyser.numberOfWaysToBreakTheRecord(new Race(71530, 940200));
        assertEquals(71503, numberOfWaysToBreakTheRecord);
    }

    @Test
    void numberOfWaysToBreakTheRecordPart2() {
        int numberOfWaysToBreakTheRecord = raceAnalyser.numberOfWaysToBreakTheRecord(new Race(5.6977793E7, 4.9922101097144E14));
        assertEquals(3.5349468E7, numberOfWaysToBreakTheRecord);
    }
}
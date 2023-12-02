package org.example.puzzles.aoc2023._02dec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AOC02Dec2023Test {

    AOC02Dec2023 program;

    @BeforeEach
    void setUp() {
        program = new AOC02Dec2023();
    }

    @Test
    void readFile() {
        List<String> lines = program.readFile("day2", "Day2Sample.txt");
        lines.forEach(System.out::println);
    }


}
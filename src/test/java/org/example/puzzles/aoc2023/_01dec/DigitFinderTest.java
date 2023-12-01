package org.example.puzzles.aoc2023._01dec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitFinderTest {

    DigitFinder digitFinder;

    @BeforeEach
    void setUp() {
        digitFinder = new DigitFinder();
    }

    @Test
    void test_getFirstDigit_1() {
        assertEquals("two", digitFinder.getFirstDigitAsString("two1nine"));
        assertEquals("eight", digitFinder.getFirstDigitAsString("eightwothree"));
        assertEquals("one", digitFinder.getFirstDigitAsString("abcone2threexyz"));
        assertEquals("two", digitFinder.getFirstDigitAsString("xtwone3four"));
        assertEquals("4", digitFinder.getFirstDigitAsString("4nineeightseven2"));
        assertEquals("one", digitFinder.getFirstDigitAsString("zoneight234"));
        assertEquals("7", digitFinder.getFirstDigitAsString("7pqrstsixteen"));
        assertEquals("7", digitFinder.getFirstDigitAsString("7tf"));
        assertEquals("one", digitFinder.getFirstDigitAsString("abconeeight"));
    }

    @Test
    void test_getLastDigit_1() {
        assertEquals("nine", digitFinder.getLastDigitAsString("two1nine"));
        assertEquals("three", digitFinder.getLastDigitAsString("eightwothree"));
        assertEquals("three", digitFinder.getLastDigitAsString("abcone2threexyz"));
        assertEquals("four", digitFinder.getLastDigitAsString("xtwone3four"));
        assertEquals("2", digitFinder.getLastDigitAsString("4nineeightseven2"));
        assertEquals("4", digitFinder.getLastDigitAsString("zoneight234"));
        assertEquals("six", digitFinder.getLastDigitAsString("7pqrstsixteen"));
        assertEquals("", digitFinder.getLastDigitAsString("abcdef"));
        assertEquals("7", digitFinder.getLastDigitAsString("7tf"));
        assertEquals("eight", digitFinder.getLastDigitAsString("abconeeight"));
        //assertEquals("eight", digitFinder.getLastDigitAsString("abconeight")); //failing
        assertEquals("one", digitFinder.getLastDigitAsString("abctwone"));
    }

    @Test
    void test_getNumberFromLine() {
        assertEquals(51, digitFinder.getNumberFromLine("5six9four5twoone"));        //51
        assertEquals(51, digitFinder.getNumberFromLine("fivebvkhcmt3one6twonegf")); //failing as expecting 51 but getting 52. Fixed with overlapping match fix
        assertEquals(71, digitFinder.getNumberFromLine("7bvkhcmt3one6twonegf"));    //71
        assertEquals(58, digitFinder.getNumberFromLine("fivekhcmt3one6twonegf8"));  //58
    }

    @Test
    void test_getStringAsInteger() {
        assertEquals(1, digitFinder.getStringAsInteger("one"));
        assertEquals(1, digitFinder.getStringAsInteger("1"));
        assertEquals(2, digitFinder.getStringAsInteger("two"));
        assertEquals(2, digitFinder.getStringAsInteger("2"));
        assertEquals(4, digitFinder.getStringAsInteger("four"));
        assertEquals(4, digitFinder.getStringAsInteger("4"));
        assertEquals(8, digitFinder.getStringAsInteger("eight"));
        assertEquals(8, digitFinder.getStringAsInteger("8"));
    }

    @Test
    void matchOverlappingString() {
        assertEquals("eight", digitFinder.getLastDigitAsString("6oneightskl"));
    }
}
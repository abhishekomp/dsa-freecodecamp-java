package org.example.puzzles.aoc2023._07dec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTypeCheckerTest {

    HandTypeChecker handTypeChecker;

    @BeforeEach
    void setUp() {
        handTypeChecker = new HandTypeChecker();
    }

    @Test
    void isHandFiveOfAKind() {
        assertTrue(handTypeChecker.isHandFiveOfAKind("AAAAA"));
        assertTrue(handTypeChecker.isHandFiveOfAKind("KKKKK"));
        assertTrue(handTypeChecker.isHandFiveOfAKind("11111"));
        assertFalse(handTypeChecker.isHandFiveOfAKind("TTTT8"));
        assertTrue(handTypeChecker.isHandFiveOfAKind("44444"));
//        System.out.println("AAAAA " + handTypeRegex.isHandFiveOfAKind("AAAAA"));
//        System.out.println("KKKKK " + handTypeRegex.isHandFiveOfAKind("KKKKK"));
//        System.out.println("BBBBB " + handTypeRegex.isHandFiveOfAKind("BBBBB"));
//        System.out.println("TTTTT " + handTypeRegex.isHandFiveOfAKind("TTTTT"));
//        System.out.println("QQQQQ " + handTypeRegex.isHandFiveOfAKind("QQQQQ"));
//        System.out.println("KKKKQ " + handTypeRegex.isHandFiveOfAKind("KKKKQ"));
//        System.out.println("11111 " + handTypeRegex.isHandFiveOfAKind("11111"));
//        System.out.println("1111 " + handTypeRegex.isHandFiveOfAKind("1111"));
//        System.out.println("44444 " + handTypeRegex.isHandFiveOfAKind("44444"));
//        System.out.println("4444T " + handTypeRegex.isHandFiveOfAKind("4444T"));
//        System.out.println("QKKKK " + handTypeRegex.isHandFiveOfAKind("QKKKK"));
//        assertTrue(handTypeRegex.isHandFiveOfAKind("AAAAA"));
//        assertTrue(handTypeRegex.isHandFiveOfAKind("KKKKK"));
//        assertFalse(handTypeRegex.isHandFiveOfAKind("BBBBB"));
//        assertTrue(handTypeRegex.isHandFiveOfAKind("TTTTT"));
//        assertTrue(handTypeRegex.isHandFiveOfAKind("QQQQQ"));
//        assertTrue(handTypeRegex.isHandFiveOfAKind("KKKKQ"));
//        assertTrue(handTypeRegex.isHandFiveOfAKind("11111"));
//        assertTrue(handTypeRegex.isHandFiveOfAKind("1111"));
//        assertTrue(handTypeRegex.isHandFiveOfAKind("44444"));
//        assertTrue(handTypeRegex.isHandFiveOfAKind("4444T"));
//        assertTrue(handTypeRegex.isHandFiveOfAKind("QKKKK"));
    }



    @Test
    void isHandFourOfAKind() {
        assertTrue(handTypeChecker.isHandFourOfAKind("AA8AA"));
        assertTrue(handTypeChecker.isHandFourOfAKind("AAAA8"));
        assertFalse(handTypeChecker.isHandFourOfAKind("AAAK8"));
        assertFalse(handTypeChecker.isHandFourOfAKind("AAAAA"));
        assertTrue(handTypeChecker.isHandFourOfAKind("8QQQQ"));
    }

    @Test
    void isHandAFullHouse() {
        assertTrue(handTypeChecker.isHandAFullHouse("23332"));
        assertTrue(handTypeChecker.isHandAFullHouse("8QQQT"));
        assertFalse(handTypeChecker.isHandAFullHouse("QQQQQ"));
    }

    @Test
    void isHandAThreeOfAKind() {
        assertTrue(handTypeChecker.isHandAThreeOfAKind("TTT98"));
        assertTrue(handTypeChecker.isHandAThreeOfAKind("9KKK8"));
        assertFalse(handTypeChecker.isHandAThreeOfAKind("QQQQQ"));
    }

    @Test
    void isHandATwoPair() {
        assertTrue(handTypeChecker.isHandATwoPair("23432"));
        assertTrue(handTypeChecker.isHandATwoPair("K9K98"));
        assertFalse(handTypeChecker.isHandATwoPair("QQQQQ"));
    }

    @Test
    void isHandAOnePair() {
        assertTrue(handTypeChecker.isHandAOnePair("A23A4"));
        assertTrue(handTypeChecker.isHandAOnePair("TKQ9T"));
        assertFalse(handTypeChecker.isHandAOnePair("K9K98"));
        assertFalse(handTypeChecker.isHandAOnePair("QQQQQ"));
    }

    @Test
    void isHandAHighCard() {
        assertTrue(handTypeChecker.isHandAHighCard("23456"));
        assertTrue(handTypeChecker.isHandAHighCard("AKQJT"));
        assertFalse(handTypeChecker.isHandAHighCard("TT77Q"));
        assertFalse(handTypeChecker.isHandAHighCard("QQQQQ"));
    }
}
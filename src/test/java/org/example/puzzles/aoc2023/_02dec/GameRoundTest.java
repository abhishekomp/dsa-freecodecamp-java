package org.example.puzzles.aoc2023._02dec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRoundTest {

    @Test
    void isRoundValidTrue() {
        GameRound gameRound = new GameRound("3 blue, 4 red");
        System.out.println("Round: " + gameRound + " validity: " + gameRound.isRoundValid());
    }

    @Test
    void isRoundValidFalse() {
        GameRound gameRound = new GameRound("3 green, 15 blue, 14 red");
        System.out.println("Round: " + gameRound + " validity: " + gameRound.isRoundValid());
    }
}
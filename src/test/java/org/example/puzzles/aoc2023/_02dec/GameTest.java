package org.example.puzzles.aoc2023._02dec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void isGamePossible() {
        Game game = new Game("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        System.out.println(game + " possibility: " + game.isGamePossible());
        assertTrue(game.isGamePossible());
    }

    @Test
    void isGamePossible_2() {
        Game game = new Game("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue");
        System.out.println(game + " possibility: " + game.isGamePossible());
        assertTrue(game.isGamePossible());
    }
    @Test
    void isGamePossible_3() {
        Game game = new Game("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");
        System.out.println(game + " possibility: " + game.isGamePossible());
        assertFalse(game.isGamePossible());
    }
    @Test
    void isGamePossible_4() {
        Game game = new Game("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red");
        System.out.println(game + " possibility: " + game.isGamePossible());
        assertFalse(game.isGamePossible());
    }
    @Test
    void isGamePossible_5() {
        Game game = new Game("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green");
        System.out.println(game + " possibility: " + game.isGamePossible());
        assertTrue(game.isGamePossible());
    }
}
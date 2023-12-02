package org.example.puzzles.aoc2023._02dec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameUtilsTest {

    GameUtils gameUtils;

    @BeforeEach
    void setUp(){
        gameUtils = new GameUtils();
    }

    @Test
    void getGameId() {
       assertEquals(1, gameUtils.getGameId("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
       assertEquals(2, gameUtils.getGameId("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"));
       assertEquals(89, gameUtils.getGameId("Game 89: 4 green, 2 blue, 6 red; 15 red, 7 green, 10 blue; 7 red, 9 blue, 4 green"));
       assertEquals(97, gameUtils.getGameId("Game 97: 10 red, 1 green, 1 blue; 4 green, 11 red, 2 blue; 4 red, 1 blue, 4 green"));
       assertEquals(51, gameUtils.getGameId("Game 51: 1 green, 2 red; 4 green; 1 blue, 10 green"));
    }

    @Test
    void getGameDescription() {
        String input = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        System.out.println(gameUtils.getGameDescription(input));
        assertEquals("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green", gameUtils.getGameDescription(input));
    }

    @Test
    void getRoundsPerGame() {
        String input = "3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        gameUtils.getRoundsPerGame(input).forEach(System.out::println);
        assertIterableEquals(List.of("3 blue, 4 red", "1 red, 2 green, 6 blue", "2 green"), gameUtils.getRoundsPerGame(input));
    }

    @Test
    void getRoundsPerGame_2() {
        String input = "1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue";
        gameUtils.getRoundsPerGame(input).forEach(System.out::println);
        assertIterableEquals(List.of("1 blue, 2 green", "3 green, 4 blue, 1 red", "1 green, 1 blue"), gameUtils.getRoundsPerGame(input));
    }
}
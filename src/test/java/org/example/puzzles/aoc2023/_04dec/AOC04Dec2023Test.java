package org.example.puzzles.aoc2023._04dec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AOC04Dec2023Test {

    AOC04Dec2023 aoc04Dec2023;

    @BeforeEach
    void setUp() {
        aoc04Dec2023 = new AOC04Dec2023();
    }

    @Test
    void initializeCard() {
        String cardLine = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        Card card = aoc04Dec2023.initializeCard(cardLine);
        System.out.println(card);
        //Result -> Card Id: '1' winning numbers as string: '41 48 83 86 17', playersNumbers: '83 86  6 31 17  9 48 53'
        //Winning numbers list as Integers: [41, 48, 83, 86, 17]
        //Players numbers list as Integers: [83, 86, 6, 31, 17, 9, 48, 53]
    }

    @Test
    void getWinningNumbersFromPlayer_retainAll() {
        List<Integer> playerNumbers = List.of(83, 86, 6, 31, 17, 9, 48, 53);
        List<Integer> winningNumbersOnCard = List.of(41, 48, 83, 86, 17);
        List<Integer> retainedNumbers = new ArrayList<>(playerNumbers);
        retainedNumbers.retainAll(winningNumbersOnCard);
        System.out.println(retainedNumbers);
        //Here we are finding out which winning numbers are being held by the player.
        //There is a list of winning numbers.
        //Then there is a player holding a few numbers, and we need to find which all winning numbers are in player's hand.

    }
}
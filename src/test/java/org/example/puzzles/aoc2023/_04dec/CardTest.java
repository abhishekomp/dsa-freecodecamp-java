package org.example.puzzles.aoc2023._04dec;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    @Test
    void getWorth() {
        int cardNumber = 1;
        List<Integer> winningNumbersOnCard = List.of(41, 48, 83, 86, 17);
        List<Integer> playerNumbers = List.of(83, 86, 6, 31, 17, 9, 48, 53);
        Card card = new Card(cardNumber, winningNumbersOnCard, playerNumbers);
        //System.out.println(card.winningNumbersWithPlayer());
        System.out.println(card.getWorthPoint());
        assertEquals(8.0, card.getWorthPoint());
    }
}
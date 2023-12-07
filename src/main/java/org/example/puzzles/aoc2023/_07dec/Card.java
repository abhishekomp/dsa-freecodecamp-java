package org.example.puzzles.aoc2023._07dec;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Card implements Comparable<Card>{
    private final char cardVal;
    public static final char[] POSSIBLE_CARD_VALUES = {'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2'};

    public Card(char cardVal) {
        this.cardVal = cardVal;
    }

    public char getCardVal() {
        return cardVal;
    }

    public static int compareTwoCards(Card cardOne, Card cardTwo){
        return cardOne.compareTo(cardTwo);
    }

    @Override
    public int compareTo(Card other) {
        int indexOfThisCardValue = IntStream.range(0, POSSIBLE_CARD_VALUES.length)
                .filter(i -> POSSIBLE_CARD_VALUES[i] == this.cardVal)
                .findFirst()
                .orElse(-1);
        int indexOfOtherCardValue = IntStream.range(0, POSSIBLE_CARD_VALUES.length)
                .filter(i -> POSSIBLE_CARD_VALUES[i] == other.cardVal)
                .findFirst()
                .orElse(-1);
        if(indexOfThisCardValue == indexOfOtherCardValue){
            return 0;
        }
        if(indexOfThisCardValue > indexOfOtherCardValue){
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardVal=" + cardVal +
                '}';
    }
}

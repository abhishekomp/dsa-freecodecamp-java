package org.example.puzzles.aoc2023._07dec;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void compareTo() {
        Card cardOne = new Card('A');
        Card cardTwo = new Card('K');
        System.out.println(cardOne.compareTo(cardTwo));
    }

    @Test
    void test_sort_two_cards(){
        Card cardOne = new Card('A');
        Card cardTwo = new Card('K');
        List<Card> cards = new ArrayList<>();
        cards.add(cardOne);
        cards.add(cardTwo);
        cards.forEach(System.out::println);
        cards.sort(Comparator.naturalOrder());
        cards.forEach(System.out::println);
    }

    @Test
    void test_sort_five_cards(){
        Card cardOne = new Card('Q');
        Card cardTwo = new Card('K');
        Card cardThree = new Card('5');
        Card cardFour = new Card('8');
        Card cardFive = new Card('2');
        List<Card> cards = new ArrayList<>();
        cards.add(cardOne);
        cards.add(cardTwo);
        cards.add(cardThree);
        cards.add(cardFour);
        cards.add(cardFive);
        cards.forEach(System.out::println);
        System.out.println("----------------");
        cards.sort(Comparator.naturalOrder());
        cards.forEach(System.out::println);
        List<Card> expectedCardsOrder = List.of(cardFive, cardThree, cardFour, cardOne, cardTwo);
        assertIterableEquals(expectedCardsOrder, cards);
    }

    @Test
    void test_sort_five_cards_2(){
        Card cardOne = new Card('A');
        Card cardTwo = new Card('K');
        Card cardThree = new Card('T');
        Card cardFour = new Card('Q');
        Card cardFive = new Card('5');
        List<Card> cards = new ArrayList<>();
        cards.add(cardOne);
        cards.add(cardTwo);
        cards.add(cardThree);
        cards.add(cardFour);
        cards.add(cardFive);
        cards.forEach(System.out::println);
        System.out.println("----------------");
        cards.sort(Comparator.naturalOrder());
        cards.forEach(System.out::println);
    }

        @Test
    void test_sort_five_cards_in_reverse_order(){
        Card cardOne = new Card('A');
        Card cardTwo = new Card('K');
        Card cardThree = new Card('T');
        Card cardFour = new Card('Q');
        Card cardFive = new Card('5');
        List<Card> cards = new ArrayList<>();
        cards.add(cardOne);
        cards.add(cardTwo);
        cards.add(cardThree);
        cards.add(cardFour);
        cards.add(cardFive);
        cards.forEach(System.out::println);
        System.out.println("----------------");
        cards.sort(Comparator.reverseOrder());
        cards.forEach(System.out::println);
        List<Card> expectedCardsOrder = List.of(cardOne, cardTwo, cardFour, cardThree, cardFive);
        assertIterableEquals(expectedCardsOrder, cards);
    }
}
package org.example.puzzles.aoc2023._07dec;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

//    @Test
//    void test_display_Hand_Not_Used() {
//        Hand handOne = new Hand("33332");
//        System.out.println(handOne);
//        Hand handTwo = new Hand("2AAAA");
//        System.out.println(handTwo);
//    }

    @Test
    void test_display_Hand() {
        Hand handOne = new Hand("32T3K 765");
        System.out.println(handOne);
        Hand handTwo = new Hand("KK677 28");
        System.out.println(handTwo);
    }

    @Test
    void test_compare_two_hands() {
        //Hand handOne = new Hand("33332");
        Hand handOne = new Hand("33332 765");
        System.out.println(handOne);
        //Hand handTwo = new Hand("2AAAA");
        Hand handTwo = new Hand("2AAAA 28");
        System.out.println(handTwo);
        int compareTo = handOne.compareTo(handTwo);
        System.out.println(compareTo);
        assertTrue(compareTo > 0);
    }

    @Test
    void test_compare_two_hands_2() {
        Hand handOne = new Hand("77888 888");
        System.out.println(handOne);
        Hand handTwo = new Hand("77788 998");
        System.out.println(handTwo);
        int compareTo = handOne.compareTo(handTwo);
        System.out.println(compareTo);
        assertTrue(compareTo > 0);
    }

    @Test
    void test_sort_sample_hands() {
        Hand handOne = new Hand("32T3K 765");
        Hand handTwo = new Hand("T55J5 684");
        Hand handThree = new Hand("KK677 28");
        Hand handFour = new Hand("KTJJT 220");
        Hand handFive = new Hand("QQQJA 483");
        List<Hand> hands = new ArrayList<>(List.of(handOne, handTwo, handThree, handFour, handFive));
        hands.forEach(System.out::println);
        System.out.println("After sorting");
        hands.sort(Comparator.naturalOrder());
        hands.forEach(System.out::println);
    }

    @Test
    void test_compare_two_hands_3() {
        Hand handOne = new Hand("32T3K 765");
        Hand handTwo = new Hand("T55J5 684");
        System.out.println(handOne.compareTo(handTwo));
    }

    @Test
    void test_compare_two_hands_4() {
        Hand handOne = new Hand("KK677 28");
        Hand handTwo = new Hand("KTJJT 220");
        System.out.println(handOne.compareTo(handTwo));
    }


}
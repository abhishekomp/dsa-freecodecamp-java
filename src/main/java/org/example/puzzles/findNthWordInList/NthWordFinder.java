package org.example.puzzles.findNthWordInList;

import java.util.Arrays;

/*
Starting with an input string of words, find the second-to-last word of the string. For example, an input of “I love Codecademy” should return “love.”

To make your program more challenging, allow for a second numerical input, n, that results in returning the nth word of a string. So, for the string “I can program in Java” and n = 3, the output should be the third word, “program.”
 */

public class NthWordFinder {
    public String getNthWord(String input, int wordNumber){
        return Arrays.stream(input.split("\\s+"))
                .skip(wordNumber - 1)
                .findFirst()
                .orElse("");
    }

    public String getLastButOneWord(String input) {
        int length = input.split("\\s+").length;
        return getNthWord(input, length - 1);
    }

    public static void main(String[] args) {
        NthWordFinder nthWordFinder = new NthWordFinder();
        String input = "What a sunny day!";
        //String input = "Hello";
        System.out.println(nthWordFinder.getNthWord(input, 1));
        System.out.println(nthWordFinder.getLastButOneWord(input));
    }
}

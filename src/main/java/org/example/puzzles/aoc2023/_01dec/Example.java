package org.example.puzzles.aoc2023._01dec;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Match overlapping sequence
https://www.youtube.com/watch?v=V256QdRgChU
 */
public class Example {
    public static void main(String[] args) {
        final String regex = "(?=(20*2))";
        final String string = "20020002";

        //final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));

            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}


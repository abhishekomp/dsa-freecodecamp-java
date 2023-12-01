package org.example.puzzles.aoc2023._01dec;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitFinder {
    public String getFirstDigitAsString(String input){
        String group = "";
        Pattern pattern = Pattern.compile("(one|two|three|four|five|six|seven|eight|nine|\\d)");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            group = matcher.group(1);
            if(!group.isEmpty()){
                return group;
            }
            //System.out.println(group);
        }
        return group;
    }

    public String getLastDigitAsString_buggy(String input){
        String group = "";
        Pattern pattern = Pattern.compile("(one|two|three|four|five|six|seven|eight|nine|\\d)"); //there is a bug in this pattern which gets "one" but not "eight" from "6oneightskl" due to overlapping of matches.
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            group = matcher.group(1);
            //System.out.println(group);
        }
        //System.out.println("Last match: " + group);
        return group;
    }

    /*
    This is a special case of matching the last digit in a given string.
    For example: in the string "6oneightskl" the last digit is eight (not one) but the method "getLastDigitAsString" will return "one" as the last digit.
    This method is an improvement in order to find the last digit in the string.
    This is the case of overlapping matches.
    WIP
     */
    public String getLastDigitAsString(String input) {
        //input = "6oneightskl";  //one, eight
        String group = "";
        Pattern pattern = Pattern.compile("(?=(one|two|three|four|five|six|seven|eight|nine|\\d))");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            //System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                //System.out.println("Group " + i + ": " + matcher.group(i));
                group = matcher.group(i);
            }
        }
        return group;
    }

    public int getNumberFromLine(String line){
        String firstDigitAsString = getFirstDigitAsString(line);
        int firstStringAsInteger = getStringAsInteger(firstDigitAsString);
        String lastDigitAsString = getLastDigitAsString(line);
        int lastStringAsInteger = getStringAsInteger(lastDigitAsString);
        String numberAsStr = "" + firstStringAsInteger + lastStringAsInteger;
        return Integer.parseInt(numberAsStr);
    }

    public int getStringAsInteger(String str) {
        int digit = 0;
        if(str.isEmpty()){
            return digit;
        }
        Map<String, Integer> stringDigitMap = new HashMap<>();
        stringDigitMap.put("one", 1);
        stringDigitMap.put("two", 2);
        stringDigitMap.put("three", 3);
        stringDigitMap.put("four", 4);
        stringDigitMap.put("five", 5);
        stringDigitMap.put("six", 6);
        stringDigitMap.put("seven", 7);
        stringDigitMap.put("eight", 8);
        stringDigitMap.put("nine", 9);
        stringDigitMap.put("1", 1);
        stringDigitMap.put("2", 2);
        stringDigitMap.put("3", 3);
        stringDigitMap.put("4", 4);
        stringDigitMap.put("5", 5);
        stringDigitMap.put("6", 6);
        stringDigitMap.put("7", 7);
        stringDigitMap.put("8", 8);
        stringDigitMap.put("9", 9);
        return stringDigitMap.entrySet().stream()
                .filter(entry -> entry.getKey().equals(str))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(0);
        //String[] DIGITS = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//        return Arrays.stream(DIGITS)
//                .filter(digitStr -> digitStr.equals(str))
//                .findFirst()
//                .map(Integer::parseInt)
//                .orElse(0);
    }

    public static void main(String[] args) {
        String input = "eightwothree";
        DigitFinder digitFinder = new DigitFinder();
        System.out.println(digitFinder.getFirstDigitAsString(input));
    }
}

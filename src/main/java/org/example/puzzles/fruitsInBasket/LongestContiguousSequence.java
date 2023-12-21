package org.example.puzzles.fruitsInBasket;

import java.util.*;
import java.util.stream.Collectors;

public class LongestContiguousSequence {
    public int[] extractLongestContiguousSeq(int[] inputArr){
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        int leftIndex = -1;
        int rightIndex;
        List<Integer> sequence = new LinkedList<>();
        for(rightIndex = 0; rightIndex < inputArr.length; rightIndex++){
            Integer orDefault = elementCountMap.getOrDefault(inputArr[rightIndex], 0);
            elementCountMap.put(inputArr[rightIndex], orDefault + 1);
            sequence.add(inputArr[rightIndex]);

            while(elementCountMap.size() > 2){
                leftIndex++;
                int updatedValue = elementCountMap.get(inputArr[leftIndex]) - 1;
                if(updatedValue == 0){
                    elementCountMap.remove(inputArr[leftIndex]);
                } else {
                    elementCountMap.put(inputArr[leftIndex], updatedValue);
                }
                sequence.remove(0);
            }
        }
        //Integer[] integers = sequence.toArray(Integer[]::new);
        int[] ints = sequence.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
        return ints;
        //sum = elementCountMap.values().stream().mapToInt(i -> i).sum();
    }

    public String extractLongestContiguousStringWith2DistinctCharacter(String input){
        char[] inputArr = input.toCharArray();
        Map<Character, Integer> elementCountMap = new HashMap<>();
        int leftIndex = -1;
        int rightIndex;
        List<Character> sequence = new LinkedList<>();
        for(rightIndex = 0; rightIndex < inputArr.length; rightIndex++){
            Integer orDefault = elementCountMap.getOrDefault(inputArr[rightIndex], 0);
            elementCountMap.put(inputArr[rightIndex], orDefault + 1);
            sequence.add(inputArr[rightIndex]);

            // 2 distinct character is hard coded here.
            while(elementCountMap.size() > 2){
                leftIndex++;
                int updatedValue = elementCountMap.get(inputArr[leftIndex]) - 1;
                if(updatedValue == 0){
                    elementCountMap.remove(inputArr[leftIndex]);
                } else {
                    elementCountMap.put(inputArr[leftIndex], updatedValue);
                }
                sequence.remove(0);
            }
        }
        //Integer[] integers = sequence.toArray(Integer[]::new);
        //String result = sequence.stream().filter(Objects::nonNull).toString();
        String result = sequence.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        return result;
    }

    /**
     * Returns the longest contiguous sub string with exactly N distinct characters in the sub string
     * @param input string
     * @param numOfChars number of distinct character needed
     * @return sub string having exactly N number of distinct characters. (Fruit in basket puzzle)
     */
    public String extractLongestContiguousStringWithNDistinctCharacter(String input, int numOfChars){
        char[] inputArr = input.toCharArray();
        Map<Character, Integer> elementCountMap = new HashMap<>();
        int leftIndex = 0;
        List<Character> sequence = new LinkedList<>();  //char collector
        List<String> listOfStrings = new ArrayList<>();
        for (int rightIndex = 0; rightIndex < inputArr.length; rightIndex++) {
            char currentChar = inputArr[rightIndex];
            // Check if we can add this char to any of the baskets.
            Integer charCount = elementCountMap.getOrDefault(currentChar, 0);
            // Case: when we cannot add this char to one of the baskets.
            if (charCount == 0 && elementCountMap.size() == numOfChars) {
                //this 2 is your numOfChars method argument. we will remove the hardcoding later.
                //save the current sequence as a string
                listOfStrings.add((sequence.stream().map(String::valueOf).collect(Collectors.joining())));
                while (elementCountMap.size() == numOfChars) {
                    int updatedValue = elementCountMap.get(inputArr[leftIndex]) - 1;
                    if (updatedValue == 0) {
                        elementCountMap.remove(inputArr[leftIndex]);
                    } else {
                        elementCountMap.put(inputArr[leftIndex], updatedValue);
                    }
                    sequence.remove(0);
                    leftIndex++;
                }
            }
            elementCountMap.put(currentChar, charCount + 1);
            sequence.add(currentChar);
            if(rightIndex == inputArr.length - 1){
                listOfStrings.add(sequence.stream().map(String::valueOf).collect(Collectors.joining()));
            }
        }
        //Integer[] integers = sequence.toArray(Integer[]::new);
        //String result = sequence.stream().filter(Objects::nonNull).toString();
        //listOfStrings.forEach(System.out::println);
        return listOfStrings.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList()).get(0);
        //System.out.println(collect.get(0));
    }
}

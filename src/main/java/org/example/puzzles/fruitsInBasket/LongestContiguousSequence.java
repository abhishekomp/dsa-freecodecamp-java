package org.example.puzzles.fruitsInBasket;

import java.util.*;

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
}

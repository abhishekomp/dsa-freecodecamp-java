package org.example.puzzles;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

/**
 * @author  : Abhishek
 * @since   : 2024-01-18, Thursday
 * LeetCode 347: <a href="https://leetcode.com/problems/top-k-frequent-elements/description/">TopKFrequentElements347</a>
 **/
public class TopKFrequentElements {

    public int[] topKFrequentElements(int[] input, int frequency){
        // Creating a map from a primitive array
        // Creating frequency map from primitive array
        Map<Long, List<Integer>> frequencyIntegerListMap = Arrays.stream(input).boxed()
                .collect(collectingAndThen(groupingBy(Function.identity(), counting()),
                        m -> m.entrySet().stream().collect(groupingBy(Map.Entry::getValue, mapping(Map.Entry::getKey, toList())))));

        Map<Integer, Long> integerLongMap = Arrays.stream(input).boxed()
                .collect(groupingBy(Function.identity(), counting()));
        //integerLongMap.forEach((k, v) -> System.out.println(k + "->" + v));
        //System.out.println("Frequency as key and list of integers with frequency as value");
        //frequencyIntegerListMap.forEach((k, v) -> System.out.println(k + "->" + v));

        //frequencyIntegerListMap.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey).reversed());
        // Frequency of the element as the key and the list of elements for that frequency as the value
        LinkedHashMap<Long, List<Integer>> collect = frequencyIntegerListMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
        //collect.forEach((k, v) -> System.out.println(k + "->" + v));


        int frequencyCount = 0;
        List<Integer> result = new ArrayList<>();
        Iterator<Map.Entry<Long, List<Integer>>> iterator = collect.entrySet().iterator();

        while(iterator.hasNext() && frequencyCount < frequency){
            result.addAll(iterator.next().getValue());
            frequencyCount++;
            //System.out.println("Result list: " + result);
        }
        //Convert List of Integer to primitive integer array
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] input = {1, 1, 1, 1, 2, 2, 3, 3, 4};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] topKIntegers = topKFrequentElements.topKFrequentElements(input, 2);
        System.out.println(Arrays.toString(topKIntegers));
    }

}

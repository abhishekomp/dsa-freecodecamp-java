package org.example.puzzles.temp_nearest_to_zero;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class TempNearestToZeroFinder {

    public int findTempNearestToZero(int[] tempArr){
        int closestTo = 0;
        return findTempNearestToZero(tempArr, closestTo);
    }

    public int findTempNearestToZero(int[] tempArr, int closestTo){
        int result = 0;
        //Stream<Integer> integerStream = Arrays.stream(tempArr).mapToObj(i -> i);

//        Map<Integer, Integer> collect = Arrays.stream(tempArr).boxed()
//                .collect(toMap(temp -> temp, temp -> temp * 2));
//        Map<Integer, Integer> collect = Arrays.stream(tempArr).boxed()
//                .collect(toMap(Function.identity(), temp -> Math.abs(closestTo - temp)));

        Map<Integer, Integer> collect = Arrays.stream(tempArr).boxed()
                .collect(toMap(Function.identity(), temp -> Math.abs(closestTo - temp)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

        //collect.forEach((k, v) -> System.out.println(k + "->" + v));
        Map.Entry<Integer, Integer> resultEntry = collect.entrySet().stream().findFirst().orElse(new AbstractMap.SimpleEntry<>(0, 0));
        return resultEntry.getKey();
    }

    public static <T extends Number> double findTempNearestToZeroGeneric(T[] tempArr, int closestTo){
        LinkedHashMap<Double, Double> collect = Arrays.stream(tempArr)
                .map(Object::toString)
                .map(Double::parseDouble)
                .collect(toMap(Function.identity(), temp -> Math.abs(closestTo - temp)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

        //collect.forEach((k, v) -> System.out.println(k + "->" + v));
        Map.Entry<Double, Double> resultEntry = collect.entrySet().stream().findFirst().orElse(new AbstractMap.SimpleEntry<>(0.0, 0.0));
        return resultEntry.getKey();
    }

    public static void main(String[] args) {
        TempNearestToZeroFinder main = new TempNearestToZeroFinder();
        //int[] tempArr = {-5, -2, 1, 5};
        int[] tempArr = {-5, -1, 2, 5};
        int tempNearestToZero = main.findTempNearestToZero(tempArr, 0);
        System.out.println("tempNearestToZero = " + tempNearestToZero);
    }

}

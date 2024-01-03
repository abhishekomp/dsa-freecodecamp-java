package org.example.puzzles.repeatedSubArray;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RepeatedSubArray {
    public int lengthOfLongestCommonSubArray(int[] arrOne, int[] arrTwo){
        List<Integer> listOne = Arrays.stream(arrOne).boxed().collect(toList());
        List<Integer> listTwo = Arrays.stream(arrTwo).boxed().collect(toList());
        System.out.println(listOne);
        System.out.println("After retainAll");
        boolean b = listOne.retainAll(listTwo);
        System.out.println(listOne);
        System.out.println(listTwo);

        return -1;
    }

}

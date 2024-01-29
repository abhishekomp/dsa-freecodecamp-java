package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  : Abhishek
 * @since   : 2024-01-29, Monday
 **/
public class ArrayPuzzleSolver {
    /**
     * Finds the sub-array with specified sum
     * @param input input array of integers
     * @param sum specified sum
     */
    public String subArrayWithGivenSum(int[] input, int sum){
        int start = 0;
        int end = -1;
        int currentSum = 0;
        String resultString = "";
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        for(int i = 0; i < input.length; i++){
            currentSum += input[i];
            if(currentSum == sum){
                end = i;
                break;
            }
            if(sumIndexMap.containsKey(currentSum - sum)){
                start = sumIndexMap.get(currentSum - sum) + 1;
                end = i;
                break;
            }
            sumIndexMap.put(currentSum, i);
        }
        if(end == -1){
            //System.out.println("Not found");
            resultString = "Not found";
        } else {
            //System.out.println("Sub-Array found with start index: " + start + " end: " + end);
            resultString = "Sub-Array found with start index: " + start + " end: " + end;
        }
        return resultString;
    }

    public static void main(String[] args) {
        int[] input = {10, 15, -5, 30, 10};
        int expectedSum = 20;
        ArrayPuzzleSolver arrayPuzzleSolver = new ArrayPuzzleSolver();
        System.out.println(arrayPuzzleSolver.subArrayWithGivenSum(input, expectedSum));
    }
}

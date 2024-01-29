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

    /**
     * Sum of all sub-arrays of given length. Using Sliding window algorithm
     * @param input input array
     * @param length given length of the sub-array
     * @return the sum of all the sub-arrays of given length
     * @since 29-Jan-2024
     */
    public int sumOfAllSubArraysOfGivenLength(int[] input, int length){
        int totalSum = 0;
        int left = 0;
        int right = 0;
        //calculate the sum of the 1st sub-array of 3 elements
        for(int i = 0; i < length; i++){
            totalSum += input[i];
            right = i;
        }
        //System.out.println("Initial sub-array sum: " + totalSum);
        right = right + 1;
        while(right < input.length){
            int currentSum = totalSum - input[left] + input[right];
            //System.out.println("Temp Sum: " + currentSum);
            totalSum += currentSum;
            //System.out.println("Total Sum: " + totalSum);
            left++;
            right++;
        }
        return totalSum;
    }


    public int shortestSubArrayWithGivenSum(int[] input, int expectedSum) {
        int start = 0;
        int end = -1;
        int currentSum = 0;
        String resultString = "";
        int arrLen = Integer.MAX_VALUE;
        int currentLength = 0;
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        for(int i = 0; i < input.length; i++){
            currentSum += input[i];
            if(currentSum == expectedSum){
                end = i;
                arrLen = -999;
            }
            if(sumIndexMap.containsKey(currentSum - expectedSum)){
                start = sumIndexMap.get(currentSum - expectedSum) + 1;
                end = i;
                break;
            }
            sumIndexMap.put(currentSum, i);
        }
        if(end == -1){
            System.out.println("Not found");
            //resultString = "Not found";
        } else {
            System.out.println("Sub-Array found with length: " + arrLen);
            //resultString = "Sub-Array found with length: " + arrLen;
        }
        return arrLen;
    }
}

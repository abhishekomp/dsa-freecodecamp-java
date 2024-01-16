package org.example.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author  : Abhishek
 * @since   : 2024-01-15, Monday
 **/
public class QuickSort {

    public void quickSort(int[] inputArr, int lowIndex, int highIndex){
//        System.out.println(Arrays.stream(inputArr).boxed().collect(Collectors.toList()) +
//                " lowIndex= " + lowIndex + " highIndex= " + highIndex);
        if(lowIndex >= highIndex){
            return;
        }

        //Choose the pivot element
        int pivot = inputArr[highIndex];

        // Partitioning (Move all the numbers lower than pivot to the left of the pivot
        // and all numbers greater than the pivot to the right of the pivot).
        int leftPointer = partition(inputArr, lowIndex, highIndex, pivot);

        // recursive sorting of left and right segment
        quickSort(inputArr, lowIndex, leftPointer - 1);
        quickSort(inputArr, leftPointer + 1, highIndex);
    }

    private int partition(int[] inputArr, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while(leftPointer < rightPointer){
            while(inputArr[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while(inputArr[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            if(leftPointer != rightPointer) {
                swap(inputArr, leftPointer, rightPointer);
            }
        }
        if(inputArr[leftPointer] > inputArr[highIndex]){
            swap(inputArr, leftPointer, highIndex);
        } else {
            leftPointer = highIndex;    // was required for this kind of input: [28, 10, 61, 32, 8, 24, 38, 56, 34, 78]. Remove this condition and see the incorrect result.
        }
        return leftPointer;
    }

    private void swap(int[] inputArr, int leftPointer, int rightPointer) {
        int temp = inputArr[rightPointer];
        inputArr[rightPointer] = inputArr[leftPointer];
        inputArr[leftPointer] = temp;
    }

    public static void main(String[] args) {
        // Create an array of random primitive integers
        // Array of random integers
        Random random = new Random();
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(100);   // integer between 0 and 99 (inclusive)
        }

        //int[] arr = {6, 8, 7};
        //int[] arr = {6, 7, 8};
        //int[] arr = {6};
        //int[] arr = {8, 7};
        //int[] arr = {7, 8};
        //int[] arr = {6, 10, 7, 9};
        //int[] arr = {6, 7, 8, 9};
        //int[] arr = {6, 9, 7, 8};
        //int[] arr = {9, 6, 7, 8};
        //int[] arr = {6, 7, 9, 8};
        //int[] arr = {11, 7, 8, 9, 10};
        //int[] arr = {7, 11, 8, 9, 10};
        //int[] arr = {11, 8, 7, 9, 2};  //Left pointer found a bigger number than the pivot but right pointer did not find any number smaller than the pivot.
        //int[] arr = {6, 8, 9, 10};
        //int[] arr = {28, 10, 61, 32, 8, 24, 38, 56, 34, 78};    // is giving [8, 10, 24, 32, 28, 38, 56, 61, 34, 78] which is incorrect. Fixed by marking leftPointer = highIndex

        System.out.println("Before");
        System.out.println(Arrays.toString(arr));

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);

        System.out.println("After");
        System.out.println(Arrays.toString(arr));
    }


}

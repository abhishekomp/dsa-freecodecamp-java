package org.example.puzzles.nextgreaterelement;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author  : Abhishek
 * @since   : 2024-01-29, Monday
 **/
public class NextGreaterToRight {
    /**
     * Finds element greater than the current element to the right side of the array.
     * If there is no element in the right which is greater than the current element then output -1
     * @param input the input array
     * @return the result array containing element greater than the current element.
     */
    public int[] nextGreaterToRight(int[] input){
        //[10, 40, 30, 20, 50]
        int[] resultArray = new int[input.length];
        Stack<Integer> helperStack = new Stack<>();
        for(int i = input.length - 1; i >= 0; i--){
            int currentElement = input[i];
            if(helperStack.empty()){
                resultArray[i] = -1;
                helperStack.push(currentElement);
                continue;
            }
            while(!helperStack.isEmpty() && helperStack.peek() <= currentElement){
                helperStack.pop();
            }
            if(helperStack.empty()){
                resultArray[i] = -1;
            } else {
                resultArray[i] = helperStack.peek();
            }
            helperStack.push(currentElement);
        }
        return resultArray;
    }

    /**
     * Finds element smaller than the current element to the right side of the array.
     * If there is no element in the right which is smaller than the current element then output -1
     * @param input the input array
     * @return the result array containing element smaller than the current element.
     */
    public int[] nextSmallerToRight(int[] input){
        //[10, 40, 30, 20, 50]
        //[-1, 30, 20, -1, -1]
        int[] resultArray = new int[input.length];
        Stack<Integer> helperStack = new Stack<>();
        for(int i = input.length - 1; i >= 0; i--){
            int currentElement = input[i];
            if(helperStack.empty()){
                resultArray[i] = -1;
                helperStack.push(currentElement);
                continue;
            }
            while(!helperStack.isEmpty() && helperStack.peek() >= currentElement){
                helperStack.pop();
            }
            if(helperStack.empty()){
                resultArray[i] = -1;
            } else {
                resultArray[i] = helperStack.peek();
            }
            helperStack.push(currentElement);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] input = {10, 40, 30, 20, 50};
        NextGreaterToRight nextGreaterToRight = new NextGreaterToRight();
        int[] greaterToRight = nextGreaterToRight.nextGreaterToRight(input);
        System.out.println("Next Greater Element");
        System.out.println(Arrays.toString(input));             // [10, 40, 30, 20, 50]
        System.out.println(Arrays.toString(greaterToRight));    // [40, 50, 50, 50, -1]
        int[] smallerToRight = nextGreaterToRight.nextSmallerToRight(input);
        System.out.println("Next Smaller Element");
        System.out.println(Arrays.toString(input));             // [10, 40, 30, 20, 50]
        System.out.println(Arrays.toString(smallerToRight));    // [-1, 30, 20, -1, -1]
    }
}

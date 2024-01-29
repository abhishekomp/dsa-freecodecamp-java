package org.example.puzzles.nextgreaterelement;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author  : Abhishek
 * @since   : 2024-01-29, Monday
 **/
public class NextGreaterToLeft {
    /**
     * Finds all the previous greater number for every number in the array.
     * If there is no number to the left greater than the current number output -1.
     * @param input the input array
     * @return the array containing previous greater element
     */
    public int[] nextGreaterToLeft(int[] input){
        int[] resultArray = new int[input.length];
        Stack<Integer> helperStack = new Stack<>();
        for(int i = 0; i < input.length; i++){
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

    public static void main(String[] args) {
        int[] input = {10, 40, 30, 20, 50};
        NextGreaterToLeft nextGreaterToLeft = new NextGreaterToLeft();
        int[] resultArray = nextGreaterToLeft.nextGreaterToLeft(input);
        System.out.println("Next Greater Element towards Left");
        System.out.println(Arrays.toString(input));         // [10, 40, 30, 20, 50]
        System.out.println(Arrays.toString(resultArray));   // [-1, -1, 40, 30, -1]
    }
}

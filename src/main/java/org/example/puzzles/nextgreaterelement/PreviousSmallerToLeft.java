package org.example.puzzles.nextgreaterelement;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author  : Abhishek
 * @since   : 2024-01-29, Monday
 **/
public class PreviousSmallerToLeft {
    /**
     * Finds all the previous smaller number for every number in the array.
     * If there is no number to the left smaller than the current number output -1.
     * @param input the input array
     * @return the array containing previous smaller element
     */
    public int[] previousSmallerToLeft(int[] input){
        int[] resultArray = new int[input.length];
        Stack<Integer> helperStack = new Stack<>();
        for(int i = 0; i < input.length; i++){
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
        int[] input = {20, 40, 10, 30, 60, 50};
        PreviousSmallerToLeft previousSmallerToLeft = new PreviousSmallerToLeft();
        int[] resultArray = previousSmallerToLeft.previousSmallerToLeft(input);
        System.out.println("Previous smaller element (to left)");
        System.out.println(Arrays.toString(input));         // [20, 40, 10, 30, 60, 50]
        System.out.println(Arrays.toString(resultArray));   // [-1, 20, -1, 10, 30, 30]
    }
}

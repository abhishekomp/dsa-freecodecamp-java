package org.example.puzzles.nextgreaterelement;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * @author  : Abhishek
 * @since   : 2024-01-26, Friday
 **/
public class NextGreaterElement {

    public int[] nextGreaterElements(int[] nums1, int[] nums2){
        // Evaluate the next greater elements for the given array
        int[] nextGreaterElements = nextGreaterElements(nums2);
        int[] resultArr = new int[nums1.length];
        int[] indexArray = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            int finalI = i;
            int asInt = IntStream.range(0, nums2.length)
                    .filter(index -> nums2[index] == nums1[finalI])
                    .findFirst()
                    .getAsInt();
            indexArray[i] = asInt;
        }
        for(int i = 0; i < indexArray.length; i++){
            resultArr[i] = nextGreaterElements[indexArray[i]];
        }
        //System.arraycopy(nextGreaterElements, 0, resultArr, 0, indexArray.length);
        return resultArr;
    }

    /**
     * This gives the next greater element for the given array of integers.
     * @param ints the input array
     * @return array containing the next greater elements
     */
    public int[] nextGreaterElements(int[] ints){
        int[] nextGreaterElements = new int[ints.length];
        Stack<Integer> helperStack = new Stack<>();
        for(int i = ints.length - 1; i >= 0; i--){
            int currentElement = ints[i];
            if(helperStack.isEmpty()){
                nextGreaterElements[i] = -1;
                helperStack.push(currentElement);
                continue;
            }
            if(helperStack.peek() > ints[i]){
                nextGreaterElements[i] = helperStack.peek();
                helperStack.push(ints[i]);
                continue;
            }
            while(!helperStack.isEmpty() && helperStack.peek() <= currentElement){
                helperStack.pop();
            }
            if(helperStack.empty()){
                nextGreaterElements[i] = -1;
            } else {
                nextGreaterElements[i] = helperStack.peek();
            }
            helperStack.push(currentElement);
        }
        return nextGreaterElements;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] nextGreaterElements = nextGreaterElement.nextGreaterElements(nums1, nums2);
        System.out.println(Arrays.toString(nextGreaterElements));
    }
}

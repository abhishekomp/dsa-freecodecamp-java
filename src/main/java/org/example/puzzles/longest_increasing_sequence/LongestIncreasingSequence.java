package org.example.puzzles.longest_increasing_sequence;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 * LeetCode 300
 */
public class LongestIncreasingSequence {
    public int longestIncreasingSequenceLength(int[] input){
        // Initialize an array to store the memoized length of the longest increasing sequence at each index
        int[] memoizedArr = new int[input.length];
        Arrays.fill(memoizedArr, 1);

        // To do: Handle the situation when the given array has 1 element in it.
        if(input.length == 1) {
            return 1;
        }

        // When given array has more than 2 elements.
        // Initialize 2 pointers to perform memoization
        for(int i = 1; i < input.length; i++){
            int j = 0;
            while(j < i){
                if(input[i] > input[j]){
                    if(memoizedArr[i] <= memoizedArr[j]){
                        memoizedArr[i] = memoizedArr[j] + 1;
                    }
                }
                j++;
            }
        }
//        return Arrays.stream(memoizedArr)
//                .max()
//                .getAsInt();
        Arrays.sort(memoizedArr);
        return memoizedArr[memoizedArr.length - 1];
    }
}

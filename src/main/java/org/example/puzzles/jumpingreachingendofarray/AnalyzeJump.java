package org.example.puzzles.jumpingreachingendofarray;

public class AnalyzeJump {

    /**
     * https://leetcode.com/problems/jump-game/description/
     * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
     * Return true if you can reach the last index, or false otherwise.
     * @param input input array
     * @return true if it is possible to reach the end of the array otherwise false.
     */
    public boolean canReachTheEnd_old(int[] input){
        int standingAt = input.length - 1;
        int preIndex = standingAt - 1;
        while(standingAt != 0){
            if(preIndex + input[preIndex] >= standingAt){
                standingAt = preIndex;
            }
            preIndex = preIndex - 1;
            if(preIndex == -1){
                break;
            }
        }
        return standingAt == 0;
    }

    /**
     * This is a modified version of the previously implemented method. (see above for the method "canReachTheEnd_old")
     * @param input input array
     * @return true if it is possible to reach the end of the array otherwise false.
     */
    public boolean canReachTheEnd(int[] input){
        int standingAt = input.length - 1;
        int preIndex = standingAt - 1;
        while(preIndex != -1){
            if(preIndex + input[preIndex] >= standingAt){
                standingAt = preIndex;
            }
            preIndex = preIndex - 1;
        }
        return standingAt == 0;
    }

    /**
     * https://leetcode.com/problems/jump-game-ii/description/
     * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
     * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
     * 0 <= j <= nums[i] and
     * i + j < n
     * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
     * It is guaranteed that you will reach the end of the array.
     * @return
     */
    public int minimumStepsToReachTheEnd(int[] inputArr){
        int totalJumps = 0;
        int destination = inputArr.length - 1;
        int coverage = 0;   //max I can reach from my current window of available indices.
        int windowLastIndex = 0;    // the last index of my current available window because I need to analyze each index of my current window to find my coverage.

        //Base case
        if(inputArr.length == 1){
            return 0;
        }

        for(int i = 0; i < inputArr.length; i++){
            coverage = Math.max(coverage, i + inputArr[i]);

            // window of indices to analyze
            if(i == windowLastIndex){
                windowLastIndex = coverage;
                totalJumps++;

                // while I am at the edge of the current window, check if my coverage took me to the destination or beyond
                if(coverage >= destination){
                    break;
                }
            }
        }
        return totalJumps;
    }

    public int returnInt(){
        return 1;
    }

}

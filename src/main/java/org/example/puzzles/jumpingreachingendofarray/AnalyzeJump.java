package org.example.puzzles.jumpingreachingendofarray;

public class AnalyzeJump {

    /**
     * https://leetcode.com/problems/jump-game/description/
     * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
     * Return true if you can reach the last index, or false otherwise.
     * @param input input array
     * @return true if it possible to reach the end of the array.
     */
    public boolean canReachTheEnd(int[] input){
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

    public int returnInt(){
        return 1;
    }

}

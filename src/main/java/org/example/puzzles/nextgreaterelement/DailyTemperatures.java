package org.example.puzzles.nextgreaterelement;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/description/
 * Problem: 739
 * @author  : Abhishek
 * @since   : 2024-01-26, Friday
 **/
public class DailyTemperatures {
    public int[] nextHigherTemperatureAfterNumberOfDays(int[] temperatures){
        //{20, 30, 40, 50}
        Stack<Integer> helperStack = new Stack<>();
        int[] resultArr = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 0; i--){
            int element = temperatures[i];
            if(helperStack.empty()){
                resultArr[i] = 0;
                helperStack.push(i);
                continue;
            }
            if(temperatures[helperStack.peek()] > element){
                resultArr[i] = helperStack.peek() - i;
                helperStack.push(i);
                continue;
            }
            while(!helperStack.empty() && temperatures[helperStack.peek()] <= element){
                helperStack.pop();
            }
            if(helperStack.isEmpty()){
                resultArr[i] = 0;
            } else {
                resultArr[i] = helperStack.peek() - i;
            }
            helperStack.push(i);
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int[] temperatures = {20, 30, 40, 50};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] nextHigherTemperatureAfterNumberOfDays = dailyTemperatures.nextHigherTemperatureAfterNumberOfDays(temperatures);
        System.out.println(Arrays.toString(nextHigherTemperatureAfterNumberOfDays));
    }
}

package org.example.puzzles;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  : Abhishek
 * @since   : 2024-01-23, Tuesday
 **/
public class FibonacciSeries {

    static Map<Integer, Long> fibMap = new HashMap<>();
    public int getNthFibonacciNumber(int nth){
        if(nth <= 2){
            return 1;
        }
        return getNthFibonacciNumber(nth - 1) + getNthFibonacciNumber(nth - 2);
    }

    public long getNthFibonacciNumberEfficient(int nth){
        //Map<Integer, Long> fibMap = new HashMap<>();
        //System.out.println("getNthFibonacciNumberEfficient invoked for for evaluating " + nth + " fibonacci number");
        long result;
        result = fibMap.getOrDefault(nth, 0L);
        if(result > 0L){
            //System.out.println("Found result for " + nth + " value in the map.");
            return result;
        }
        if(nth <= 2){
            result = 1L;
            return result;
        }

        result = getNthFibonacciNumberEfficient(nth - 2) + getNthFibonacciNumberEfficient(nth - 1);
        fibMap.put(nth, result);
        return result;
    }

    public long getNthFibonacciNumberEfficientBottomUpApproach(int nth){
        Map<Integer, Long> fibMap = new HashMap<>();
        fibMap.put(1, 1L);
        fibMap.put(2, 1L);
        for(int i = 3; i <= nth; i++){
            long result = fibMap.get(i - 1) + fibMap.get(i - 2);
            fibMap.put(i, result);
        }
        return fibMap.get(nth);
    }

    public static void main(String[] args) {
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        //System.out.println(fibonacciSeries.getNthFibonacciNumber(50));
        //System.out.println(fibonacciSeries.getNthFibonacciNumberEfficient(60));
        //System.out.println(fibonacciSeries.getNthFibonacciNumberEfficientBottomUpApproach(50));   //12586269025
        System.out.println(fibonacciSeries.getNthFibonacciNumberEfficientBottomUpApproach(60));     //1548008755920
        //System.out.println(fibonacciSeries.getNthFibonacciNumberEfficientBottomUpApproach(80));   //23416728348467685
    }
}

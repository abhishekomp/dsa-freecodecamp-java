package org.example.puzzles.aoc2023._05dec;

public class ClientProgram {

    public static void main(String[] args) {
        //Client provides the input file (in this case almanac) and asks for the nearest location value.
        LocationCalculator locationCalculator = new LocationCalculator();
        long lowestLocation = locationCalculator.calculateLowestLocation("day5", "Day5Part1Input.txt");
        System.out.println(lowestLocation); //Part 1 Done: 226172555
    }
}

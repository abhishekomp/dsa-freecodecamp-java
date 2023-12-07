package org.example.puzzles.aoc2023._07dec;

import org.example.puzzles.aoc2023.utils.ReadTextFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

public class CamelCards {
    public double calculateWinnings(String dirName, String fileName){
        List<String> lines = readFile(dirName, fileName);
        //Using each line create a Hand
        ArrayList<Hand> sortedHands = lines.stream()
                .map(Hand::new)
                .sorted(Comparator.naturalOrder())
                .collect(toCollection(ArrayList::new));
        double winnings = 0.0;
        for(int i = 0; i < sortedHands.size(); i++){
            winnings = winnings + (sortedHands.get(i).getBidAmount() * (i + 1));
        }
        //System.out.println(winnings);
        return winnings;
    }

    private static List<String> readFile(String dirName, String fileName) {
        ReadTextFile readTextFile = new ReadTextFile();
        return readTextFile.readTextFileFromResources(dirName, fileName);
    }

    public static void main(String[] args) {
        CamelCards camelCards = new CamelCards();
        //System.out.println(camelCards.calculateWinnings("day7", "Day7Sample.txt"));
        System.out.println(camelCards.calculateWinnings("day7", "Day7Part1Input.txt")); //Done 252295678
    }
}

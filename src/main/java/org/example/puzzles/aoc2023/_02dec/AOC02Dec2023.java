package org.example.puzzles.aoc2023._02dec;

import org.example.puzzles.aoc2023.utils.ReadTextFile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class AOC02Dec2023 {
    /*
    Method that reads the input and creates a list of game sentences (each line in the input is a game sentence)
     */
    public List<String> readFile(String dirName, String fileName){
        ReadTextFile readTextFile = new ReadTextFile();
        return readTextFile.readTextFileFromResources(dirName, fileName);
    }

    public Map<Integer, Boolean> createGamePossibilityMap(String dirName, String fileName) {
        List<String> gameLines = readFile(dirName, fileName);
        Map<Integer, Boolean> idPossibilityMap = gameLines.stream()
                .collect(toMap(GameUtils::getGameId, (gameSentence -> new Game(gameSentence).isGamePossible())));
        return idPossibilityMap;
        //idPossibilityMap.forEach((k,v) -> System.out.println("Game Id: " + k + " possibility: " + v));
    }

    public Map<Integer, Double> createGamePowerMap(String dirName, String fileName) {
        List<String> gameLines = readFile(dirName, fileName);
        Map<Integer, Double> gameIdToPowerMap = gameLines.stream()
                .collect(toMap(GameUtils::getGameId, (gameSentence -> new Game(gameSentence).getMaxBallsAndPower())));
        gameIdToPowerMap.forEach((k,v) -> System.out.println("Game Id: " + k + " power: " + v));
        return gameIdToPowerMap;
    }

    //Ans: 2348
    public void day2part1Main() {
        Map<Integer, Boolean> gamePossibilityMap = createGamePossibilityMap("day2", "Day2Part1Input.txt");  //2348
        int sum = gamePossibilityMap.entrySet().stream()
                .filter(Map.Entry::getValue)
                .mapToInt(Map.Entry::getKey)
                .sum();
        System.out.println("sum = " + sum);
    }
    public void day2part2Main() {
        //Map<Integer, Double> gameIdToPowerMap = createGamePowerMap("day2", "Day2Sample.txt");   //2286
        Map<Integer, Double> gameIdToPowerMap = createGamePowerMap("day2", "Day2Part1Input.txt");   //76008
        double sum = gameIdToPowerMap.values().stream()
                .mapToDouble(v -> v)
                .sum();
        System.out.println("Power = " + sum);
    }

    public static void main(String[] args) {
        AOC02Dec2023 aoc02Dec2023 = new AOC02Dec2023();
        //aoc02Dec2023.day2part1Main();
        aoc02Dec2023.day2part2Main();

    }
}

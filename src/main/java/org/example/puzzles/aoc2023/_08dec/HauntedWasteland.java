package org.example.puzzles.aoc2023._08dec;

import org.example.puzzles.aoc2023.utils.ReadTextFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

public class HauntedWasteland {

    public int getNumberOfSteps(String dirName, String fileName){
        int numberOfSteps = 0;
        List<String> lines = getLinesFromInputFile(dirName, fileName);
        List<Direction> directionList = Direction.initializeDirectionsUsingListOfStrings(lines.subList(1, lines.size()));
        String directionInstruction = lines.get(0); //result -> LLR
        Character[] directionInstructionArr = directionInstruction.chars()
                .mapToObj(i -> (char) i)
                .toArray(Character[]::new);
        //Direction currentDirection = directionList.get(0);
        Direction currentDirection = directionList.stream().filter(direction -> direction.getId().equals("AAA")).findFirst().orElseThrow(RuntimeException::new);
        String currentDestination = "AAA";
        int currentPassThroughCnt = 0;
        while(!currentDestination.equals("ZZZ")){
            currentPassThroughCnt = currentPassThroughCnt + 1;

            for(int i = 0; i < directionInstructionArr.length; i++){
                numberOfSteps++;
                if(directionInstructionArr[i] == 'L') {
                    currentDestination = currentDirection.getLeftDirection();
                } else {
                    currentDestination = currentDirection.getRightDirection();
                }
                if(currentDestination.equals("ZZZ")){
                    break;
                }
                String finalCurrentDestination1 = currentDestination;
                currentDirection = directionList.stream()
                        .filter(direction -> direction.getId().equals(finalCurrentDestination1))
                        .findFirst()
                        .orElseThrow(RuntimeException::new);
                }
            System.out.println("currentPass: " + currentPassThroughCnt + " numberOfSteps: " + numberOfSteps);
            }
        System.out.println("Number of pass throughs done: " + currentPassThroughCnt + " and total number of steps done: " + numberOfSteps);
        return numberOfSteps;
    }

    private List<String> getLinesFromInputFile(String dirName, String fileName) {
        ReadTextFile readTextFile = new ReadTextFile();
        return readTextFile.readTextFileFromResources(dirName, fileName);
        //return lines.subList(1, lines.size() - 1);
    }

    public int getNumberOfStepsPartTwo(String dirName, String fileName){
        List<String> lines = getLinesFromInputFile(dirName, fileName);
        List<Direction> directionList = Direction.initializeDirectionsUsingListOfStrings(lines.subList(1, lines.size()));   //List of Direction object instances.
        //directionList.forEach(System.out::println);
        String directionInstruction = lines.get(0); //result -> LLR

        Character[] directionInstructionArr = directionInstruction.chars()
                .mapToObj(i -> (char) i)
                .toArray(Character[]::new);
        //System.out.println(Arrays.toString(directionInstructionArr));

        //Direction currentDirection = directionList.get(0);
        List<Direction> directionsEndingInA = directionList.stream()
                .filter(direction -> direction.getId().endsWith("A")).collect(toList());
        List<Direction> resultDirectionIds = new ArrayList<>(directionsEndingInA);
        int currentPassThroughCnt = 0;
        int stepsCount = 0; //this is the variable result that this method will return
        resultDirectionIds.forEach(System.out::println);
        System.out.println("---------------------");
        while(!areAllIdsEndingInZ(resultDirectionIds)){
            currentPassThroughCnt = currentPassThroughCnt + 1;
            for(int i = 0; i < directionInstructionArr.length; i++){
                if(i == 0){
                    System.out.println("Processed the 1st character: " + directionInstructionArr[i]);
                }
                stepsCount = stepsCount + 1;
                int finalI = i;
                List<Direction> collect = resultDirectionIds.stream()
                        .map(direction -> direction.applyDirectionAndGetNewDirectionId(directionInstructionArr[finalI]))
                        .flatMap(directionId -> directionList.stream().filter(directionA -> directionA.getId().equals(directionId)))
                        .collect(toList());
                resultDirectionIds = collect;
                if(areAllIdsEndingInZ(resultDirectionIds)){
                    return stepsCount;
                    //break;
                }
//                if(i == directionInstructionArr.length - 1){
//                    System.out.println("Processed the last character: " + directionInstructionArr[i]);
//                }
            }
//            if(currentPassThroughCnt%100 == 0){
//                System.out.println("currentPassThroughCnt: " + currentPassThroughCnt);
//                //resultDirectionIds.forEach(System.out::println);
//                //System.out.println("---------------------");
//            }
            System.out.println("currentPassThroughCnt: " + currentPassThroughCnt + " stepsCount: " + stepsCount);
        }
        return stepsCount;
    }

    private boolean areAllIdsEndingInZ(List<Direction> resultDirectionIds) {
        long count = resultDirectionIds.stream()
                .filter(direction -> direction.getId().endsWith("Z"))
                .count();
        return count == (long) resultDirectionIds.size();
    }

    public static void main(String[] args) {
        HauntedWasteland hauntedWasteland = new HauntedWasteland();
//        List<String> directionLines = hauntedWasteland.getLinesFromInputFile("day8", "Day8Sample1.txt");
//        directionLines.forEach(System.out::println);
        //System.out.println(hauntedWasteland.getNumberOfSteps("day8", "Day8Sample2.txt"));
        //System.out.println(hauntedWasteland.getNumberOfSteps("day8", "Day8Part1Input.txt"));    //Done: 18673
        //System.out.println(hauntedWasteland.getNumberOfStepsPartTwo("day8", "Day8Part2Sample.txt"));
        System.out.println(hauntedWasteland.getNumberOfStepsPartTwo("day8", "Day8Part2Input.txt"));
    }
}

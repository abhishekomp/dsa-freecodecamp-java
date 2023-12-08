package org.example.puzzles.aoc2023._08dec;

import org.example.puzzles.aoc2023.utils.ReadTextFile;

import java.util.List;
import java.util.Optional;

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

    public static void main(String[] args) {
        HauntedWasteland hauntedWasteland = new HauntedWasteland();
//        List<String> directionLines = hauntedWasteland.getLinesFromInputFile("day8", "Day8Sample1.txt");
//        directionLines.forEach(System.out::println);
        //System.out.println(hauntedWasteland.getNumberOfSteps("day8", "Day8Sample2.txt"));
        System.out.println(hauntedWasteland.getNumberOfSteps("day8", "Day8Part1Input.txt"));    //Done: 18673
    }
}

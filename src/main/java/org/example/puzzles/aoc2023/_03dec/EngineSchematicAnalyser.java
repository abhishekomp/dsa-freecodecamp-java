package org.example.puzzles.aoc2023._03dec;

import org.example.puzzles.aoc2023.utils.ReadTextFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class EngineSchematicAnalyser {

    private final int numRows, numCols;
    private final char[][] engineSchema;

    public EngineSchematicAnalyser(String dirName, String fileName) {
        this.engineSchema = initiateEngineSchema(dirName, fileName);
        this.numRows = this.engineSchema.length;
        this.numCols = this.engineSchema[0].length;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public char[][] getEngineSchema() {
        return engineSchema;
    }

    /*
        Reads each line from the text file and returns a list of strings with each string representing a single line of the file.
    */
    public List<String> readFile(String dirName, String fileName){
        ReadTextFile readTextFile = new ReadTextFile();
        return readTextFile.readTextFileFromResources(dirName, fileName);
    }


    public char[][] initiateEngineSchema(String dirName, String fileName){
        List<String> lines = readFile(dirName, fileName);
        char[][] engineSchema = new char[lines.size()][lines.get(0).length()];
        for(int j = 0; j < lines.size(); j++){
            String line = lines.get(j);
            for(int i = 0; i < line.length(); i++) {
                engineSchema[j][i] = line.charAt(i);
            }
        }
        return engineSchema;
    }

    public void displayEngineSchema(){
        for(int i = 0; i < engineSchema.length; i++){
            char[] row = engineSchema[i];
            for(int j = 0; j < row.length; j++){
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
    }

    /*
    Given x, y coordinate, get the valid neighbours
     */
    public List<Coordinate> getValidCoordinates(Coordinate coordinate){
        //List<Coordinate> validCoordinates = new ArrayList<>();
        Coordinate adjLeftHorizontal = getLeftHorizontalCoordinate(coordinate);
        Coordinate adjRightHorizontal = getRightHorizontalCoordinate(coordinate);
        Coordinate adjUpVertical = getAdjacentUpCoordinate(coordinate);
        Coordinate adjDownVertical = getAdjacentDownCoordinate(coordinate);
        Coordinate leftUpDiagonal = getLeftUpDiagonalCoordinate(coordinate);
        Coordinate leftDownDiagonal = getLeftDownDiagonalCoordinate(coordinate);
        Coordinate rightUpDiagonal = getRightUpDiagonalCoordinate(coordinate);
        Coordinate rightDownDiagonal = getRightDownDiagonalCoordinate(coordinate);
        List<Coordinate> neighbours = List.of(adjLeftHorizontal, adjRightHorizontal, adjUpVertical, adjDownVertical,
                leftUpDiagonal, leftDownDiagonal, rightUpDiagonal, rightDownDiagonal);
        return neighbours.stream()
                .filter(this::isCoordinateValid)
                .collect(toList());
    }

    /*
    Given a line, it will extract the numbers (probable part number) as List of Strings
     */
    public List<String> getNumbersFromLine(String line){
        List<String> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(line);
        while(matcher.find()){
            numbers.add(matcher.group(1));
        }
        return numbers;
    }

    public List<String> getEnginePartNumFromRow(int rowNum){
        StringBuilder partNum = new StringBuilder("");
        boolean partNumberIsValid = false;
        List<String> partNumbers = new ArrayList<>();   //this is finally returned
        char[] row = engineSchema[rowNum];
        for(int i = 0; i < numCols; i++){
            char readChar = row[i];
            if(Character.isDigit(readChar)){
                // If the read char is a digit then it is a candidate for being a part number.
                // Store the char in the partNum string variable and check if the current coordinate is a valid coordinate to be a partNum
                // The way to check if this coordinate is valid is to get all the valid neighbours and check if any of the neighbour is a symbol other than dot.
                // If any of the neighbour is a symbol other than dot then this digit becomes a candidate for being a partNum.
                partNum.append(readChar);
                //get valid neighbour coordinates for the current coordinate and check if any of the neighbour has a symbol other than dot.
                List<Coordinate> possibleNeighbours = getValidCoordinates(new Coordinate(rowNum, i));
                //Among these possible neighbours check if any of the neighbour has a symbol
                Coordinate coordinateWithSymbol = possibleNeighbours.stream()
                        .filter(coordinate -> Pattern.compile("[^a-zA-Z0-9.]").matcher(String.valueOf(engineSchema[coordinate.getX()][coordinate.getY()])).matches())
                        .findFirst()
                        .orElseGet(() -> new Coordinate(-1, -1));
                if(coordinateWithSymbol.isNonNegativeCoordinate()) {
                    partNumberIsValid = true;
                }
                // when you have reached the end of the line and you are holding a valid partNumber. next read of char is not possible hence you must add the current partNumber to the valid PartNumber list
                if(i == numCols - 1 && partNumberIsValid){
                    partNumbers.add(partNum.toString());
                }
                //Pattern.compile("[^a-zA-Z0-9.]").matcher(String.valueOf(engineSchema[coordinate.getX()][coordinate.getY()])).matches()
            } else {
                //if the read character is not a digit then check if partNum has value and if has value then check if partNumberIsValid flag is true
                //if true then add the partNum to the list of partNumbers and discard the partNum
                //If validPartNumber flag is false then do not add the partNum to the list of partNumers and reset the partNum to be a new StringBuilder.
                if(!partNum.toString().isBlank()){
                    if(partNumberIsValid){
                        partNumbers.add(partNum.toString());
                    }
                    partNumberIsValid = false;
                    partNum = new StringBuilder("");
                }
            }
        }
        return partNumbers;
    }

    boolean isCoordinateValid(Coordinate coordinate){
        return coordinate.getX() >=0 && coordinate.getX() < numRows
                && coordinate.getY() >=0 && coordinate.getY() < numCols;
    }

    private Coordinate getRightDownDiagonalCoordinate(Coordinate coordinate) {
        return new Coordinate(coordinate.getX() + 1, coordinate.getY() + 1);
    }

    private Coordinate getRightUpDiagonalCoordinate(Coordinate coordinate) {
        return new Coordinate(coordinate.getX() - 1, coordinate.getY() + 1);
    }

    private Coordinate getLeftDownDiagonalCoordinate(Coordinate coordinate) {
        return new Coordinate(coordinate.getX() + 1, coordinate.getY() - 1);
    }

    private Coordinate getLeftUpDiagonalCoordinate(Coordinate coordinate) {
        return new Coordinate(coordinate.getX() - 1, coordinate.getY() - 1);
    }

    private Coordinate getAdjacentDownCoordinate(Coordinate coordinate) {
        return new Coordinate(coordinate.getX() + 1, coordinate.getY());
    }

    private Coordinate getAdjacentUpCoordinate(Coordinate coordinate) {
        return new Coordinate(coordinate.getX() - 1, coordinate.getY());
    }

    private Coordinate getRightHorizontalCoordinate(Coordinate coordinate) {
        return new Coordinate(coordinate.getX(), coordinate.getY() + 1);
    }

    private Coordinate getLeftHorizontalCoordinate(Coordinate coordinate) {
        return new Coordinate(coordinate.getX(), coordinate.getY() - 1);
    }

    public List<String> getPartNumFromEachLine() {
        List<String> allValidPartNumAsListOfStrings = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<String> enginePartNumFromRow = getEnginePartNumFromRow(i);
            System.out.println(enginePartNumFromRow);
            allValidPartNumAsListOfStrings.addAll(enginePartNumFromRow);
        }
        return allValidPartNumAsListOfStrings;
    }

//    public static void main(String[] args) {
////        EngineSchematicAnalyser engineSchematicAnalyser =
////                new EngineSchematicAnalyser("day3", "Day3Sample.txt");
//        EngineSchematicAnalyser engineSchematicAnalyser =
//                new EngineSchematicAnalyser("day3", "Day3Part1Input.txt");
//        engineSchematicAnalyser.displayEngineSchema();
//        List<String> allValidPartNumbers = new ArrayList<>();
//        for(int i = 0; i < engineSchematicAnalyser.numRows; i++){
//            allValidPartNumbers.addAll(engineSchematicAnalyser.getEnginePartNumFromRow(i));
//        }
//        System.out.println("Total lines: " + engineSchematicAnalyser.getNumRows());
//        double sum = allValidPartNumbers.stream()
//                .mapToDouble(Integer::parseInt)
//                .sum();
//        System.out.println("sum = " + sum);
//    }

    //Part 1 solved. Answer: 556367
    public static void main(String[] args) {
//        EngineSchematicAnalyser engineSchematicAnalyser =
//                new EngineSchematicAnalyser("day3", "Day3Sample.txt");
        EngineSchematicAnalyser engineSchematicAnalyser =
                new EngineSchematicAnalyser("day3", "Day3Part1Input.txt");
//        EngineSchematicAnalyser engineSchematicAnalyser =
//                new EngineSchematicAnalyser("day3", "DebugSample.txt");
        List<String> allPartNumbers = engineSchematicAnalyser.getPartNumFromEachLine();
        double sum = allPartNumbers.stream()
                .mapToDouble(Integer::parseInt)
                .sum();
        System.out.println("sum = " + sum);
    }
}

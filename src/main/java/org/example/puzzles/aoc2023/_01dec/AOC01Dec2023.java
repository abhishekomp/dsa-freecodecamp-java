package org.example.puzzles.aoc2023._01dec;

import org.example.puzzles.aoc2023.utils.ReadTextFile;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AOC01Dec2023 {
    public String getFirstIntegerFromStart(String input){
        String myRegExp = "\\d";
        String firstIntAsString = "";
        Pattern pattern = Pattern.compile(myRegExp);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            firstIntAsString = matcher.group();
            //System.out.println(matcher.group());
        }
        return firstIntAsString;
    }

    public String getLastIntegerFromStart(String input){
        int len = input.length();
        char lastChar = 0;
        while(len > 0){
            if(Character.isDigit(input.charAt(len - 1))){
                lastChar = input.charAt(len - 1);
                break;
            }
            len--;
        }
        //System.out.println(lastChar);
        return lastChar == 0 ? "" : String.valueOf(lastChar);   //Learning==empty char is 0 in java
        //return String.valueOf(lastChar);  //if there is no digit at all then a gibberish was being returned.
    }

    /*
    When no digits in the string input then return 0
     */
    public int getNumberUsingFirstAndLastDigit(String input){
        int number = 0;
        String firstIntegerFromStart = getFirstIntegerFromStart(input);
        String lastIntegerFromStart = getLastIntegerFromStart(input);
        if(firstIntegerFromStart.isEmpty() || lastIntegerFromStart.isEmpty()){
            return number;
        }
        number = Integer.parseInt(firstIntegerFromStart + lastIntegerFromStart);
        return number;
    }

    /*
    Reads the input file with multiple lines and returns each line as a String in a list
     */
    public List<String> readFile(String dirName, String fileName){
        ReadTextFile readTextFile = new ReadTextFile();
        return readTextFile.readTextFileFromResources(dirName, fileName);
    }

    public double day1Part1Main(String dirName, String fileName){
        List<String> strings = readFile(dirName, fileName);
        double finalSum = 0.0;
        for(String str : strings){
            int numberUsingFirstAndLastDigit = getNumberUsingFirstAndLastDigit(str);
            System.out.println(numberUsingFirstAndLastDigit);
            finalSum += numberUsingFirstAndLastDigit;
        }
        return finalSum;
    }

    public double day1Part2Main(String dirName, String fileName) {
        List<String> strings = readFile(dirName, fileName);
        double finalSum = 0.0;
        DigitFinder digitFinder = new DigitFinder();
        int numberFromLine = 0;
        for(String str : strings){
            numberFromLine = digitFinder.getNumberFromLine(str);
            System.out.println(numberFromLine);
            finalSum += numberFromLine;
        }
        return finalSum;
    }

//    public double day1Part2Main(String fileName) {
//        List<String> strings = readFile(fileName);
//        double finalSum = 0.0;
//        DigitFinder digitFinder = new DigitFinder();
//        int numberFromString = 0;
//        for(String str : strings){
//            String firstDigitAsString = digitFinder.getFirstDigitAsString(str);
//            String lastDigitAsString = digitFinder.getLastDigitAsString(str);
//            if(!firstDigitAsString.isEmpty() && !lastDigitAsString.isEmpty()) {
//                String tempNumber = String.valueOf(digitFinder.getStringAsInteger(firstDigitAsString)) + digitFinder.getStringAsInteger(lastDigitAsString);
//                System.out.println("Temp number: " + tempNumber);
//                numberFromString = Integer.parseInt(tempNumber);
//            }
//            //System.out.println(numberFromString);
//            finalSum += numberFromString;
//        }
//        return finalSum;
//    }

    public static void main(String[] args) {
        AOC01Dec2023 program = new AOC01Dec2023();
//        System.out.println(program.getFirstIntegerFromStart("abc1def"));    //1
//        System.out.println(program.getFirstIntegerFromStart("abc1de2f"));   //1
//        System.out.println(program.getFirstIntegerFromStart("ab41def"));    //4
//        System.out.println(program.getFirstIntegerFromStart("8abc1def"));   //8
//        System.out.println(program.getFirstIntegerFromStart("abcdef4"));    //4
//        System.out.println(program.getFirstIntegerFromStart("abcdef"));     //

//        System.out.println(program.getLastIntegerFromStart("abc1def"));
//        System.out.println(program.getLastIntegerFromStart("abc8def"));
//        System.out.println(program.getLastIntegerFromStart("abc78def"));
//        System.out.println(program.getLastIntegerFromStart("abc1de4f"));
//        System.out.println(program.getLastIntegerFromStart("abc1def2"));
//        System.out.println(program.getLastIntegerFromStart("abcdef"));

//        System.out.println(program.getNumberUsingFirstAndLastDigit("ab9c8def"));    //98
//        System.out.println(program.getNumberUsingFirstAndLastDigit("abc1def"));     //11
//        System.out.println(program.getNumberUsingFirstAndLastDigit("abcdef"));      //0
//        System.out.println(program.getNumberUsingFirstAndLastDigit("ab7c8def"));    //78
//        System.out.println(program.getNumberUsingFirstAndLastDigit("abcdef8"));     //88

        // First part //54940
        //String fileName = "Day1Part1Sample.txt"; //Day1Part1Sample.txt, Day1Part1Input.txt
//        String fileName = "Day1Part1Input.txt"; //Day1Part1Sample.txt
//        double day1Part1Main = program.day1Part1Main("day1", fileName);
//        System.out.println("day1Part1Main = " + day1Part1Main);

        // Second part //54208
        //String fileName = "Day1Part2Sample.txt";    //281
        String fileName = "Day1Part2Input.txt"; //Day1Part2Sample.txt
        double day1Part2Main = program.day1Part2Main("day1", fileName);
        System.out.println("day1Part2Main = " + day1Part2Main);
    }
}

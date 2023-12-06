package org.example.puzzles.aoc2023._06dec;

import org.example.puzzles.aoc2023.utils.ReadTextFile;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RaceAnalyser {

    // For the range of allowed time, calculate the distance travelled by boat i.e. for each millisecond in the range.
    private double getDistanceTravelled(int pressedDuration, double totalAllowedDuration){
        double timeForTravel = totalAllowedDuration - pressedDuration;
        return pressedDuration * timeForTravel;
    }

    // Determine if pressing for n milliseconds, if it is possible to break the current record
    private boolean canBreakRecord(int pressedDuration, double currentRecord, double totalAllowedDuration){
        double distanceTravelled = getDistanceTravelled(pressedDuration, totalAllowedDuration);
        return distanceTravelled > currentRecord;
    }

    // For the given range get the number of ways the record can be broken
//    public int numberOfWaysToBreakTheRecord(int totalAllowedDuration, int currentRecord){
//        int numberOfWaysToBreakRecord = 0;
//        List<Integer> waysToBreakRecord = IntStream.rangeClosed(0, totalAllowedDuration)
//                .filter(i -> canBreakRecord(i, currentRecord, totalAllowedDuration))
//                .boxed()
//                .collect(toList());
//        return waysToBreakRecord.size();
//    }

    // For the given race get the number of ways the record can be broken
    public int numberOfWaysToBreakTheRecord(Race race){
        double totalAllowedDuration = race.getTotalAllowedDuration();
        double currentRecord = race.getCurrentRecord();
        List<Integer> waysToBreakRecord = IntStream.rangeClosed(0, (int) totalAllowedDuration)
                .filter(i -> canBreakRecord(i, currentRecord, totalAllowedDuration))
                .boxed()
                .collect(toList());
        return waysToBreakRecord.size();
    }

    // Read file content and create races
    public List<Race> readFileAndCreateRaces(String dirName, String fileName){
        ReadTextFile readTextFile = new ReadTextFile();
        List<String> raceLines = readTextFile.readTextFileFromResources(dirName, fileName);
        String timeLine = raceLines.get(0);
        List<Double> allowedTimeLimits = getValues(timeLine);
        String distanceLine = raceLines.get(1);
        List<Double> currentRecordList = getValues(distanceLine);
        List<Race> races = new ArrayList<>();
        for(int i = 0; i < allowedTimeLimits.size(); i++){
            races.add(new Race(allowedTimeLimits.get(i), currentRecordList.get(i)));
        }
        return races;
    }

    private List<Double> getValues(String str) {
        List<Double> valueList = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            valueList.add(Double.parseDouble(matcher.group(1)));
        }
        return valueList;
    }

    //Done: 1710720
    public double part1main(String dirName, String fileName){
        List<Race> races = readFileAndCreateRaces(dirName, fileName);
        return races.stream()
                .mapToDouble(this::numberOfWaysToBreakTheRecord)
                .reduce(1, (partialResult, number) -> partialResult * number);
    }

    //Done: 35349468 (= 3.5349468E7)
    public double part2main(String dirName, String fileName){
        List<Race> races = readFileAndCreateRaces(dirName, fileName);
        return races.stream()
                .mapToDouble(this::numberOfWaysToBreakTheRecord)
                .reduce(1, (partialResult, number) -> partialResult * number);
    }
    public static void main(String[] args) {
        RaceAnalyser raceAnalyser = new RaceAnalyser();
        //double errorMargin = raceAnalyser.part1main("day6", "Day6Sample.txt");
        //double errorMargin = raceAnalyser.part1main("day6", "Day6Input.txt");   //1710720 Done
        double errorMargin = raceAnalyser.part2main("day6", "Day6InputPart2.txt");  //3.5349468E7
        System.out.println(errorMargin);
    }

}

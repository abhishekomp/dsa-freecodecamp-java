package org.example.puzzles.aoc2023._05dec;

import org.example.puzzles.aoc2023.utils.ReadTextFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.LongStream;

public class SeedNumberFetcher {
    public List<Long> fetchSeedNumbers(String dirName, String fileName){
        ReadTextFile readTextFile = new ReadTextFile();
        List<String> strings = readTextFile.readTextFileFromResources(dirName, fileName);
        List<Long> seedNumbers = new ArrayList<>();
        String seedLine = strings.get(0);   //Gets the line for seed
        String seedNumbersAsStr = seedLine.split(":")[1].trim(); //After trimming, result = "79 14 55 13"
        Pattern pattern = Pattern.compile("(\\d+\\s\\d+)");
        Matcher matcher = pattern.matcher(seedNumbersAsStr);
        List<String> seedNumbersStr = new ArrayList<>();
        while(matcher.find()){
            seedNumbersStr.add(matcher.group(1));
            //seedNumbers.add(Long.parseLong(matcher.group(1).trim()));
        }
        System.out.println("seedNumbersStr: " + seedNumbersStr);
        //Map<Long, Long> seedStartToRangeMap = new HashMap<>();
        for(String seedNumberWithRange : seedNumbersStr){
            String[] split = seedNumberWithRange.split("\\s+");
            long seedNumberStart = Long.parseLong(split[0].trim());
            long seedRange = Long.parseLong(split[1].trim());
            seedNumbers.add(seedNumberStart);
            for(long i = 1; i < seedRange; i++){
                seedNumbers.add(seedNumbers.get(seedNumbers.size() - 1) + 1);
            }
            //seedStartToRangeMap.put(seedNumberStart, seedRange);
        }

        return seedNumbers;
    }

    /*
    This implementation is for part 1 of the puzzle. Part 2 has different requirement for extracting the seed numbers.
     */
//    public List<Long> fetchSeedNumbers(String dirName, String fileName){
//        ReadTextFile readTextFile = new ReadTextFile();
//        List<String> strings = readTextFile.readTextFileFromResources(dirName, fileName);
//        String seedLine = strings.get(0);
//        String seedNumbersAsStr = seedLine.split(":")[1].trim(); //"79 14 55 13"
//        Pattern pattern = Pattern.compile("(\\d+)");
//        Matcher matcher = pattern.matcher(seedNumbersAsStr);
//        List<Long> seedNumbers = new ArrayList<>();
//        while(matcher.find()){
//            //seedNumbers.add(Integer.parseInt(matcher.group(1).trim()));
//            seedNumbers.add(Long.parseLong(matcher.group(1).trim()));
//        }
//        return seedNumbers;
//    }
}

package org.example.puzzles.aoc2023._02dec;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class GameUtils {

    /*
    Input: The entire game sentence (single game string from the input)
    For every given line as a String, get the game number preceding the colon sign.
    Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
    Should give 1
    Game 28: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
    Should give 28
     */
    public static int getGameId(String input){
        int gameId = 0;
        Pattern pattern = Pattern.compile("(\\d+):");   //extracting the digits just before the colon.
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            //System.out.println("Matcher found " + matcher.group(1) + " at index " + matcher.start());
            gameId = Integer.parseInt(matcher.group(1));
        }
        return gameId;
    }

    /*
    This gets the game description from the game sentence.
    Example: Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
    Result: "3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
     */
    public String getGameDescription(String gameSentence){
        //Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
        return gameSentence.split(": ")[1];
    }

    /*
    Input: "3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
    Result: List containing each round (3 rounds in this game with each round separated by "; ")
     */
    public List<String> getRoundsPerGame(String gameDesc){
        return Arrays.stream(gameDesc.split("; "))
                .collect(toList());
    }

}

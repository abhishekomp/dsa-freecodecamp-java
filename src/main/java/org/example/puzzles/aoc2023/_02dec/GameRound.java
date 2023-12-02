package org.example.puzzles.aoc2023._02dec;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameRound {
    private final String gameRoundString;
    private final int redCnt;
    private final int blueCnt;
    private final int greenCnt;

    private static final int ALLOWED_RED_CNT    = 12;
    private static final int ALLOWED_GREEN_CNT  = 13;
    private static final int ALLOWED_BLUE_CNT   = 14;

    //A round of game can be: 3 blue, 4 red
    //A round of game can be: 2 green
    public GameRound(String gameRoundString) {
        this.gameRoundString = gameRoundString;
        //createConfiguration(gameRoundString, "red");
        this.redCnt = evaluateConfiguration(gameRoundString, "red");
        this.blueCnt = evaluateConfiguration(gameRoundString, "blue");
        this.greenCnt = evaluateConfiguration(gameRoundString, "green");
    }

    // 3 blue, 4 red
    // 2 green
    // 3 green, 4 blue, 1 red
    public int evaluateConfiguration(String gameRoundString, String color){
        int colorCnt = 0;
        if(gameRoundString.indexOf(',') != -1){
            // comma present, for each color count combination extract the color and its count
            for(String round: gameRoundString.split(", ")){
                if(round.contains(color)) {
                    colorCnt = extractColorConfiguration(round);
                    break;
                }
            }
        } else if (gameRoundString.contains(color)){
            colorCnt = extractColorConfiguration(gameRoundString);
        }
        return colorCnt;
    }

    private int extractColorConfiguration(String colorCountStr){
        String[] colorCntArray = colorCountStr.split(" ");
        return Integer.parseInt(colorCntArray[0]);
    }

//    public String getGameRoundString() {
//        return gameRoundString;
//    }

    public boolean isRoundValid(){
        return this.redCnt <= ALLOWED_RED_CNT && this.greenCnt <= ALLOWED_GREEN_CNT && this.blueCnt <= ALLOWED_BLUE_CNT;
    }

    @Override
    public String toString() {
        return "GameRound{" +
                "gameRoundString='" + gameRoundString + '\'' +
                ", redCnt=" + redCnt +
                ", blueCnt=" + blueCnt +
                ", greenCnt=" + greenCnt +
                '}';
    }

    public static void main(String[] args) {
        //GameRound gameRound = new GameRound("3 blue, 4 red");
        GameRound invalidRound = new GameRound("8 green, 6 blue, 20 red");
        //GameRound gameRound = new GameRound("2 green");
        System.out.println("Round: " + invalidRound + " validity: " + invalidRound.isRoundValid());
    }
}


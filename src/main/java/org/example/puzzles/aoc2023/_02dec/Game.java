package org.example.puzzles.aoc2023._02dec;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {


    private final int gameId;
    private final String gameDescription;
    private final String gameSentence;

    public Game(String gameSentence) {
        this.gameSentence = gameSentence;
        Pattern pattern = Pattern.compile("(\\d+):");   //extracting the digits just before the colon.
        Matcher matcher = pattern.matcher(gameSentence);
        int calcGameId = 0;
        if(matcher.find()){
            calcGameId = Integer.parseInt(matcher.group(1));
        }
        this.gameId = calcGameId;
        this.gameDescription = gameSentence.split(": ")[1];
    }

    public int getGameId() {
        return gameId;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public String getGameSentence() {
        return gameSentence;
    }

    public boolean isGamePossible() {
        GameUtils gameUtils = new GameUtils();
        List<String> gameRounds = gameUtils.getRoundsPerGame(gameDescription);
        boolean gamePossible = true;
        for(String gameRound : gameRounds) {
            GameRound roundValidator = new GameRound(gameRound);
            if(!roundValidator.isRoundValid()){
                gamePossible = false;
                break;
            }
        }
        return gamePossible;
    }

    public Double getMaxBallsAndPower(){
        GameUtils gameUtils = new GameUtils();
        List<String> gameRounds = gameUtils.getRoundsPerGame(gameDescription);
        int redMax = getMaxBallsUsingColor(gameRounds, "red");
        int greenMax = getMaxBallsUsingColor(gameRounds, "green");
        int blueMax = getMaxBallsUsingColor(gameRounds, "blue");
        //System.out.println("power = " + power);
        return (double) redMax * (double) greenMax * (double) blueMax;
    }

    private int getMaxBallsUsingColor(List<String> gameRounds, String color) {
        int count = 0;
        if("red".equals(color)){
            return gameRounds.stream()
                    .map(GameRound::new)
                    .mapToInt(GameRound::getRedCnt)
                    .max()
                    .orElse(0);
        } else if ("blue".equals(color)) {
            return gameRounds.stream()
                    .map(GameRound::new)
                    .mapToInt(GameRound::getBlueCnt)
                    .max()
                    .orElse(0);
        } else if ("green".equals(color)) {
            return gameRounds.stream()
                    .map(GameRound::new)
                    .mapToInt(GameRound::getGreenCnt)
                    .max()
                    .orElse(0);
        }
        return count;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameSentence='" + gameSentence + '\'' +
                '}';
    }
}

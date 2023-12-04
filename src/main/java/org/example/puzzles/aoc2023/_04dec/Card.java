package org.example.puzzles.aoc2023._04dec;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private final int id;
    private final List<Integer> winningNumbers;
    private final List<Integer> playersNumbers;

    private static final int CARD_WORTH_MULTIPLIER = 2;


    public Card(int id, List<Integer> winningNumbers, List<Integer> playersNumbers) {
        this.id = id;
        this.winningNumbers = winningNumbers;
        this.playersNumbers = playersNumbers;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public List<Integer> getPlayersNumbers() {
        return playersNumbers;
    }

    public List<Integer> winningNumbersWithPlayer(){
        List<Integer> winningNumbersWithPlayer = new ArrayList<>(playersNumbers);
        winningNumbersWithPlayer.retainAll(winningNumbers);
        return winningNumbersWithPlayer;
    }

    public double getWorthPoint(){
        List<Integer> winningNumbersWithPlayer = winningNumbersWithPlayer();
        int winningNumbersCount = winningNumbersWithPlayer.size();
        if(winningNumbersCount == 0){
            return 0.0;
        } else if (winningNumbersCount == 1) {
            return 1.0;
        }
        double cardWorth = 1.0;
        for(int i = 0; i < winningNumbersCount - 1; i++){
            cardWorth = cardWorth * CARD_WORTH_MULTIPLIER;
        }
        return cardWorth;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", winningNumbers=" + winningNumbers +
                ", playersNumbers=" + playersNumbers +
                '}';
    }
}

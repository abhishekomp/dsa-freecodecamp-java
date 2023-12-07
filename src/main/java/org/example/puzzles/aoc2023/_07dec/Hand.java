package org.example.puzzles.aoc2023._07dec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public class Hand implements Comparable<Hand>{
    private static final int NUM_OF_CARDS = 5;
    private final List<Card> cards;
    private final HandType handType;
    private final String cardsStringRepr;

    private final int bidAmount;

    public Hand(String cardsStringRepr){
        this.cardsStringRepr = cardsStringRepr;
        this.cards = new ArrayList<>(NUM_OF_CARDS);
        String[] cardStringSplit = cardsStringRepr.split("\\s+");
        this.bidAmount = Integer.parseInt(cardStringSplit[1].trim());   // 2nd part of the input line "32T3K 765"
        this.cards.addAll(initializeCardsFromString(cardStringSplit[0]));
        this.handType = evaluateHandType(cardStringSplit[0]);
    }

    private HandType evaluateHandType(String cardsStringRepr) {
        //System.out.println("Inside evaluateHandType cardStringRepr: " + cardsStringRepr);
        HandTypeChecker handTypeChecker = new HandTypeChecker();
        return handTypeChecker.getHandType(cardsStringRepr);
    }

    public HandType getHandType() {
        return handType;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    private Collection<? extends Card> initializeCardsFromString(String cardsStringRepr) {
        return cardsStringRepr.chars()
                .mapToObj(i -> (char) i)
                .map(Card::new)
                .collect(toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                ", handType=" + handType +
                ", cardsStringRepr='" + cardsStringRepr + '\'' +
                ", bidAmount=" + bidAmount +
                '}';
    }

    @Override
    public int compareTo(Hand other) {
        int currentHandTypeIndex = IntStream.range(0, HandType.values().length)
                .filter(i -> HandType.values()[i] == this.handType)
                .findFirst()
                .orElse(-1);
        int otherHandTypeIndex = IntStream.range(0, HandType.values().length)
                .filter(i -> HandType.values()[i] == other.handType)
                .findFirst()
                .orElse(-1);
        if(currentHandTypeIndex > otherHandTypeIndex){
            return 1;
        } else if (currentHandTypeIndex < otherHandTypeIndex) {
            return -1;
        } else {
            //System.out.println(this + "\n has hand type: " + this.handType + "\n" + other + " has handtype: " + other.handType);
            return compareCards(this, other);
        }
    }
    private int compareCards(Hand thisHand, Hand otherHand) {
        List<Card> thisCards = thisHand.cards;
        int cardCompareResult = 0;
        for(int i = 0; i < thisCards.size(); i++){
            cardCompareResult = Card.compareTwoCards(thisCards.get(i), otherHand.cards.get(i));
            //cardCompareResult = Integer.compare(thisCards.get(i).getCardVal(), otherHand.cards.get(i).getCardVal());
            if(cardCompareResult == 0){
                continue;
            } else {
                break;
            }
        }
        return cardCompareResult;
    }
}

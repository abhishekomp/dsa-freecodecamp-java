package org.example.puzzles.aoc2023._04dec;

import org.example.puzzles.aoc2023.utils.ReadTextFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class AOC04Dec2023 {

    /**
     * Read the file and get back a List of String with each String representing a single line.
     * @param dirName   directory name inside the resources directory
     * @param fileName  name of the text file to read
     * @return  List<String>
     */
    public List<String> readFile(String dirName, String fileName){
        ReadTextFile readTextFile = new ReadTextFile();
        return readTextFile.readTextFileFromResources(dirName, fileName);
    }

    /**
     * Creates a list of card objects from the list of lines (list of strings)
     * @param lines List of lines from the input file
     * @return  A list of cards
     */
    public List<Card> createCardListFromListOfString(List<String> lines){
        return lines.stream()
                .map(this::initializeCard)
                .collect(toList());
    }

    /**
     * Initializes a card from a given line describing the card.
     * @param line  A single line from the input file representing a card
     * @return Card a fully initialized card object
     */
    public Card initializeCard(String line){
        //line -> Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
        String[] splitLineArr = line.split(":");
        int cardId = getCardId(splitLineArr[0]);
        //trim leading and trailing spaces if any (of course there are leading spaces in this case)
        String[] split = splitLineArr[1].trim().split(" \\| ");
        String winningNumbersAsStr = split[0];
        String playersNumbersAsStr = split[1];
        //System.out.println("Card Id: '" + cardId + "' winning numbers as string: '" + winningNumbersAsStr + "', playersNumbers: '" + playersNumbersAsStr + "'");

        //create the list of integer for the winning numbers
        List<Integer> winningNumbers = getIntegerListFromCardDescription(winningNumbersAsStr);
        //System.out.println("Winning numbers list as Integers: " + winningNumbers);
        List<Integer> playersNumbersList = getIntegerListFromCardDescription(playersNumbersAsStr);
        //System.out.println("Players numbers list as Integers: " + playersNumbersList);

        //Create a Card instance using the cardId, winningNumber, playersNumbersList
        return new Card(
                cardId,
                Collections.unmodifiableList(winningNumbers),
                Collections.unmodifiableList(playersNumbersList)
        );
    }

    /*
    From "41 48 83 86 17" create a list of integers from the given string
     */
    private static List<Integer> getIntegerListFromCardDescription(String winningNumbersAsStr) {
        //System.out.println(winningNumbersAsStr);
        return Arrays.stream(winningNumbersAsStr.trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(toList());
    }
    private int getCardId(String cardName) {
        int cardId = -1;
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(cardName);
        if(matcher.find()){
            cardId = Integer.parseInt(matcher.group(1));
        }
        return cardId;
    }

    //Here we are finding out which winning numbers are being held by the player.
    //There is a list of winning numbers.
    //Then there is a player holding a few numbers, and we need to find which all winning numbers are in player's hand.
    @Deprecated
    public List<Integer> getWinningNumbersFromList(List<Integer> winningNumbers, List<Integer> numbersWithPlayer){
        List<Integer> winningNumbersWithPlayer = new ArrayList<>(numbersWithPlayer);
        winningNumbersWithPlayer.retainAll(winningNumbers);
        return winningNumbersWithPlayer;
    }

    /*
    Takes a card and returns the list of winning numbers held by the player.
     */
    @Deprecated
    public List<Integer> getWinningNumbersFromCard(Card card){
        return getWinningNumbersFromList(card.getWinningNumbers(), card.getPlayersNumbers());
    }

    public double calculateCardsWorth(String dirName, String fileName){
        List<String> cardLines = readFile(dirName, fileName);
        List<Card> cardList = createCardListFromListOfString(cardLines);
        return cardList.stream()
                .mapToDouble(Card::getWorthPoint)
                .sum();
    }

    public static void main(String[] args) {
        String dirName = "day4";
        //String fileName = "Day4Sample.txt";
        String fileName = "Day4Part1Input.txt";
        AOC04Dec2023 aoc04Dec2023 = new AOC04Dec2023();
        double totalWorthPart1 = aoc04Dec2023.calculateCardsWorth(dirName, fileName);
        System.out.println(totalWorthPart1);    //20117
//        List<String> lines = aoc04Dec2023.readFile(dirName, fileName);
//        lines.forEach(System.out::println);
    }
}

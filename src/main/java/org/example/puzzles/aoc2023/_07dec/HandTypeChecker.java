package org.example.puzzles.aoc2023._07dec;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.*;

public class HandTypeChecker {

    private Map<Character, Integer> initializeCardMap(String hand) {
        return hand.chars()
                .mapToObj(i -> (char) i)
                .collect(groupingBy(Function.identity(), collectingAndThen(counting(), Long::intValue)));
    }

    public boolean isHandFiveOfAKind(String input){
        Map<Character, Integer> characterIntegerMap = input.chars()
                .mapToObj(i -> (char) i)
                .collect(groupingBy(Function.identity(), collectingAndThen(counting(), Long::intValue)));
        Optional<Map.Entry<Character, Integer>> optionalEntry = characterIntegerMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 5)
                .findFirst();
        return optionalEntry.isPresent();
    }

    public boolean isHandFiveOfAKindRegex(String hand){
        Pattern pattern = Pattern.compile("A{5}|K{5}|Q{5}|J{5}|T{5}|1{5}|2{5}|3{5}|4{5}|5{5}|6{5}|7{5}|8{5}|9{5}");
        //Pattern pattern = Pattern.compile("(?=(A|K|Q|J|T|){5}).*"); // matches AAAAA
        //Pattern pattern = Pattern.compile("^([AKQJT1-9]{5})$");
        //Pattern pattern = Pattern.compile("(?=((A|K|Q|J|T|)|[0-9]){5}).*"); // matches 44444 and AAAAA
        //Pattern pattern = Pattern.compile("\\A(?=((A|K|Q|J|T|)|[0-9]){5}\\z).*"); // matches 44444 and AAAAA
        //Pattern pattern = Pattern.compile("\\A(?=((A|K|Q|J|T|)|[1-9]){5}\\z)");
        //Pattern pattern = Pattern.compile("(?=((A|K|Q|J|T|)|[1-9]){5})");
        Matcher matcher = pattern.matcher(hand);
        return matcher.matches();
    }

    public boolean isHandFourOfAKind(String input) {
        Map<Character, Integer> characterIntegerMap = input.chars()
                .mapToObj(i -> (char) i)
                .collect(groupingBy(Function.identity(), collectingAndThen(counting(), Long::intValue)));
        Optional<Map.Entry<Character, Integer>> optionalEntry = characterIntegerMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 4)
                .findFirst();
        return optionalEntry.isPresent();
    }

    public boolean isHandAFullHouse(String input) {
        Map<Character, Integer> characterIntegerMap = input.chars()
                .mapToObj(i -> (char) i)
                .collect(groupingBy(Function.identity(), collectingAndThen(counting(), Long::intValue)));
        //int size = characterIntegerMap.size();
        Optional<Map.Entry<Character, Integer>> optionalEntry = characterIntegerMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 3)
                .findFirst();
        return (characterIntegerMap.size() == 2 && optionalEntry.isPresent());

    }

    public boolean isHandAThreeOfAKind(String input) {
        Map<Character, Integer> characterIntegerMap = input.chars()
                .mapToObj(i -> (char) i)
                .collect(groupingBy(Function.identity(), collectingAndThen(counting(), Long::intValue)));
        //int size = characterIntegerMap.size();
        Optional<Map.Entry<Character, Integer>> optionalEntry = characterIntegerMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 3)
                .findFirst();
        return (characterIntegerMap.size() == 3 && optionalEntry.isPresent());
    }

    public boolean isHandATwoPair(String input) {
        Map<Character, Integer> characterIntegerMap = input.chars()
                .mapToObj(i -> (char) i)
                .collect(groupingBy(Function.identity(), collectingAndThen(counting(), Long::intValue)));
        //int size = characterIntegerMap.size();
        long count = characterIntegerMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .count();
        return (characterIntegerMap.size() == 3 && count == 2L);
    }

    public boolean isHandAOnePair(String input) {
        Map<Character, Integer> characterIntegerMap = input.chars()
                .mapToObj(i -> (char) i)
                .collect(groupingBy(Function.identity(), collectingAndThen(counting(), Long::intValue)));
        //int size = characterIntegerMap.size();
        long count = characterIntegerMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .count();
        return (characterIntegerMap.size() == 4 && count == 1L);
    }
    public boolean isHandAHighCard(String input) {
        Map<Character, Integer> characterIntegerMap = input.chars()
                .mapToObj(i -> (char) i)
                .collect(groupingBy(Function.identity(), collectingAndThen(counting(), Long::intValue)));
        //int size = characterIntegerMap.size();
        long count = characterIntegerMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .count();
        return (characterIntegerMap.size() == 5 && count == 0L);
    }

    public HandType getHandType(String cardsStringRepr) {
        if(isHandFiveOfAKind(cardsStringRepr)){
            return HandType.FIVE_OF_A_KIND;
        } else if (isHandFourOfAKind(cardsStringRepr)) {
            return HandType.FOUR_OF_A_KIND;
        } else if (isHandAFullHouse(cardsStringRepr)) {
            return HandType.FULL_HOUSE;
        } else if (isHandAThreeOfAKind(cardsStringRepr)) {
            return HandType.THREE_OF_A_KIND;
        } else if (isHandATwoPair(cardsStringRepr)) {
            return HandType.TWO_PAIR;
        } else if (isHandAOnePair(cardsStringRepr)) {
            return HandType.ONE_PAIR;
        } else {
            return HandType.HIGH_CARD;
        }
    }
}

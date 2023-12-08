package org.example.puzzles.aoc2023._08dec;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void testToString() {
        String directionStr = "AAA = (BBB, CCC)";
        Direction direction = new Direction(directionStr);
        System.out.println(direction);
    }

    @Test
    void initializeDirectionsUsingListOfStrings() {
        String directionStrOne = "AAA = (BBB, CCC)";
        String directionStrTwo = "BBB = (DDD, EEE)";
        List<Direction> directions = Direction.initializeDirectionsUsingListOfStrings(List.of(directionStrOne, directionStrTwo));
        directions.forEach(System.out::println);
    }

    @Test
    void test_convert_String_to_Character_list(){
        // Convert a String to List<Character>
        String input = "LLR";
        List<Character> characterList = input.chars()
                .mapToObj(i -> (char) i)
                .collect(toList());
        System.out.println(characterList);
    }

    @Test
    void test_convert_String_to_Character_array(){
        // Convert a String to Character[]
        String input = "LLR";
        Character[] characters = input.chars()
                .mapToObj(i -> (char) i)
                .toArray(Character[]::new);
        System.out.println(Arrays.toString(characters));
    }
}
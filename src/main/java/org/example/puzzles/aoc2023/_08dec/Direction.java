package org.example.puzzles.aoc2023._08dec;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

public class Direction {

    private final String id;
    private final String leftRight;
    private final String directionStr;


    public Direction(String directionStr) {
        this.directionStr = directionStr;
        String[] split = directionStr.split("\\s+=\\s+");
        this.id = split[0];
        this.leftRight = split[1].replaceAll("\\(", "").replaceAll("\\)", "");
    }

    public String getId() {
        return id;
    }

    public String getLeftRight() {
        return leftRight;
    }

    public String getDirectionStr() {
        return directionStr;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "id='" + id + '\'' +
                ", leftRight='" + leftRight + '\'' +
                ", directionStr='" + directionStr + '\'' +
                '}';
    }

    public static List<Direction> initializeDirectionsUsingListOfStrings(List<String> lines){
        return lines.stream()
                .map(Direction::new)
                .collect(toCollection(ArrayList::new));
    }

    public String getLeftDirection() {
        return leftRight.split(",\\s+")[0];
    }

    public String getRightDirection() {
        return leftRight.split(",\\s+")[1];
    }
}

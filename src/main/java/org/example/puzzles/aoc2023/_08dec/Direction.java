package org.example.puzzles.aoc2023._08dec;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

public class Direction {

    /*
    For 1 given line from the input file, the line is represented as
    11A = (11B, XXX)
    An instance of this class is represented as:
    id              -> 11A
    leftRight       -> 11B, XXX
    directionStr    -> 11A = (11B, XXX)
     */

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

    /**
     * Creates a List of Direction objects using the lines from the input file
     * @param lines Lines from the input file
     * @return List containing Direction class's instances
     */
    public static List<Direction> initializeDirectionsUsingListOfStrings(List<String> lines){
        return lines.stream()
                .map(Direction::new)
                .collect(toCollection(ArrayList::new));
    }

    public String applyDirectionAndGetNewDirectionId(char dirChar) {
        if(dirChar == 'L'){
            return getLeftDirection();
        } else {
            return getRightDirection();
        }
    }

    public String getLeftDirection() {
        return leftRight.split(",\\s+")[0];
    }

    public String getRightDirection() {
        return leftRight.split(",\\s+")[1];
    }
}

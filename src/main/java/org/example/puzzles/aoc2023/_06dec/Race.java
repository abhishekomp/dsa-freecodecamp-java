package org.example.puzzles.aoc2023._06dec;

public class Race {

    private final int totalAllowedDuration;
    private final int currentRecord;

    public Race(int totalAllowedDuration, int currentRecord) {
        this.totalAllowedDuration = totalAllowedDuration;
        this.currentRecord = currentRecord;
    }

    public int getTotalAllowedDuration() {
        return totalAllowedDuration;
    }

    public int getCurrentRecord() {
        return currentRecord;
    }

    @Override
    public String toString() {
        return "Race{" +
                "totalAllowedDuration=" + totalAllowedDuration +
                ", currentRecord=" + currentRecord +
                '}';
    }
}

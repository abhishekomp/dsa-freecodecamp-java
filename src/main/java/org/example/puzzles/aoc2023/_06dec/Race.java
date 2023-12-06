package org.example.puzzles.aoc2023._06dec;

public class Race {

    private final double totalAllowedDuration;
    private final double currentRecord;

    public Race(int totalAllowedDuration, int currentRecord) {
        this.totalAllowedDuration = totalAllowedDuration;
        this.currentRecord = currentRecord;
    }

    public Race(Double totalAllowedDuration, Double currentRecord) {
        this.totalAllowedDuration = totalAllowedDuration;
        this.currentRecord = currentRecord;
    }

    public double getTotalAllowedDuration() {
        return totalAllowedDuration;
    }

    public double getCurrentRecord() {
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

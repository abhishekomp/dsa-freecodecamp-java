package org.example.puzzles.aoc2023._05dec;

public class MappingRule {
    private final long srcStart;
    private final long destStart;
    private final long range;

    public MappingRule(long destStart, long srcStart, long range) {
        this.destStart = destStart;
        this.srcStart = srcStart;
        this.range = range;
    }

    public long getSrcStart() {
        return srcStart;
    }

    public long getDestStart() {
        return destStart;
    }

    public long getRange() {
        return range;
    }

    @Override
    public String toString() {
        return "MappingRule{" +
                "destStart=" + destStart +
                ", srcStart=" + srcStart +
                ", range=" + range +
                '}';
    }
}

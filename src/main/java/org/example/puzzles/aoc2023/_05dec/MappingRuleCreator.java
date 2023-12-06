package org.example.puzzles.aoc2023._05dec;

public class MappingRuleCreator {
    public MappingRule createMappingRule(String ruleString){
        String[] split = ruleString.split("\\s+");
        long destStart = Long.parseLong(split[0].trim());
        long srcStart = Long.parseLong(split[1].trim());
        long range = Long.parseLong(split[2].trim());
        return new MappingRule(destStart, srcStart, range);
    }
}

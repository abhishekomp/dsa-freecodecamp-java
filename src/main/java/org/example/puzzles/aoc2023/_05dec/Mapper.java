package org.example.puzzles.aoc2023._05dec;

import java.util.List;

public class Mapper implements MapperInterface {
    private final String mapperName;
    private final List<MappingRule> rules;

    public Mapper(String mapperName, List<MappingRule> rules) {
        this.mapperName = mapperName;
        this.rules = rules;
    }

    public String getMapperName() {
        return mapperName;
    }

    @Override
    public long performMapping(long source) {
        long returnValue = source;
        for(MappingRule rule : rules){
            if(rule.getSrcStart() <= source && source < rule.getSrcStart() + rule.getRange()){
                returnValue = rule.getDestStart() + (source - rule.getSrcStart());
                break;
            }
        }
        return returnValue;
    }

    @Override
    public String toString() {
        return "Mapper{" +
                "mapperName='" + mapperName + '\'' +
                ", rules=" + rules +
                '}';
    }
}

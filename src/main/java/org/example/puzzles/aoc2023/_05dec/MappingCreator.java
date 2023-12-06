package org.example.puzzles.aoc2023._05dec;

import org.example.puzzles.aoc2023.utils.ReadTextFile;

import java.util.ArrayList;
import java.util.List;

public class MappingCreator {
    public List<Mapper> createMappersFromFile(String dirName, String fileName) {
        List<Mapper> mappers = new ArrayList<>();
        List<String> lines = readFile(dirName, fileName);
        List<List<String>> mappingDefinitions = readMappingDefinitions(lines.subList(1, lines.size()));
        MappingRuleCreator mappingRuleCreator = new MappingRuleCreator();
        for(List<String> mappingDefinition: mappingDefinitions){
            List<MappingRule> mappingRules = new ArrayList<>();
            for(int i = 1; i < mappingDefinition.size(); i++){  //It starts reading from index 1 as index 0 corresponds to the line ("seed-to-soil map:") in the implementation.
                mappingRules.add(mappingRuleCreator.createMappingRule(mappingDefinition.get(i)));
            }
            mappers.add(new Mapper(mappingDefinition.get(0), mappingRules));
        }
        return mappers;
    }

    /*
    Mapping Definition is:
    seed-to-soil map:
    50 98 2
    52 50 48
     */
    public List<List<String>> readMappingDefinitions(List<String> lines){
        List<List<String>> mappingDefinitions = new ArrayList<>();
        List<String> mappingStrings = new ArrayList<>();
        for(int i = 0; i < lines.size(); i++){
            String line = lines.get(i);
            if(line.contains("map")){
                if(mappingStrings.size() > 0) {
                    mappingDefinitions.add(mappingStrings);
                    mappingStrings = new ArrayList<>();
                }
            }
            mappingStrings.add(line);
            if(i == lines.size() - 1){
                mappingDefinitions.add(mappingStrings);
            }
        }
        return mappingDefinitions;
    }

    List<String> readFile(String dirName, String fileName) {
        ReadTextFile readTextFile = new ReadTextFile();
        return readTextFile.readTextFileFromResources(dirName, fileName);
    }
}

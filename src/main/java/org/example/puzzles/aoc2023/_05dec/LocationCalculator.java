package org.example.puzzles.aoc2023._05dec;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * Class exposed to Client
 * Client invokes the method calculateLowestLocation to get the lowest location by providing the directory name and file name (the almanac)
 */
public class LocationCalculator {
    public long calculateLowestLocation(String dirName, String fileName){
        // Fetch the seed numbers from the file
        SeedNumberFetcher seedNumberFetcher = new SeedNumberFetcher();
        List<Long> seedNumbers = seedNumberFetcher.fetchSeedNumbers(dirName, fileName);

        // Create different mappers using the input file
        MappingCreator mappingCreator = new MappingCreator();
        List<Mapper> mappers = mappingCreator.createMappersFromFile(dirName, fileName);
//        Map<String, Mapper> mapperMap = mappers.stream()
//                .collect(toMap(Mapper::getMapperName, mapper -> mapper, (val , val2) -> val, LinkedHashMap::new));
        Map<Long, Long> seedToLocationMap = new HashMap<>();
        long mappedValue = 0;
        for(Long seed : seedNumbers){
            mappedValue = seed;
            for(Mapper mapper : mappers){
                mappedValue = mapper.performMapping(mappedValue);
            }
            seedToLocationMap.put(seed, mappedValue);
            System.out.println("Seed " + seed + " maps to " + mappedValue);
        }
        LinkedHashMap<Long, Long> sortedSeedLocationMap = seedToLocationMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
        Map.Entry<Long, Long> firstEntry = sortedSeedLocationMap.entrySet().stream()
                .findFirst()
                .orElse(new AbstractMap.SimpleEntry<>(0L, 0L));
        //System.out.println(first.getValue());
        return firstEntry.getValue();
    }


}

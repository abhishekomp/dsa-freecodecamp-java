package org.example.puzzles.aoc2023._05dec;

import java.util.*;

import static java.util.stream.Collectors.toMap;

/**
 * Class exposed to Client
 * Client invokes the method calculateLowestLocation to get the lowest location by providing the directory name and file name (the almanac)
 */
public class LocationCalculator {
    public long calculateLowestLocation(String dirName, String fileName){
        // Fetch the seed numbers from the file
        SeedNumberFetcher seedNumberFetcher = new SeedNumberFetcher(dirName, fileName);
        Map<Long, Long> seedNumberMap = seedNumberFetcher.getSeedNumberMap();

        // Create different mappers using the input file
        MappingCreator mappingCreator = new MappingCreator();
        List<Mapper> mappers = mappingCreator.createMappersFromFile(dirName, fileName);
//        Map<String, Mapper> mapperMap = mappers.stream()
//                .collect(toMap(Mapper::getMapperName, mapper -> mapper, (val , val2) -> val, LinkedHashMap::new));
        Map<Long, Long> seedToLocationMap = new HashMap<>();
        List<Long> locationList = new ArrayList<>();
        long mappedValue = 0;
        for(Map.Entry<Long, Long> seedNumberStartEndEntry : seedNumberMap.entrySet()){
          for(long i = seedNumberStartEndEntry.getKey(); i <= seedNumberStartEndEntry.getValue(); i++){
              mappedValue = i;
              for(Mapper mapper : mappers) {
                  mappedValue = mapper.performMapping(i);
              }
              //seedToLocationMap.put(i, mappedValue);
              locationList.add(mappedValue);
          }
        }
        //System.out.println("Seed " + seed + " maps to " + mappedValue);
        locationList.sort(Comparator.naturalOrder());
//        LinkedHashMap<Long, Long> sortedSeedLocationMap = seedToLocationMap.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue())
//                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
//        Map.Entry<Long, Long> firstEntry = sortedSeedLocationMap.entrySet().stream()
//                .findFirst()
//                .orElse(new AbstractMap.SimpleEntry<>(0L, 0L));
        //System.out.println(first.getValue());
        //return firstEntry.getValue();
        return locationList.get(0);
    }
}

package org.example.puzzles.aoc2023._05dec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MappingCreatorTest {
    MappingCreator mappingCreator;

    @BeforeEach
    void setUp() {
        mappingCreator = new MappingCreator();
    }

    @Test
    void test_read_File_for_mapping() {
        List<String> lines = mappingCreator.readFile("day5", "Day5Sample.txt");
        System.out.println(lines);
    }

    @Test
    void test_extract_mapping_definitions_from_file(){
        /*
        Example of a single mapping definition:
        seed-to-soil map:
        50 98 2
        52 50 48
         */
        List<List<String>> mappingDefinitions = mappingCreator.readMappingDefinitions(List.of("seed-to-soil map:", "50 98 2", "52 50 48")); //this is 1 mapping definition. This method can take multiple lines and create multiple mapping defintions.
        mappingDefinitions.forEach(System.out::println);
    }

    @Test
    void test_extract_multiple_mapping_definitions_from_file(){
        /*
        Example of a single mapping definition:
        seed-to-soil map:
        50 98 2
        52 50 48
         */
//        List<String> mappingDefinition1 = List.of("seed-to-soil map:", "50 98 2", "52 50 48");
//        List<String> mappingDefinition2 = List.of("soil-to-fertilizer map:", "0 15 37", "37 52 2", "39 0 15");
        List<List<String>> mappingDefinitions = mappingCreator.readMappingDefinitions(List.of(
                "seed-to-soil map:", "50 98 2", "52 50 48",
                "soil-to-fertilizer map:", "0 15 37", "37 52 2", "39 0 15"
        )); //this is 1 mapping definition. This method can take multiple lines and create multiple mapping defintions.
        mappingDefinitions.forEach(System.out::println);
    }

    @Test
    void createMapperFromFile() {
        List<Mapper> mappers = mappingCreator.createMappersFromFile("day5", "Day5Sample.txt");
        mappers.forEach(System.out::println);
    }

    @Test
    void createMapperFromFile_and_test_the_mapping_for_seed_to_soil() {
        List<Mapper> mappers = mappingCreator.createMappersFromFile("day5", "Day5Sample.txt");
        System.out.println("Total number of mappers: " + mappers.size());
        mappers.forEach(System.out::println);
        long mappedValue = mappers.get(0).performMapping(79);
        System.out.println(mappedValue);
    }


}
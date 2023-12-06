package org.example.puzzles.aoc2023._05dec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MappingRuleCreatorTest {

    MappingRuleCreator mappingRuleCreator;

    @BeforeEach
    void setUp() {
        mappingRuleCreator = new MappingRuleCreator();
    }

    @Test
    void createMappingRule() {
        MappingRule seedToSoilMappingRule = mappingRuleCreator.createMappingRule("50 98 2");
        MappingRule seedToSoilMappingRule2 = mappingRuleCreator.createMappingRule("52 50 48");
        System.out.println(seedToSoilMappingRule);
        System.out.println(seedToSoilMappingRule2);
    }
}
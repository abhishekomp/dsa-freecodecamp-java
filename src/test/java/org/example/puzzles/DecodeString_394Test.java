package org.example.puzzles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Abhishek
 * @since : 2024-01-17, Wednesday
 **/
class DecodeString_394Test {

    DecodeString_394 decodeString_394;

    @BeforeEach
    void setUp() {
        decodeString_394 = new DecodeString_394();
    }

    @Test
    void decodeString() {
        String input = "3[a]2[bc]";
        System.out.println(decodeString_394.decodeString(input));
        assertEquals("aaabcbc",decodeString_394.decodeString(input));
    }
    @Test
    void decodeString_2() {
        String input = "3[a2[c]]";
        System.out.println(decodeString_394.decodeString(input));
        assertEquals("accaccacc",decodeString_394.decodeString(input));
    }
    @Test
    void decodeString_3() {
        String input = "2[abc]3[cd]ef";
        System.out.println(decodeString_394.decodeString(input));
        assertEquals("abcabccdcdcdef",decodeString_394.decodeString(input));
    }

}
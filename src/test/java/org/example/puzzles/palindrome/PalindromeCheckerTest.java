package org.example.puzzles.palindrome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    PalindromeChecker palindromeChecker;

    @BeforeEach
    void setUp() {
        palindromeChecker = new PalindromeChecker();
    }

    @Test
    void isStringAPalindrome() {
//        boolean isPalindrome = palindromeChecker.isStringAPalindrome("abba");
//        System.out.println(isPalindrome);
//        isPalindrome = palindromeChecker.isStringAPalindrome("abcba");
//        System.out.println(isPalindrome);
        assertTrue(palindromeChecker.isStringAPalindrome("abba"));
        assertTrue(palindromeChecker.isStringAPalindrome("abcba"));
        assertFalse(palindromeChecker.isStringAPalindrome("eagle"));
        assertTrue(palindromeChecker.isStringAPalindrome("rotator"));
        assertTrue(palindromeChecker.isStringAPalindrome("rotator", 2, 4));
        assertFalse(palindromeChecker.isStringAPalindrome("rotatxor", 2, 5));
    }

    @Test
    void isValidPalindrome() {
        assertTrue(palindromeChecker.isValidPalindrome("rotatxor"));
        assertTrue(palindromeChecker.isValidPalindrome("rotator"));
        assertTrue(palindromeChecker.isValidPalindrome("roptator"));
        assertFalse(palindromeChecker.isValidPalindrome("ropdtator"));
    }
}
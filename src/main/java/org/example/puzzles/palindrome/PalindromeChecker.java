package org.example.puzzles.palindrome;

public class PalindromeChecker {
    public boolean isStringAPalindrome(String input){
        return isStringAPalindrome(input, 0, input.length() - 1);
    }

    /**
     * This method check a part of the string and verifies if it is a palindrome
     * @param input the given string
     * @param leftIndex left index from where to start checking
     * @param rightIndex right index from where to start checking
     * @return true if yes else false
     */
    public boolean isStringAPalindrome(String input, int leftIndex, int rightIndex){
        //int strLen = input.length();
        int startPointer = leftIndex;
        int endPointer = rightIndex;
        while(startPointer <  endPointer){
            char leftChar = input.charAt(startPointer);
            char rightChar = input.charAt(endPointer);
            if(leftChar != rightChar){
                return false;
            }
            startPointer++;
            endPointer--;
        }
        return true;
    }

    /**
     * Checks if by removing just 1 char, the resultant string is a palindrome or not.
     * The string may already be a palindrome without removing any character.
     * @param input the given string
     * @return true if it is palindrome else false
     */
    public boolean isValidPalindrome(String input){
        int strLen = input.length();
        int startPointer = 0;
        int endPointer = strLen - 1;
        while(startPointer <  endPointer){
            char leftChar = input.charAt(startPointer);
            char rightChar = input.charAt(endPointer);
            if(leftChar == rightChar){
                startPointer++;
                endPointer--;
            } else {
                return isStringAPalindrome(input, startPointer + 1, endPointer)
                        || isStringAPalindrome(input, startPointer, endPointer - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        System.out.println(palindromeChecker.isStringAPalindrome("rotator"));   //True
        System.out.println(palindromeChecker.isStringAPalindrome("people"));   //False
    }
}

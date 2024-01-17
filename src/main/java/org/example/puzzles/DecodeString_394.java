package org.example.puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author  : Abhishek
 * @since   : 2024-01-17, Wednesday
 **/
public class DecodeString_394 {
    public String decodeString(String input){
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        String repeat = "";
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(Character.isDigit(c)){
                numberStack.push(Integer.parseInt(String.valueOf(c)));
            } else if (c != ']') {
                charStack.push(String.valueOf(c));
            } else {
                StringBuilder stringToWorkOn = new StringBuilder();
                //processOpeningBracket();
                String pop = charStack.pop();
                while(!pop.equals("[")){
                    stringToWorkOn.append(pop);
                    pop = charStack.pop();
                }
                //System.out.println(stringToWorkOn.reverse());
                Integer repeatCount = numberStack.pop();
                repeat = String.valueOf(stringToWorkOn.reverse()).repeat(Math.max(0, repeatCount));
                charStack.push(repeat);
            }

        }
        //System.out.println("Final stack");
        List<String> finalStrings = new ArrayList<>();
        while(!charStack.isEmpty()){
            //System.out.println(charStack.pop());
            finalStrings.add(charStack.pop());
        }
        //System.out.println(finalStrings);
        Collections.reverse(finalStrings);
        return String.join("", finalStrings);
    }

    public static void main(String[] args) {
        DecodeString_394 program = new DecodeString_394();
        //String decodeString = program.decodeString("3[a]2[bc]");    //aaabcbc
        //String decodeString = program.decodeString("3[a2[c]]");    //accaccacc
        String decodeString = program.decodeString("2[abc]3[cd]ef");    //accaccacc
        System.out.println(decodeString);
    }

//    public String decodeString(String input){
//        Stack<Integer> numberStack = new Stack<>();
//        Stack<Character> charStack = new Stack<>();
//        for(int i = 0; i < input.length(); i++){
//            char c = input.charAt(i);
//            if(c == ']'){
//                StringBuilder stringToWorkOn = new StringBuilder();
//                //processOpeningBracket();
//                Character pop;
//                while((pop = charStack.pop()) != '['){
//                    stringToWorkOn.append(pop);
//                }
//                Integer repeatCount = numberStack.pop();
//                StringBuilder processedStringToPush = new StringBuilder();
//                processedStringToPush.append(String.valueOf(stringToWorkOn).repeat(Math.max(0, repeatCount)));
//                charStack.push(processedStringToPush);
//            }
//            if(Character.isDigit(c)){
//                numberStack.push(Integer.parseInt(String.valueOf(c)));
//            } else {
//                charStack.push(c);
//            }
//        }
//    }
}

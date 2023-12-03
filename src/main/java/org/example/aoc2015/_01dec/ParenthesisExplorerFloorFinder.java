package org.example.aoc2015._01dec;

public class ParenthesisExplorerFloorFinder {
    public int calculateFloor(String input) {
        int finalFloor = 0;
        for (int i = 0; i < input.length(); i++) {
            //System.out.println("char is " + input.charAt(i));
            if(input.charAt(i) == '('){
                finalFloor++;
            } else if (input.charAt(i) == ')') {
                finalFloor--;
            }
        }
        return finalFloor;
    }

    public static void main(String[] args) {
        ParenthesisExplorerFloorFinder program = new ParenthesisExplorerFloorFinder();
        int finalFloor = program.calculateFloor("(())");
        System.out.println(finalFloor);
    }
}

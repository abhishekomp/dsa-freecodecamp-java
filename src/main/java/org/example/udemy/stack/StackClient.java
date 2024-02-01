package org.example.udemy.stack;

public class StackClient {
    public static void main(String[] args) {
        Stack stack = new Stack(1);
        stack.push(2);
        stack.printStack();
        System.out.println("Invoking pop on stack object. \nPopped item: \n" + stack.pop().value);
        System.out.println("Printing Stack again: ");
        stack.printStack();
    }
}

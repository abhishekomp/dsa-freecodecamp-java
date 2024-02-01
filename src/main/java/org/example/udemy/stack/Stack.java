package org.example.udemy.stack;

public class Stack {

    private Node top;
    private int height;

    public Stack(int value){
        top = new Node(value);
        height = 1;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
            next = null;
        }
    }

    public void push(int value){
        Node node = new Node(value);
        if(top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
        height++;
    }

    public Node pop(){
        Node temp;
        if(top == null) {
            return null;
        }
        temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getTop() {
        if (top == null) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }

}

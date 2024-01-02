package org.example.udemy.doublylinkedlist;

import java.util.ArrayList;
import java.util.List;

public class MyDoublyLinkedListBasic {
    Node head;
    Node tail;
    int length;

    public MyDoublyLinkedListBasic(int data){
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    /**
     * Appends a new node to the list
     * @param data the node data
     */
    public void append(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;

        }
        tail = newNode;
        length++;
    }

    public String printLinkedList() {
        Node temp = head;
        List<String> strings = new ArrayList<>();
        while(temp != null){
            strings.add(""+temp.data);
            temp = temp.next;
        }
        System.out.print("\nLinked List:");
        //System.out.println(String.join("->", strings));
        return String.join("->", strings);
    }

    @Override
    public String toString() {
        return printLinkedList();
    }

    class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public void printHead(){
        System.out.println("Head: " + head.data);
    }

    public void printTail(){
        System.out.println("Tail: " + tail.data);
    }

    public void printLength(){
        System.out.println("Length: " + length);
    }

    public Node getHead(){
        return head;
    }

    public Node getTail(){
        return tail;
    }

    public int getLength(){
        return length;
    }
}

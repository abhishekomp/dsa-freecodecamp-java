package org.example.udemy.doublylinkedlist;

import java.util.ArrayList;
import java.util.List;

public class MyDoublyLinkedList {
    Node head;
    Node tail;
    int length;

    public MyDoublyLinkedList(int data){
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
        length = 1;
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


    /**
     * Removes the last node (tail) from the list
     * @return the removed node
     */
    @Deprecated
    public Node removeLast_deprecated(){
        if(length == 0){
            return null;
        }
        Node lastNode = tail;
        tail = tail.prev;
        tail.next = null;
        lastNode.prev = null;
        length--;
        // If the length after decreasing becomes 0 then we need to set head and tail to null
        if(length == 0){
            head = null;
            tail = null;
        }
        return lastNode;
    }

    /**
     * Removes the last node (tail) from the list
     * @return the removed node
     */
    public Node removeLast() {
        if(length == 0) return null;
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    /**
     * Prepends a new node to the list
     * @param data the node's data
     */
    public void prepend(int data){
        Node newNode = new Node(data);
        if(length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public boolean clear(){
        head = null;
        tail = null;
        length = 0;
        return true;
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

package org.example.singlylinkedlist;

public class MySinglyLinkedList {

    private final Node head;
    private final Node tail;
    private final int length;

    public int getHead() {
        return head.value;
    }

    public int getTail() {
        return tail.value;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    class Node{
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    public MySinglyLinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }
}

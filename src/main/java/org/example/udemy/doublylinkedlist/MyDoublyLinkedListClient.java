package org.example.udemy.doublylinkedlist;

public class MyDoublyLinkedListClient {
    public static void main(String[] args) {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(4);
        System.out.println(myDoublyLinkedList);
        myDoublyLinkedList.printHead();
        myDoublyLinkedList.printTail();
        myDoublyLinkedList.printLength();
    }
}

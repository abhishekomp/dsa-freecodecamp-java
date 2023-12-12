package org.example.singlylinkedlist;

public class ClientForSinglyLinkedList {

    public static void main(String[] args) {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        System.out.println(mySinglyLinkedList.getHead());
        System.out.println(mySinglyLinkedList.getTail());
        System.out.println(mySinglyLinkedList.getLength());

        System.out.println("\nLinked List:");
        mySinglyLinkedList.printList();
    }
}

package org.example.singlylinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySinglyLinkedListTest {

    @Test
    void getHead() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        assertEquals(4, mySinglyLinkedList.getHead());
    }

    @Test
    void getTail() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        assertEquals(4, mySinglyLinkedList.getTail());
    }

    @Test
    void getLength() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        assertEquals(1, mySinglyLinkedList.getLength());
    }
}
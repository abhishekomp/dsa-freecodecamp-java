package org.example.udemy.doublylinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDoublyLinkedListTest {

    @Test
    void append() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        assertEquals(1, myDoublyLinkedList.getHead().data);
        assertEquals(2, myDoublyLinkedList.getTail().data);
        assertEquals(1, myDoublyLinkedList.getTail().prev.data);
        assertEquals(2, myDoublyLinkedList.getLength());
        System.out.println(myDoublyLinkedList.printLinkedList());
    }

    @Test
    void append_on_empty_list() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.clear();
        assertNull(myDoublyLinkedList.getHead());
        assertNull(myDoublyLinkedList.getTail());
        assertEquals(0, myDoublyLinkedList.getLength());
    }
}
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

    @Test
    void removeLast() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        assertEquals(1, myDoublyLinkedList.removeLast().data);
        assertNull(myDoublyLinkedList.getHead());
        assertNull(myDoublyLinkedList.getTail());
        assertEquals(0, myDoublyLinkedList.getLength());
    }

    @Test
    void removeLast_2() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        assertEquals(2, myDoublyLinkedList.removeLast().data);
        assertEquals(1, myDoublyLinkedList.getHead().data);
        assertEquals(1, myDoublyLinkedList.getTail().data);
        assertEquals(1, myDoublyLinkedList.getLength());
        System.out.println(myDoublyLinkedList.printLinkedList());
    }

    @Test
    void removeLast_on_empty_list() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.clear();
        assertNull(myDoublyLinkedList.removeLast());
        assertNull(myDoublyLinkedList.getHead());
        assertNull(myDoublyLinkedList.getTail());
        assertEquals(0, myDoublyLinkedList.getLength());
        System.out.println(myDoublyLinkedList.printLinkedList());
    }
}
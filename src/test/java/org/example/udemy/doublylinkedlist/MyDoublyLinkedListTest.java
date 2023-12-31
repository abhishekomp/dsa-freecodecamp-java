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

    @Test
    void prepend() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(2);
        myDoublyLinkedList.prepend(1);
        assertEquals(1, myDoublyLinkedList.getHead().data);
        assertEquals(2, myDoublyLinkedList.getTail().data);
        assertEquals(2, myDoublyLinkedList.getLength());
        assertEquals(2, myDoublyLinkedList.getHead().next.data);
        assertEquals(1, myDoublyLinkedList.getTail().prev.data);
        assertNull(myDoublyLinkedList.getHead().prev);
    }

    @Test
    void removeFirst() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(2);
        assertEquals(2, myDoublyLinkedList.removeFirst().data);
        assertEquals(0, myDoublyLinkedList.getLength());
        assertNull(myDoublyLinkedList.getHead());
        assertNull(myDoublyLinkedList.getTail());
    }

    @Test
    void removeFirst_on_empty_list() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(2);
        myDoublyLinkedList.clear();
        assertNull(myDoublyLinkedList.removeFirst());
        assertEquals(0, myDoublyLinkedList.getLength());
        assertNull(myDoublyLinkedList.getHead());
        assertNull(myDoublyLinkedList.getTail());
    }

    @Test
    void removeFirst_2() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(4);
        myDoublyLinkedList.append(5);
        assertEquals(5, myDoublyLinkedList.getLength());
        assertEquals(1, myDoublyLinkedList.removeFirst().data);
        assertEquals(4, myDoublyLinkedList.getLength());
        assertEquals(2, myDoublyLinkedList.getHead().data);
        assertNull(myDoublyLinkedList.getHead().prev);
        assertEquals(5, myDoublyLinkedList.getTail().data);
    }

    @Test
    void get() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(4);
        myDoublyLinkedList.append(5);
        assertEquals(5, myDoublyLinkedList.getLength());
        assertEquals(2, myDoublyLinkedList.get(1).data);
        assertNull(myDoublyLinkedList.get(-1));
    }

    @Test
    void set() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(4);
        myDoublyLinkedList.append(5);
        assertTrue(myDoublyLinkedList.set(1, 10));
        assertEquals(10, myDoublyLinkedList.get(1).data);
        assertFalse(myDoublyLinkedList.set(10, 10));
        System.out.println(myDoublyLinkedList.printLinkedList());
        assertEquals("1->10->3->4->5", myDoublyLinkedList.toString());
    }
}
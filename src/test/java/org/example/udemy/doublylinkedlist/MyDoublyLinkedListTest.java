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

    @Test
    void insertAt() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(4);
        myDoublyLinkedList.append(5);
        assertFalse(myDoublyLinkedList.insertAt(-1, 10));
        assertFalse(myDoublyLinkedList.insertAt(1000, 10));
        assertFalse(myDoublyLinkedList.insertAt(6, 10));
        assertTrue(myDoublyLinkedList.insertAt(0, 100));
        assertTrue(myDoublyLinkedList.insertAt(6, 200));
        assertEquals(100, myDoublyLinkedList.getHead().data);
        assertEquals(200, myDoublyLinkedList.getTail().data);
        assertEquals(7, myDoublyLinkedList.getLength());
        assertEquals("100->1->2->3->4->5->200", myDoublyLinkedList.toString());
    }

    @Test
    void remove() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(4);
        myDoublyLinkedList.append(5);
        assertNull(myDoublyLinkedList.remove(-1));
        assertNull(myDoublyLinkedList.remove(5));
        assertNull(myDoublyLinkedList.remove(10));
        assertEquals(1, myDoublyLinkedList.remove(0).data);
        assertEquals(5, myDoublyLinkedList.remove(3).data);
        assertEquals(3, myDoublyLinkedList.remove(1).data);
        assertEquals(2, myDoublyLinkedList.getLength());
        assertEquals(2, myDoublyLinkedList.getHead().data);
        assertEquals(4, myDoublyLinkedList.getTail().data);
    }

    @Test
    void swapFirstLast() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(4);
        myDoublyLinkedList.append(5);
        assertEquals(1, myDoublyLinkedList.getHead().data);
        assertEquals(5, myDoublyLinkedList.getTail().data);
        myDoublyLinkedList.swapFirstLast();
        assertEquals(5, myDoublyLinkedList.getHead().data);
        assertEquals(1, myDoublyLinkedList.getTail().data);
    }

    @Test
    void swapFirstLast_2() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        assertEquals(1, myDoublyLinkedList.getHead().data);
        assertEquals(2, myDoublyLinkedList.getTail().data);
        myDoublyLinkedList.swapFirstLast();
        assertEquals(2, myDoublyLinkedList.getHead().data);
        assertEquals(1, myDoublyLinkedList.getTail().data);
    }

    @Test
    void swapFirstLast_3() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        assertEquals(1, myDoublyLinkedList.getHead().data);
        myDoublyLinkedList.swapFirstLast();
        assertEquals(1, myDoublyLinkedList.getHead().data);
        assertEquals(1, myDoublyLinkedList.getTail().data);
    }

    @Test
    void reverse() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        System.out.println(myDoublyLinkedList.printLinkedList());
        assertEquals("1->2", myDoublyLinkedList.printLinkedList());
        assertEquals(1, myDoublyLinkedList.getHead().data);
        assertNull(myDoublyLinkedList.getHead().prev);
        assertNull(myDoublyLinkedList.getTail().next);
        assertEquals(2, myDoublyLinkedList.getTail().data);

        myDoublyLinkedList.reverse();
        System.out.println(myDoublyLinkedList.printLinkedList());
        assertEquals("2->1", myDoublyLinkedList.printLinkedList());
        assertEquals(2, myDoublyLinkedList.getHead().data);
        assertNull(myDoublyLinkedList.getHead().prev);
        assertNull(myDoublyLinkedList.getTail().next);
        assertEquals(1, myDoublyLinkedList.getTail().data);
    }

    @Test
    void reverse_2() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(4);
        myDoublyLinkedList.append(5);
        System.out.println(myDoublyLinkedList.printLinkedList());
        assertEquals("1->2->3->4->5", myDoublyLinkedList.printLinkedList());

        myDoublyLinkedList.reverse();
        System.out.println(myDoublyLinkedList.printLinkedList());
        assertEquals("5->4->3->2->1", myDoublyLinkedList.printLinkedList());
        assertEquals(5, myDoublyLinkedList.getHead().data);
        assertNull(myDoublyLinkedList.getHead().prev);
        assertNull(myDoublyLinkedList.getTail().next);
        assertEquals(1, myDoublyLinkedList.getTail().data);
    }

    @Test
    void isPalindrome() {
        // With slow and fast pointer method of finding the mid of the list,
        // fast.next becomes null when list has got odd number of elements while
        // fast becomes null when the list has got even number of elements.
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(8);
        myDoublyLinkedList.append(1);
        myDoublyLinkedList.append(6);
        System.out.println(myDoublyLinkedList.isPalindrome());
    }

    @Test
    void isPalindrome_even_number_of_nodes() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.append(1);
        System.out.println(myDoublyLinkedList.isPalindrome());
    }

    @Test
    void isPalindrome_odd_number_of_nodes() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.append(1);
        System.out.println(myDoublyLinkedList.isPalindrome());
    }

    @Test
    void testReverse_by_giving_the_node() {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(1);
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(8);
        MyDoublyLinkedList.Node reverse = myDoublyLinkedList.reverse(myDoublyLinkedList.get(2));
        System.out.println(reverse.data);
        System.out.println(reverse.next.data);
    }
}
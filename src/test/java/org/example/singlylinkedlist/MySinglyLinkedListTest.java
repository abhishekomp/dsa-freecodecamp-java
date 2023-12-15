package org.example.singlylinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void test_append() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        assertEquals(8, mySinglyLinkedList.append(8));
        assertEquals(2, mySinglyLinkedList.getLength());
    }

    @Test
    void test_removeLast() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        assertEquals(8, mySinglyLinkedList.append(8));
        assertEquals(2, mySinglyLinkedList.getLength());
        assertEquals(8, mySinglyLinkedList.removeLast().getValue());
        assertEquals(4, mySinglyLinkedList.removeLast().getValue());
        assertThrows(RuntimeException.class, mySinglyLinkedList::removeLast);
    }

    @Test
    void test_prepend() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        assertEquals(4, mySinglyLinkedList.removeLast().getValue());
        mySinglyLinkedList.prepend(10);
        assertEquals(10, mySinglyLinkedList.getHead());
    }

    @Test
    void test_prepend_to_an_empty_list() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        assertEquals(4, mySinglyLinkedList.removeLast().getValue());
        mySinglyLinkedList.prepend(10);
        assertEquals(10, mySinglyLinkedList.getHead());
        assertEquals(10, mySinglyLinkedList.getTail());
        assertEquals(1, mySinglyLinkedList.getLength());
    }

    @Test
    void test_prepend_to_existing_list() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        mySinglyLinkedList.prepend(10);
        assertEquals(10, mySinglyLinkedList.getHead());
        assertEquals(4, mySinglyLinkedList.getTail());
        assertEquals(2, mySinglyLinkedList.getLength());
    }

    @Test
    void test_removeFirst_on_existing_list() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        assertEquals(4, mySinglyLinkedList.removeFirst().getValue());
    }

    @Test
    void test_removeFirst_on_empty_list() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        mySinglyLinkedList.removeLast();
        assertThrows(RuntimeException.class, mySinglyLinkedList::removeFirst);
    }

    @Test
    void test_removeFirst_on_existing_list_with_2_items() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        mySinglyLinkedList.append(8);
        assertEquals(4, mySinglyLinkedList.removeFirst().getValue());
        assertEquals(8, mySinglyLinkedList.getHead());
        assertEquals(1, mySinglyLinkedList.getLength());
    }


    @Test
    void test_get_method_should_return_correct_element() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);
        assertEquals(10, mySinglyLinkedList.get(0).getValue());
        assertEquals(20, mySinglyLinkedList.get(1).getValue());
        assertNull(mySinglyLinkedList.get(2));
    }

    @Test
    void test_set_method_should_update_the_first_and_last_element() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);

        assertTrue(mySinglyLinkedList.set(100, 0));
        assertEquals(100, mySinglyLinkedList.getHead());
        assertEquals(20, mySinglyLinkedList.getTail());
        assertEquals(2, mySinglyLinkedList.getLength());

        assertTrue(mySinglyLinkedList.set(200, 1));
        assertEquals(100, mySinglyLinkedList.getHead());
        assertEquals(200, mySinglyLinkedList.getTail());
        assertEquals(2, mySinglyLinkedList.getLength());
    }

    @Test
    void test_set_method_should_append_to_the_list() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);
        mySinglyLinkedList.printList();

        assertTrue(mySinglyLinkedList.set(100, 2));
        mySinglyLinkedList.printList();
        assertEquals(10, mySinglyLinkedList.getHead());
        assertEquals(100, mySinglyLinkedList.getTail());
        assertEquals(3, mySinglyLinkedList.getLength());
    }

    @Test
    void test_insert_at_begin_and_after_the_end_should_work_for_non_empty_list() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        assertTrue(mySinglyLinkedList.insertAt(5, 0));
        assertTrue(mySinglyLinkedList.insertAt(20, 2));
        assertEquals(3, mySinglyLinkedList.getLength());
        assertEquals(5, mySinglyLinkedList.getHead());
        assertEquals(20, mySinglyLinkedList.getTail());
    }

    @Test
    void test_insert_at_begin_and_after_the_end_should_work_for_non_empty_list_2() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);
        assertTrue(mySinglyLinkedList.insertAt(5, 0));
        assertTrue(mySinglyLinkedList.insertAt(30, 3));
        assertEquals(4, mySinglyLinkedList.getLength());
        assertEquals(5, mySinglyLinkedList.getHead());
        assertEquals(30, mySinglyLinkedList.getTail());
        assertFalse(mySinglyLinkedList.insertAt(100, -1));
        assertFalse(mySinglyLinkedList.insertAt(100, 10));
    }

    @Test
    void test_insert_in_middle_should_work_for_non_empty_list_2() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);
        mySinglyLinkedList.append(30);
        mySinglyLinkedList.append(40);
        mySinglyLinkedList.append(50);
        assertTrue(mySinglyLinkedList.insertAt(25, 2));
        assertEquals(6, mySinglyLinkedList.getLength());
        assertEquals(10, mySinglyLinkedList.getHead());
        assertEquals(50, mySinglyLinkedList.getTail());
        assertEquals(25, mySinglyLinkedList.get(2).getValue());

        //2nd insert
        assertTrue(mySinglyLinkedList.insertAt(60, 6));
        assertEquals(60, mySinglyLinkedList.getTail());
        assertEquals(7, mySinglyLinkedList.getLength());
        assertEquals(60, mySinglyLinkedList.get(6).getValue());

        mySinglyLinkedList.printList();
    }

    @Test
    void test_removeAt_should_remove_and_return_the_removed_node() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);
        mySinglyLinkedList.append(30);
        mySinglyLinkedList.append(40);
        mySinglyLinkedList.append(50);

        assertEquals(5, mySinglyLinkedList.getLength());
        assertNull(mySinglyLinkedList.remove(50));
        assertNull(mySinglyLinkedList.remove(-1));

        assertEquals(10, mySinglyLinkedList.remove(0).getValue());
        assertEquals(4, mySinglyLinkedList.getLength());
        assertEquals(20, mySinglyLinkedList.getHead());
        assertEquals(50, mySinglyLinkedList.getTail());

        assertEquals(50, mySinglyLinkedList.remove(3).getValue());
        assertEquals(30, mySinglyLinkedList.remove(1).getValue());
        assertEquals(2, mySinglyLinkedList.getLength());
        assertEquals(20, mySinglyLinkedList.getHead());
        assertEquals(40, mySinglyLinkedList.getTail());

        mySinglyLinkedList.printList(); //20, 40
    }


    @Test
    void test_reverse() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);
        mySinglyLinkedList.append(30);
        mySinglyLinkedList.append(40);
        mySinglyLinkedList.append(50);

        mySinglyLinkedList.printList();

        mySinglyLinkedList.reverse();
        mySinglyLinkedList.printList();
        assertEquals(50, mySinglyLinkedList.getHead());
        assertEquals(10, mySinglyLinkedList.getTail());
    }

    @Test
    void clear() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);
        mySinglyLinkedList.append(30);
        mySinglyLinkedList.append(40);
        mySinglyLinkedList.append(50);
        assertEquals(5, mySinglyLinkedList.getLength());

        mySinglyLinkedList.clear();
        assertEquals(0, mySinglyLinkedList.getLength());
    }

    @Test
    void test_findMiddleNode_when_list_has_even_number_of_items(){
    /*
    If the list has an even number of nodes, the method should return the second middle node.
    */
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);
        mySinglyLinkedList.append(30);
        mySinglyLinkedList.append(40);

        assertEquals(30, mySinglyLinkedList.findMiddleNode().getValue());
    }

    @Test
    void test_findMiddleNode_when_list_has_two_items(){
    /*
    If the list has an even number of nodes, the method should return the second middle node.
    */
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);

        assertEquals(20, mySinglyLinkedList.findMiddleNode().getValue());
    }

    @Test
    void test_findMiddleNode_when_list_has_one_item(){
    /*
    If the list has an even number of nodes, the method should return the second middle node.
    */
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        assertEquals(10, mySinglyLinkedList.findMiddleNode().getValue());
    }

    @Test
    void test_findMiddleNode_when_list_has_odd_number_of_items(){
    /*
    If the list has an even number of nodes, the method should return the second middle node.
    */
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);
        mySinglyLinkedList.append(30);
        mySinglyLinkedList.append(40);
        mySinglyLinkedList.append(50);

        assertEquals(30, mySinglyLinkedList.findMiddleNode().getValue());
    }
}
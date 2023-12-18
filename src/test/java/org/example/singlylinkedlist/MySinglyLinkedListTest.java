package org.example.singlylinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MySinglyLinkedListTest {

    @Test
    void getHead() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        assertEquals(4, mySinglyLinkedList.getHead().getValue());
    }

    @Test
    void getHead_on_empty_list() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        mySinglyLinkedList.clear();
        assertNull(mySinglyLinkedList.getHead());
    }

    @Test
    void getTail() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        assertEquals(4, mySinglyLinkedList.getTail().getValue());
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
        assertEquals(10, mySinglyLinkedList.getHead().getValue());
    }

    @Test
    void test_prepend_to_an_empty_list() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        assertEquals(4, mySinglyLinkedList.removeLast().getValue());
        mySinglyLinkedList.prepend(10);
        assertEquals(10, mySinglyLinkedList.getHead().getValue());
        assertEquals(10, mySinglyLinkedList.getTail().getValue());
        assertEquals(1, mySinglyLinkedList.getLength());
    }

    @Test
    void test_prepend_to_existing_list() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        mySinglyLinkedList.prepend(10);
        assertEquals(10, mySinglyLinkedList.getHead().getValue());
        assertEquals(4, mySinglyLinkedList.getTail().getValue());
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
        assertEquals(8, mySinglyLinkedList.getHead().getValue());
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
        assertEquals(100, mySinglyLinkedList.getHead().getValue());
        assertEquals(20, mySinglyLinkedList.getTail().getValue());
        assertEquals(2, mySinglyLinkedList.getLength());

        assertTrue(mySinglyLinkedList.set(200, 1));
        assertEquals(100, mySinglyLinkedList.getHead().getValue());
        assertEquals(200, mySinglyLinkedList.getTail().getValue());
        assertEquals(2, mySinglyLinkedList.getLength());
    }

    @Test
    void test_set_method_should_append_to_the_list() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);
        mySinglyLinkedList.printList();

        assertTrue(mySinglyLinkedList.set(100, 2));
        mySinglyLinkedList.printList();
        assertEquals(10, mySinglyLinkedList.getHead().getValue());
        assertEquals(100, mySinglyLinkedList.getTail().getValue());
        assertEquals(3, mySinglyLinkedList.getLength());
    }

    @Test
    void test_insert_at_begin_and_after_the_end_should_work_for_non_empty_list() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        assertTrue(mySinglyLinkedList.insertAt(5, 0));
        assertTrue(mySinglyLinkedList.insertAt(20, 2));
        assertEquals(3, mySinglyLinkedList.getLength());
        assertEquals(5, mySinglyLinkedList.getHead().getValue());
        assertEquals(20, mySinglyLinkedList.getTail().getValue());
    }

    @Test
    void test_insert_at_begin_and_after_the_end_should_work_for_non_empty_list_2() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);
        assertTrue(mySinglyLinkedList.insertAt(5, 0));
        assertTrue(mySinglyLinkedList.insertAt(30, 3));
        assertEquals(4, mySinglyLinkedList.getLength());
        assertEquals(5, mySinglyLinkedList.getHead().getValue());
        assertEquals(30, mySinglyLinkedList.getTail().getValue());
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
        assertEquals(10, mySinglyLinkedList.getHead().getValue());
        assertEquals(50, mySinglyLinkedList.getTail().getValue());
        assertEquals(25, mySinglyLinkedList.get(2).getValue());

        //2nd insert
        assertTrue(mySinglyLinkedList.insertAt(60, 6));
        assertEquals(60, mySinglyLinkedList.getTail().getValue());
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
        assertEquals(20, mySinglyLinkedList.getHead().getValue());
        assertEquals(50, mySinglyLinkedList.getTail().getValue());

        assertEquals(50, mySinglyLinkedList.remove(3).getValue());
        assertEquals(30, mySinglyLinkedList.remove(1).getValue());
        assertEquals(2, mySinglyLinkedList.getLength());
        assertEquals(20, mySinglyLinkedList.getHead().getValue());
        assertEquals(40, mySinglyLinkedList.getTail().getValue());

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
        assertEquals(50, mySinglyLinkedList.getHead().getValue());
        assertEquals(10, mySinglyLinkedList.getTail().getValue());
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

    @Test
    void findKthNodeFromEnd() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);
        mySinglyLinkedList.append(30);
        mySinglyLinkedList.append(40);
        mySinglyLinkedList.append(50);
        MySinglyLinkedList.Node kthNodeFromEnd = mySinglyLinkedList.findKthNodeFromEnd(1);
        System.out.println(kthNodeFromEnd.getValue());
        assertEquals(50, kthNodeFromEnd.getValue());

    }

    @Test
    void findKthNodeFromEnd_2() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.append(20);
        //MySinglyLinkedList.Node kthNodeFromEnd = mySinglyLinkedList.findKthNodeFromEnd(1);
        //System.out.println(kthNodeFromEnd.getValue());
        assertEquals(20, mySinglyLinkedList.findKthNodeFromEnd(1).getValue());
        assertEquals(10, mySinglyLinkedList.findKthNodeFromEnd(2).getValue());
        assertNull(mySinglyLinkedList.findKthNodeFromEnd(3));
    }

    @Test
    void findKthNodeFromEnd_on_empty_list() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(10);
        mySinglyLinkedList.clear();
        assertNull(mySinglyLinkedList.getHead());
        assertNull(mySinglyLinkedList.findKthNodeFromEnd(3));
    }

    @Test
    void partitionList() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(3);
        mySinglyLinkedList.append(8);
        mySinglyLinkedList.append(5);
        mySinglyLinkedList.append(10);
        mySinglyLinkedList.append(2);
        mySinglyLinkedList.append(1);
        mySinglyLinkedList.printList();

        assertEquals("3->2->1->8->5->10", mySinglyLinkedList.partitionAndPrint(5));
    }

    @Test
    void partitionList_2() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(1);
        mySinglyLinkedList.append(4);
        mySinglyLinkedList.append(3);
        mySinglyLinkedList.append(2);
        mySinglyLinkedList.append(5);
        mySinglyLinkedList.append(2);
        mySinglyLinkedList.printList();

        assertEquals("1->2->2->4->3->5", mySinglyLinkedList.partitionAndPrint(3));
    }

    @Test
    void partitionList_3_with_empty_list() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(1);
        mySinglyLinkedList.append(4);
        mySinglyLinkedList.append(3);
        mySinglyLinkedList.append(2);
        mySinglyLinkedList.append(5);
        mySinglyLinkedList.append(2);
        mySinglyLinkedList.printList();
        mySinglyLinkedList.clear();
        assertNull(mySinglyLinkedList.getHead());

        assertEquals("", mySinglyLinkedList.partitionAndPrint(3));
    }

    @Test
    void removeDuplicates() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(1);
        mySinglyLinkedList.append(2);
        mySinglyLinkedList.append(3);
        mySinglyLinkedList.append(2);
        mySinglyLinkedList.append(4);
        mySinglyLinkedList.printList();

        MySinglyLinkedList.Node node = mySinglyLinkedList.removeDuplicates();
        String asString = mySinglyLinkedList.getLinkedListAsString(node);
        System.out.println(asString);
        assertEquals("1->2->3->4", asString);
//        mySinglyLinkedList.removeDuplicates();
//        mySinglyLinkedList.printList();
        assertEquals(4, mySinglyLinkedList.getLength());
    }

    @Test
    void removeDuplicates_2() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(1);
        mySinglyLinkedList.append(2);
        mySinglyLinkedList.printList();

        MySinglyLinkedList.Node node = mySinglyLinkedList.removeDuplicates();
        String asString = mySinglyLinkedList.getLinkedListAsString(node);
        System.out.println(asString);
        assertEquals("1->2", asString);
        assertEquals(2, mySinglyLinkedList.getLength());
    }

    @Test
    void removeDuplicates_3() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(1);
        mySinglyLinkedList.printList();

        MySinglyLinkedList.Node node = mySinglyLinkedList.removeDuplicates();
        String asString = mySinglyLinkedList.getLinkedListAsString(node);
        System.out.println(asString);
        assertEquals("1", asString);
        assertEquals(1, mySinglyLinkedList.getLength());
    }

    @Test
    void removeDuplicates_4() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(1);
        mySinglyLinkedList.append(2);
        mySinglyLinkedList.append(1);
        mySinglyLinkedList.printList();

        MySinglyLinkedList.Node node = mySinglyLinkedList.removeDuplicates();
        String asString = mySinglyLinkedList.getLinkedListAsString(node);
        System.out.println(asString);
        assertEquals("1->2", asString);
        assertEquals(2, mySinglyLinkedList.getLength());
    }

    @Test
    void binaryToDecimal() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(1);
        mySinglyLinkedList.append(0);
        mySinglyLinkedList.append(1);
        mySinglyLinkedList.printList();

        assertEquals(5, mySinglyLinkedList.binaryToDecimal());
    }
}
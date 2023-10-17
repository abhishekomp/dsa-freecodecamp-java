package org.example.linkedlist;

import java.util.Iterator;

/**
 * Last node points to null.
 * Used in List, Queue & Stack implementation.
 * Circular linked lists
 * Can model real objects like Train
 * Used in chaining in hashtable for hashing collisions.
 * Used in implementation of adjacency lists for graphs.
 * Head: The first node in the linked list.
 * Tail: The last node of the linked list.
 * Pointer: Reference to another node.
 * Node: An object containing data and pointer.
 * Singly Linked list: Node has a pointer to next node but not to the previous node.
 * Singly Linked List occupies less memory compared to Doubly linked list.
 * Doubly linked list: Can be traversed backwards.
 *
 */
public class MyDoublyLinkedList<T> implements Iterable<T>{

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        T data;
        Node<T> prev, next;
        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public int indexOf(T elem){
        return -1;
    }

    public boolean insertAtHead(T elem) {
        return false;
    }

    public boolean insertAtTail(T elem) {
        return false;
    }

    public T removeHead(){
        return null;
    }

    public T removeTail(){
        return null;
    }

    public T removeAt(int rm_index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

           private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

    }
}

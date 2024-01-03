package org.example.singlylinkedlist;

public class MySinglyLinkedListWithoutTail {
    private Node head;

    public MySinglyLinkedListWithoutTail(int data){
        this.head = new Node(data);
    }

    /**
     * Inner class representing the node of the linked list.
     */
    class Node{
        private int data;
        private Node next;

        Node(int data){
            this.data = data;
        }

        public int getData(){
            return data;
        }
    }
}

package org.example.singlylinkedlist;

import java.util.ArrayList;
import java.util.List;

public class MySinglyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public MySinglyLinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        List<String> strings = new ArrayList<>();
        while(temp != null){
            //System.out.println(temp.value);
            strings.add(""+temp.value);
            temp = temp.next;
        }
        System.out.print("\nLinked List:");
        System.out.println(String.join("->", strings));
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    /**
     * Appends the value to the list. If list is empty then it sets the value as the first element in the list.
     * @param value the value to append to the list
     * @return  the appended value
     */
    public int append(int value){
        Node newNode = new Node(value);
        //Case 1: Linked list is empty.
        if(this.length == 0){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
        return value;
    }

    /**
     * This is tricky to implement. Removes the last node from the linked list.
     *
     * @return the value of the removed node.
     */
    public Node removeLast(){
        if(length == 0){
            throw new RuntimeException("List is empty");
        }
        // if the list has only 1 element
        if(head.next == null){
            length = 0;
            Node temp = head;
            head = tail = null;
            return temp;
        }
        Node temp = head;
        Node pre = temp;
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if(length == 0){
            head = tail = null;
        }
        return temp;
    }

    /**
     * Add a new node to the beginning of the linked list.
     * @param value The value to be added at the beginning of the linked list.
     */
    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if(length == 0){
            throw new RuntimeException("Empty list");
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0){
            tail = head;
        }
        return temp;
    }

    /**
     * Get the Node at given index
     * @param index the index
     * @return the node at given index
     */
    public Node get(int index){
        if(index < 0 || index >= length){
            return  null;
        }
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Updates the value of the node at given index. If the index is next to the current tail then it will append to the list.
     * @param value the updated value
     * @param index the given index
     * @return boolean if the value was set
     */
    public boolean set(int value, int index){
        // Case 1: When the given index is out of the current list's range
        if(index < 0 || index > length){
            return false;
        }
        // Case 2: When the given index is one more than the last available index (i.e. next to the current tail)
        if(index == length){
            if(value == append(value)){
                return true;
            }
        }
        // Case 3: When the given index is available in the list
        Node temp = head;
        int i = 0;
        while(i < index){
            temp = temp.next;
            i++;
        }
        temp.value = value;
        return true;
    }

    /**
     * Inserts the value at the given index.
     * @param value the value to insert.
     * @param index the index at which the value to insert.
     * @return true if insert was successful else false.
     */
    public boolean insertAt(int value, int index){
        // if the index is out of range
        if(index < 0 || index > length) {
            return false;
        }
        // if inserting at the beginning
        if(index == 0){
            prepend(value);
            return true;
        }
        // if inserting after the current tail element
        if(index == length){
            append(value);
            return true;
        }
        // if inserting anywhere else apart from the above handled cases
        Node preNode = get(index - 1);
        Node nextNode = preNode.next;
        Node newNode = new Node(value);
        preNode.next = newNode;
        newNode.next = nextNode;
        length++;
        return true;
    }

    /**
     * Remove the node from given index
     * @param index the index of the node to be removed
     * @return the removed node
     */
    public Node remove(int index) {
        if(index < 0 || index >= length) {
            return null;
        }
        if(index == 0){
            return removeFirst();
        }
        if(index == length - 1){
            return removeLast();
        }
        Node preNode = get(index - 1);
        Node nodeToRemove = preNode.next;
        preNode.next = nodeToRemove.next;
        nodeToRemove.next = null;
        length--;
        return nodeToRemove;
    }

    /**
     * Reverses the linked list in place.
     */
    public void reverse(){
        //swap head and tail
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;
        for(int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
    public void clear(){
        head = null;
        tail = null;
        length = 0;
    }

    public Node findMiddleNode_without_using_length(){
        if(length == 0){
            return null;
        }
        if(length == 1){
            return head;
        }
        int middleIndex = length/2;
        return get(middleIndex);
    }

    /**
     * Finds the middle node of the linked list without considering the length of the linked list.
     * Also, this implementation uses the slow and fast pointer approach and has space complexity of O(1)
     * @return the middle node. For even number of elements 4/2=2 element at index 2 will be returned.
     */
    public Node findMiddleNode(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Finds kth node from the end. The last node is considered as the 1st from end.
     * Does not make use of the length variable of the linked list.
     * Does not make use of the tail node of the linked list.
     * It also considers if kth node is possible to find in the given linked list.
     * @return kth node from the end
     */
    public Node findKthNodeFromEnd(int kth){
        // Case: List may be empty, then return null
        if(head == null){
            return null;
        }
        Node fast = head;
        // Case: When kth node is not possible in the given list.
        // The last node is the 1st node from last.
        // If we want the 2nd node from last then the idea is to move the fast node to the 2nd node and then start moving slow and fast node 1 step at a time until the fast node reaches the last node.
        for(int i = 1; i <kth; i++){
            fast = fast.next;
            if(fast == null){
                return null;
            }
        }
        // Case: When kth node is possible in the given list.
        Node slow = head;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * Inner class representing the node of the linked list.
     */
    class Node{
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}

package org.example.udemy.doublylinkedlist;

import java.util.ArrayList;
import java.util.List;

public class MyDoublyLinkedList {
    Node head;
    Node tail;
    int length;

    public MyDoublyLinkedList(int data){
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    /**
     * Appends a new node to the list
     * @param data the node data
     */
    public void append(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;

        }
        tail = newNode;
        length++;
    }


    /**
     * Removes the last node (tail) from the list
     * @return the removed node
     */
    @Deprecated
    public Node removeLast_deprecated(){
        if(length == 0){
            return null;
        }
        Node lastNode = tail;
        tail = tail.prev;
        tail.next = null;
        lastNode.prev = null;
        length--;
        // If the length after decreasing becomes 0 then we need to set head and tail to null
        if(length == 0){
            head = null;
            tail = null;
        }
        return lastNode;
    }

    /**
     * Removes the last node (tail) from the list
     * @return the removed node
     */
    public Node removeLast() {
        if(length == 0) return null;
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    /**
     * Prepends a new node to the list
     * @param data the node's data
     */
    public void prepend(int data){
        Node newNode = new Node(data);
        if(length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    /**
     * Removes the first node (head) from the list
     * @return the first node
     */
    public Node removeFirst(){
        if(length == 0) return null;
        Node temp = head;
        if(length == 1){
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    /**
     * Gets the node at the specified index
     * @param index the index
     * @return the node at the index
     */
    public Node get(int index){
        if(index < 0 || index >= length) return null;
        Node temp = head;
        if(index < length/2){
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        } else {
            temp = tail;
            for(int i = length - 1; i > index; i--){
                temp = temp.prev;
            }
        }
        return temp;
    }

    /**
     * Updates the value at the specified index
     * @param index the specified index
     * @param data the data to update at the index
     * @return true if successful else false
     */
    public boolean set(int index, int data){
        Node temp = get(index);
        if(temp != null){
            temp.data = data;
            return true;
        }
        return false;
    }

    /**
     * Insert a new node at the specified index
     * @param index the specified index
     * @param data the data to insert
     * @return true if successful else false
     */
    public boolean insertAt(int index, int data){
        // We cannot insert a new node at index less than 0 or at index greater than the length.
        // At index = length we can insert a node, and it will be then the new tail.
        if(index < 0 || index > length){
            return false;
        }
        if(index == 0){
            prepend(data);
            return true;
        }
        if(index == length){
            append(data);
            return true;
        }
        Node newNode = new Node(data);
        Node before = get(index - 1);
        Node after = before.next;
        before.next = newNode;
        newNode.prev = before;
        newNode.next = after;
        after.prev = newNode;
        length++;
        return true;
    }

    /**
     * Removes the node at the specified index
     * @param index the specified index
     * @return the removed node
     */
    public Node remove(int index){
        if(index < 0 || index >= length){
            return null;
        }
        if(index == 0){
            return removeFirst();
        }
        if(index == length - 1){
            return removeLast();
        }
        Node temp = get(index);
        Node before = temp.prev;
        Node after = temp.next;
        temp.prev = null;
        temp.next = null;
        before.next = after;
        after.prev = before;
        length--;
        return temp;
    }

    public boolean clear(){
        head = null;
        tail = null;
        length = 0;
        return true;
    }

    /**
     * Swaps the value of first and last entry of the list
     */
    public void swapFirstLast(){
        if(length >= 2){
            int temp = head.data;
            head.data = tail.data;
            tail.data = temp;
        }
    }

    /**
     * Reverses the doubly linked list
     * https://stackoverflow.com/questions/11166968/reversing-a-doubly-linked-list
     */
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node p = head;
        while(p != null){
            temp = p.next;
            p.next = p.prev;
            p.prev = temp;
            p = p.next;
        }
    }

    /**
     * Given the head node, this method reverses the linked list and returns the head of the reversed list.
     * @param head the given head
     * @return head of the reversed list
     */
    public Node reverse(Node head){
        Node prev = null;
        while(head != null) {
            Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    /**
     * Checks if the linked list is a palindrome
     * @return true if yes else false
     */
    public boolean isPalindrome(){
        // Finding the mid-node
        // With the slow and fast pointer method of finding the mid of the list,
        // fast will be non-null (fast.next becomes null) when list has got odd number of elements while
        // fast becomes null when the list has got even number of elements.
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){   //when list has odd number of elements
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while(slow != null){
            if(slow.data != fast.data){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public String printLinkedList() {
        Node temp = head;
        List<String> strings = new ArrayList<>();
        while(temp != null){
            strings.add(""+temp.data);
            temp = temp.next;
        }
        //System.out.print("\nLinked List:");
        //System.out.println(String.join("->", strings));
        return String.join("->", strings);
    }

    @Override
    public String toString() {
        return printLinkedList();
    }

    class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public void printHead(){
        System.out.println("Head: " + head.data);
    }

    public void printTail(){
        System.out.println("Tail: " + tail.data);
    }

    public void printLength(){
        System.out.println("Length: " + length);
    }

    public Node getHead(){
        return head;
    }

    public Node getTail(){
        return tail;
    }

    public int getLength(){
        return length;
    }

}

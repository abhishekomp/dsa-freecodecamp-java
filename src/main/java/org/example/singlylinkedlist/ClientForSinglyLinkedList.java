package org.example.singlylinkedlist;

public class ClientForSinglyLinkedList {

    public static void main(String[] args) {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(4);
        System.out.println(mySinglyLinkedList.getHead());
        System.out.println(mySinglyLinkedList.getTail());
        System.out.println(mySinglyLinkedList.getLength());


        mySinglyLinkedList.printList();

        //append a value
        int append = mySinglyLinkedList.append(8);
        System.out.println("Appended value: " + append);
        mySinglyLinkedList.printList(); //4->8
        System.out.println("Length is now: " + mySinglyLinkedList.getLength());

        //remove last
        System.out.print("Remove last: ");
        int removeLast = mySinglyLinkedList.removeLast().getValue();
        System.out.println(removeLast);
        mySinglyLinkedList.printList();
        System.out.println("Length is now: " + mySinglyLinkedList.getLength());
    }
}

package org.example.dynamicarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDynamicArrayTest {

    MyDynamicArray myDynamicArray;

    @BeforeEach
    void setUp() {
        myDynamicArray = new MyDynamicArray();
    }

    @Test
    void test_initial_array() {
        System.out.println("Size: " + myDynamicArray.size());
        System.out.println("Capacity: " + myDynamicArray.getCapacity());
        assertEquals(0, myDynamicArray.size());
    }

    @Test
    void test_get_should_throw_IllegalArgumentException_when_index_is_negative_one() {
        int index = -1;
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> myDynamicArray.get(index));
        assertNotNull(exception);
        assertEquals("Illegal index " + index, exception.getMessage());
    }

    @Test
    void test_get_should_throw_IllegalArgumentException_when_index_is_more_than_the_size() {
        int index = 4;
        System.out.println("length = " + myDynamicArray.size());
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> myDynamicArray.get(index));
        assertNotNull(exception);
        assertEquals("Illegal index " + index, exception.getMessage());
    }

    @Test
    void test_get_should_return_element_at_specified_index() {
        int index = 1;
        myDynamicArray.add(1);
        myDynamicArray.add(2);
        assertEquals(2, myDynamicArray.get(index));
    }

    @Test
    void add() {
        myDynamicArray.add(1);
        System.out.println("Size: " + myDynamicArray.size() + ", Capacity: " + myDynamicArray.getCapacity());
        myDynamicArray.add(2);
        System.out.println("Size: " + myDynamicArray.size() + ", Capacity: " + myDynamicArray.getCapacity());
        myDynamicArray.add(3);
        System.out.println("Size: " + myDynamicArray.size() + ", Capacity: " + myDynamicArray.getCapacity());
        myDynamicArray.add(4);
        System.out.println("Size: " + myDynamicArray.size() + ", Capacity: " + myDynamicArray.getCapacity());
        myDynamicArray.add(5);
        System.out.println("Size: " + myDynamicArray.size() + ", Capacity: " + myDynamicArray.getCapacity());
        assertFalse(myDynamicArray.isEmpty());
    }

    @Test
    void removeAt() {
        MyDynamicArray myDynamicArray1 = new MyDynamicArray();
        myDynamicArray1.add(1);
        myDynamicArray1.add(2);
        myDynamicArray1.add(3);
        myDynamicArray1.add(4);
        int remove;
        remove = myDynamicArray1.removeAt(3);
        System.out.println("remove = " + remove);
        System.out.println("Size: " + myDynamicArray1.size() + ", Capacity: " + myDynamicArray1.getCapacity());

        remove = myDynamicArray1.removeAt(2);
        System.out.println("remove = " + remove);
        System.out.println("Size: " + myDynamicArray1.size() + ", Capacity: " + myDynamicArray1.getCapacity());

        remove = myDynamicArray1.removeAt(1);
        System.out.println("remove = " + remove);
        System.out.println("Size: " + myDynamicArray1.size() + ", Capacity: " + myDynamicArray1.getCapacity());
    }

    @Test
    void removeAt_should_remove_correct_element() {
        MyDynamicArray myDynamicArray1 = new MyDynamicArray();
        myDynamicArray1.add(1);
        myDynamicArray1.add(2);
        myDynamicArray1.add(3);
        myDynamicArray1.add(4);
        myDynamicArray1.add(5);
        myDynamicArray1.add(6);
        myDynamicArray1.add(7);
        myDynamicArray1.add(8);
        myDynamicArray1.add(9);
        myDynamicArray1.add(10);
        myDynamicArray1.display();
        int remove_at_index = 3;
        int remove;
        remove = myDynamicArray1.removeAt(remove_at_index);
        System.out.println("After removing element " + remove + " at index: " + remove_at_index);
        System.out.println("remove = " + remove);
        System.out.println("Size: " + myDynamicArray1.size() + ", Capacity: " + myDynamicArray1.getCapacity());
        myDynamicArray1.display();
    }

    @Test
    void display() {
        MyDynamicArray myDynamicArray1 = new MyDynamicArray();
        myDynamicArray1.add(1);
        myDynamicArray1.add(2);
        myDynamicArray1.add(3);
        myDynamicArray1.add(4);
        myDynamicArray1.add(5);
        myDynamicArray1.add(6);
        myDynamicArray1.add(7);
        myDynamicArray1.add(8);
        myDynamicArray1.add(9);
        myDynamicArray1.add(10);
        myDynamicArray1.display();
    }

    @Test
    void size() {
        System.out.println("Size: " + myDynamicArray.size());
        System.out.println("Capacity: " + myDynamicArray.getCapacity());
        assertEquals(0, myDynamicArray.size());
        assertEquals(myDynamicArray.getInitialCapacity(), myDynamicArray.getCapacity());
    }

    @Test
    void isEmpty_should_be_true() {
        assertTrue(myDynamicArray.isEmpty());
    }

    @Test
    void isEmpty_should_return_false_when_elements_are_present() {
        myDynamicArray.add(1);
        assertFalse(myDynamicArray.isEmpty());
        assertEquals(1, myDynamicArray.size());
    }

    @Test
    void set_should_throw_exception_when_index_is_negative() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> myDynamicArray.set(1, -1));
        assertEquals("Invalid index: -1", exception.getMessage());
    }

    @Test
    void set_should_throw_exception_when_index_is_greater_than_length() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> myDynamicArray.set(1, 1));
        assertEquals("Invalid index: 1", exception.getMessage());
    }

    @Test
    void set_should_set_an_element_when_index_is_within_the_length_of_the_array() {
        myDynamicArray.add(1);
        myDynamicArray.add(2);
        myDynamicArray.add(3);
        myDynamicArray.add(4);
        myDynamicArray.add(5);

        int set_index = 2;
        int element = 10;
        int set_element = myDynamicArray.set(element, set_index);
        assertEquals(5, myDynamicArray.size());
        assertEquals(set_element, myDynamicArray.get(set_index));
    }

    @Test
    void clear() {
        myDynamicArray.add(1);
        myDynamicArray.add(2);
        myDynamicArray.clear();
        assertEquals(0, myDynamicArray.size());
        assertThrows(IndexOutOfBoundsException.class, () -> myDynamicArray.get(0));
    }

    @Test
    void test_default_elements_in_array() {
        int[] arr = new int[5];
        for(int i = 0; i < arr.length; i++){
            System.out.println(i + " -> " + arr[i]);
        }
    }

    @Test
    void test_simple_remove_without_resizing_should_return_removed_element_and_length_should_decrease_by_1(){
        myDynamicArray.add(1);
        myDynamicArray.add(2);
        myDynamicArray.add(3);
        int remove = myDynamicArray.remove();
        myDynamicArray.display();
        assertEquals(3, remove);
        assertEquals(2, myDynamicArray.size());
        assertEquals(1, myDynamicArray.get(0));
        assertEquals(myDynamicArray.getInitialCapacity(), myDynamicArray.getCapacity());
    }

    @Test
    void test_multiple_removal_without_resizing_should_return_removed_element_and_length_should_be_correct(){
        myDynamicArray.add(1);
        myDynamicArray.add(2);
        myDynamicArray.add(3);
        myDynamicArray.add(4);
        int remove = myDynamicArray.remove();
        assertEquals(4, remove);
        myDynamicArray.display();
        assertEquals(3, myDynamicArray.remove());

        assertEquals(2, myDynamicArray.size());
        assertEquals(1, myDynamicArray.get(0));
        assertEquals(myDynamicArray.getInitialCapacity(), myDynamicArray.getCapacity());
        myDynamicArray.display();
    }

    @Test
    void test_multiple_removal_with_resizing_should_return_removed_element_and_length_should_be_correct(){
        myDynamicArray.add(1);
        myDynamicArray.add(2);
        myDynamicArray.add(3);
        myDynamicArray.add(4);
        myDynamicArray.add(5);
        myDynamicArray.add(6);
        myDynamicArray.add(7);

        assertEquals(7, myDynamicArray.removeAndReSize());
        assertEquals(6, myDynamicArray.removeAndReSize());
        assertEquals(5, myDynamicArray.removeAndReSize());
        assertEquals(4, myDynamicArray.removeAndReSize());
        myDynamicArray.display();
        myDynamicArray.displayFullCapacity();

        assertEquals(3, myDynamicArray.removeAndReSize());
        myDynamicArray.display();
        myDynamicArray.displayFullCapacity();
    }

    @Test
    void test_removalAtIndex_with_no_resizing_should_return_removed_element_and_length_should_be_correct(){
        int index_to_remove = 1;
        myDynamicArray.add(1);
        myDynamicArray.add(2);
        myDynamicArray.add(3);
        myDynamicArray.add(4);
        myDynamicArray.add(5);
        myDynamicArray.add(6);
        myDynamicArray.add(7);

        myDynamicArray.display();
        myDynamicArray.displayFullCapacity();

        System.out.println("Array after removing " + myDynamicArray.get(index_to_remove) + " at " + index_to_remove);
        assertEquals(2, myDynamicArray.removeAt(index_to_remove));
        assertEquals(6, myDynamicArray.size());
        assertEquals(myDynamicArray.getInitialCapacity(), myDynamicArray.getCapacity());

        myDynamicArray.display();
        myDynamicArray.displayFullCapacity();
    }

    @Test
    void test_removalAtIndex_with_resizing_should_return_removed_element_and_length_should_be_correct(){
        int index_to_remove = 1;
        myDynamicArray.add(1);
        myDynamicArray.add(2);
        myDynamicArray.add(3);
        myDynamicArray.add(4);
        myDynamicArray.add(5);
        myDynamicArray.add(6);
        myDynamicArray.add(7);
        // Now it has the capacity = 8, so in order for re-sizing, the number of elements i.e. size should reach to 2 which means we need to remove 5 elements for re-sizing to take place

        myDynamicArray.display();
        myDynamicArray.displayFullCapacity();

        //System.out.println("Array after removing " + myDynamicArray.get(index_to_remove) + " at " + index_to_remove);
        assertEquals(2, myDynamicArray.removeAt(index_to_remove));
        assertEquals(3, myDynamicArray.removeAt(index_to_remove));
        assertEquals(4, myDynamicArray.removeAt(index_to_remove));
        assertEquals(5, myDynamicArray.removeAt(index_to_remove));
        assertEquals(6, myDynamicArray.removeAt(index_to_remove));
        System.out.println("After 5 removals:");
        myDynamicArray.display();
        myDynamicArray.displayFullCapacity();
        assertEquals(2, myDynamicArray.size());
        assertEquals(4, myDynamicArray.getCapacity());
    }

    @Test
    void test_removalAtIndex_with_edge_case_of_illegal_array(){
        int index_to_remove = -1;
        myDynamicArray.add(1);
        myDynamicArray.add(2);
        myDynamicArray.displayFullCapacity();
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> myDynamicArray.removeAt(index_to_remove));
        assertEquals("Illegal rm_index " + index_to_remove, exception.getMessage());
    }

    @Test
    void test_removalAtIndex_with_edge_case_of_empty_array(){
        int index_to_remove = 0;
        myDynamicArray.displayFullCapacity();
        Throwable exception = assertThrows(IllegalStateException.class, () -> myDynamicArray.removeAt(index_to_remove));
        assertEquals("Array is empty", exception.getMessage());
    }

    @Test
    void indexOf_should_return_correct_index() {
        myDynamicArray.add(1);
        assertEquals(0, myDynamicArray.indexOf(1));
    }

    @Test
    void indexOf_should_return_negative_one_when_element_not_found() {
        //myDynamicArray.add(1);
        assertEquals(-1, myDynamicArray.indexOf(2));
    }
}
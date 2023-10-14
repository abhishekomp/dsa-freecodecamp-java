package org.example.dynamicarray;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * add(int): Add element to the end of the array
 * clear(): Clears the array
 * get(index): Gets the element at the specified index
 * isEmpty(): Returns true when array is empty else false
 * removeAndReSize(): Removes element from the end of the array
 * removeAt(rm_index): Removes the element at the specified index and resizes the array if needed
 * set(element, index): To DO: sets the specified element at specified index
 * size(): returns the size of the array as seen by the user
 * getCapacity(): returns the full capacity of the array (for internal usage)
 */
public class MyDynamicArray {

    private int[] arr;
    private int len = 0;        // length user thinks array is
    private int capacity = 0;   // Actual array size
    private static final int INITIAL_CAPACITY = 8;

    public MyDynamicArray() {
        this(INITIAL_CAPACITY);
    }

    public MyDynamicArray(int capacity) {
        if(capacity < 0) throw new IllegalArgumentException("Illegal capacity: " + capacity);
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public int getInitialCapacity(){
        return INITIAL_CAPACITY;
    }

    /** This is the actual size (length) of the array perceived by the user
     * Size of the array (How much is the array filled)
     * @return length of the array
     */
    public int size() {
        return len;
    }

    /**
     * Capacity of the array (Maximum size of the array at a given time)
     * @return capacity of the array
     */
    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public int set(int element, int index) {
        if(index < 0 || index > len) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
        arr[index] = element;
        return element;
    }

    public void clear(){
        Arrays.fill(arr, 0);
        len = 0;
    }

    /**
     * Gets the element at specified index
     * @param index requested index
     * @return element at the specified index
     */
    int get(int index) {
        if(index < 0 || index >= len) {
            throw new IndexOutOfBoundsException("Illegal index " + index);
        }
        return arr[index];
    }

    /**
     * Adds an element to the end of the array
     * @param element Element to be inserted
     */
    void add(int element) {
        // Skipped to check if the element is an integer
        // Check if the array is completely full then create a new array with double the capacity and copy all elements from the current array to the new array
        if(this.size() == capacity) {
            capacity = 2 * capacity;
            int[] newArr = new int[capacity];
            for(int i = 0; i < len; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[len++] = element;
    }

    /**
     * Removes the element at specified rm_index
     * @param rm_index rm_index value
     * @return the removed element
     */
    int removeAt(int rm_index) {
        if(rm_index < 0 || rm_index >= arr.length) {
            throw new IndexOutOfBoundsException("Illegal rm_index " + rm_index);
        }
        // Array may be empty
        if(len == 0) {
            throw new IllegalStateException("Array is empty");
        }
        int data = arr[rm_index];
        int[] newArr;
        // Calculate the capacity of the new Array.
        // New capacity = (current capacity)/2, if after removing the element the size of the array becomes less than or equal to one-fourth of the current capacity
        if((len-1) * 4 <= capacity) {
            // create a new array half the capacity of current array
            capacity = capacity / 2;
        }
        newArr = new int[capacity];
        for(int i = 0, j = 0; i < len; i++, j++) {
            if(i == rm_index) {
                j--;
            } else {
                newArr[j] = arr[i];
            }
        }
        arr = newArr;
        len--;
        return data;
    }

    /**
     * Removes the last element from the array.
     * @return the removed element
     */
    @Deprecated
    int remove() {
        // Situation when removal is not possible as there are no elements in the array
        if(arr.length == 0) {
            throw new IllegalStateException("Array is empty");
        }
        int data = arr[len - 1];
        arr[len - 1] = 0;
        len--;
        return data;
    }

    /**
     * Removes the last element from the array and resizes the array when the size of the array becomes equal or less than one-fourth of the capacity
     * @return the removed element
     */
    int removeAndReSize() {
        // Situation when removal is not possible as there are no elements in the array
        if(arr.length == 0) {
            throw new IllegalStateException("Array is empty");
        }
        int data = arr[len - 1];
        arr[len - 1] = 0;
        len--;
        if(len * 4 <= capacity) {
            capacity = capacity/2;
            System.out.println("New capacity: " + capacity);
        }
        return data;
    }

    /**
     * Prints the array on terminal
     */
    void display() {
        String collect = Arrays.stream(arr)
                .limit(len)
                .mapToObj(String::valueOf)
                .collect(joining(", "));
        System.out.println(collect);
    }

    /**
     * Prints the array on terminal
     */
    void displayFullCapacity() {
        String collect = Arrays.stream(arr)
                .limit(capacity)
                .mapToObj(String::valueOf)
                .collect(joining(", "));
        System.out.println(collect);
    }



}

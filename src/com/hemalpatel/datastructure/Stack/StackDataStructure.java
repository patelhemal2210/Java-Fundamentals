package com.hemalpatel.datastructure.Stack;

/**
 * Stack : it represents a stack or ordered pile of some kind of information or data
 * LIFO : Last In First Out
 *
 * Push : Add to stack -> constant O(1)
 * Pop : remove from stack -> constant O(1)
 * Search : search in stack -> Linear O(n)
 * Access : access an element -> Linear O(n)
 *
 */
public class StackDataStructure<T> implements IStack<T> {

    // An array to store the elements
    private T[] data;

    // Pointer points to current element
    private int pointer;

    public StackDataStructure() {
        data = (T[]) new Object[500];
        pointer = 0;
    }

    /**
     * Add the given element to the stack
     * @param element element to be added
     */
    public void push(T element) {
        data[pointer++] = element;
    }

    /**
     * Remove top most element from the stack
     * Throws {@link IllegalStateException} if no element in the stack
     * @return removed element
     */
    public T pop() {
        if(pointer == 0)
            throw new IllegalStateException("No more element in the stack");

        return data[--pointer];
    }

    /**
     * Search if given element is present in the stack
     * @param element element to be searched
     * @return True if element is present else False
     */
    public boolean contains(T element) {
        boolean isFound = false;

        for(int i = 0; i < pointer; i++) {
            if(data[i].equals(element)) {
                isFound = true;
                break;
            }
        }

        return isFound;
    }

    /**
     * Check if element is present if yes, return it
     * Throws {@link IllegalArgumentException} if element is not present
     * @param element element to be fetched
     * @return found element
     */
    public T access(T element) {
        for(int i = 0; i < pointer; i++) {
            T tmpElement = pop();
            if(tmpElement.equals(element)) {
                return tmpElement;
            }
        }

        throw new IllegalArgumentException("Could not find the element: " + element);
    }

    /**
     * Get size of the stack
     * @return size of the stack
     */
    public int size() {
        return pointer;
    }
}

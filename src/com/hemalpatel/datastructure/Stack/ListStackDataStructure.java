package com.hemalpatel.datastructure.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Stack implementation using {@link ArrayList}
 *
 */
public class ListStackDataStructure<T> implements IStack<T> {

    // An array list to store the elements
    private List<T> data;

    // Pointer points to current element
    private int pointer;

    public ListStackDataStructure() {
        data = new ArrayList<>();
        pointer = 0;
    }

    /**
     * Add the given element to the stack
     * @param element element to be added
     */
    @Override
    public void push(T element) {
        data.add(element);
        pointer++;
    }

    /**
     * Remove top most element from the stack
     * Throws {@link IllegalStateException} if no element in the stack
     * @return removed element
     */
    @Override
    public T pop() {
        if(pointer == 0)
            throw new IllegalStateException("No more element in the stack");

        T element = data.get(pointer - 1);
        data.remove(--pointer);

        return element;
    }

    /**
     * Search if given element is present in the stack
     * @param element element to be searched
     * @return True if element is present else False
     */
    @Override
    public boolean contains(T element) {
        return data.contains(element);
    }

    /**
     * Check if element is present if yes, return it
     * Throws {@link IllegalArgumentException} if element is not present
     * @param element element to be fetched
     * @return found element
     */
    @Override
    public T access(T element) {
        while(!data.isEmpty()) {
            T tmpElement = data.get(--pointer);
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
    @Override
    public int size() {
        return pointer;
    }
}

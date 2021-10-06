package com.hemalpatel.datastructure.Stack;

/**
 * Interface for different implementation of Stack
 *
 */
public interface IStack<T> {

    void push(T element);
    T pop();
    boolean contains(T element);
    T access(T element);
    int size();
}

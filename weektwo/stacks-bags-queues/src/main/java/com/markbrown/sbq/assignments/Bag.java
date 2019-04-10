package com.markbrown.sbq.assignments;

public interface Bag<T> {

    boolean isEmpty();

    int size();
   
    void enqueue(T t);

    T dequeue();

    T sample();
    
}
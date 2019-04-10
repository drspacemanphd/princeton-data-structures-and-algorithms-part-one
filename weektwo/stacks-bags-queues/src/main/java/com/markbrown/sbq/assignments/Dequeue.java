package com.markbrown.sbq.assignments;

public interface Dequeue<T> {

    boolean isEmpty();
    int size();
    void addFirst(T t);
    void addLast(T t);
    T removeFirst();
    T removeLast();

}
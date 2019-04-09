package com.markbrown.sbq.impl;

public interface Queue<T> {

    T enqueue(T t);

    T dequeue();

    boolean isEmpty();

    int size();

}
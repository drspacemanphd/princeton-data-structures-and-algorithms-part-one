package com.markbrown.sbq.impl;

public interface Stack<T> {

    T push(T t);

    T pop();

    boolean isEmpty();

    int size();

}
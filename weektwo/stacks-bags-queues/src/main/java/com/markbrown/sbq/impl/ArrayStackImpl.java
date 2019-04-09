package com.markbrown.sbq.impl;

public class ArrayStackImpl<T> implements Stack<T> {

    private Object[] arr;
    private int currentIndex;

    public ArrayStackImpl() {
        arr = new Object[1];
        currentIndex = 0;
    }

    @Override
    public T push(T t) {
        if (currentIndex == arr.length) resize(arr.length * 2 - 1);
        arr[currentIndex++] = t;
        return t;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (currentIndex == 0) return null;
        if (currentIndex == (arr.length / 4)) resize(arr.length / 2 - 1);
        currentIndex--;
        T t = (T) arr[currentIndex];
        return t;
    }

    @Override
    public boolean isEmpty() {
        return currentIndex == 0;
    }

    @Override
    public int size() {
        return currentIndex;
    }

    private void resize(int endIndex) {
        Object newArr[] = new Object[endIndex + 1];
        for (int i = 0; i <= currentIndex - 1; i++) {
            newArr[i] = this.arr[i];
        }
        this.arr = newArr;
    }
    
}
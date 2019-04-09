package com.markbrown.sbq.impl;

public class ArrayQueueImpl<T> implements Queue<T> {

    private Object[] arr;
    private int firstIndex;
    private int currentIndex;

    public ArrayQueueImpl() {
        arr = new Object[1];
        firstIndex = 0;
        currentIndex = 0;
    }

    @Override
    public T enqueue(T t) {
        if (currentIndex == arr.length) resize(currentIndex * 2 - 1);
        arr[currentIndex++] = t;
        return t;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T dequeue() {
        if (firstIndex == currentIndex) return null;
        if (currentIndex == (arr.length / 4)) resize(arr.length / 2 - 1);
        return (T) arr[firstIndex++];
    }

    @Override
    public boolean isEmpty() {
        return firstIndex == currentIndex;
    }

    @Override
    public int size() {
        return currentIndex - firstIndex;
    }

    private void resize(int endIndex) {
        Object[] resized = new Object[endIndex + 1];
        for (int i = 0; i < currentIndex; i++) {
            resized[i] = arr[i];
        }
        arr = resized;
    }

}
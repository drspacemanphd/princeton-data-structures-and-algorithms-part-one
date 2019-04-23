package com.markbrown.sbq.impl;

import java.util.Iterator;

public class ArrayQueueImpl<T> implements Queue<T>, Iterable<T> {

    private T[] arr;
    private int firstIndex;
    private int currentIndex;

    public ArrayQueueImpl() {
        arr = (T[]) new Object[1];
    }

    @Override
    public T enqueue(T t) {
        if (currentIndex == arr.length)
            resize(firstIndex, currentIndex, arr.length * 2);
        arr[currentIndex++] = t;
        return t;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T dequeue() {
        if (firstIndex == currentIndex)
            return null;
        if (currentIndex - firstIndex == (arr.length / 4)) {
            resize(firstIndex, currentIndex, arr.length / 2);
            currentIndex -= firstIndex;
            firstIndex = 0;
        }
        T el = arr[firstIndex++];
        arr[firstIndex - 1] = null;
        return el;
    }

    @Override
    public boolean isEmpty() {
        return firstIndex == currentIndex;
    }

    @Override
    public int size() {
        return currentIndex - firstIndex;
    }

    private void resize(int start, int exclEnd, int newLength) {
        T[] resized = (T[]) new Object[newLength];
        for (int i = 0; i + start < exclEnd; i++) {
            resized[i] = arr[i + start];
        }
        arr = resized;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayQueueIterator();
    }

    private class ArrayQueueIterator implements Iterator<T> {

        private int index;

        public ArrayQueueIterator() {
            index = firstIndex;
        }

        @Override
        public boolean hasNext() {
            return index < currentIndex;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            if (!hasNext()) throw new IllegalArgumentException();
            return (T) arr[index++];
        }

    }

}
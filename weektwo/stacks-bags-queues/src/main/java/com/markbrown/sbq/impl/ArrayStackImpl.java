package com.markbrown.sbq.impl;

import java.util.Iterator;

public class ArrayStackImpl<T> implements Stack<T>, Iterable<T> {

    private T[] arr;
    private int currentIndex;

    public ArrayStackImpl() {
        arr = (T[]) new Object[1];
        currentIndex = 0;
    }

    @Override
    public T push(T t) {
        if (currentIndex == arr.length) resize(currentIndex, arr.length * 2);
        arr[currentIndex++] = t;
        return t;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (currentIndex == 0) return null;
        if (currentIndex == (arr.length / 4)) resize(currentIndex, arr.length / 2);
        T t = arr[--currentIndex];
        arr[currentIndex + 1] = null;
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

    private void resize(int exclEnd, int newLength) {
        T[] newArr = (T[]) new Object[newLength];
        for (int i = 0; i < exclEnd; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<T> {

        private int index;

        public ArrayStackIterator() {
            index = currentIndex;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            if (!hasNext())
                throw new IllegalArgumentException();
            return (T) arr[--index];
        }

    }
    
}
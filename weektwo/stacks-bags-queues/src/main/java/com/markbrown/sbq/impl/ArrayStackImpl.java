package com.markbrown.sbq.impl;

import java.util.Iterator;

public class ArrayStackImpl<T> implements Stack<T>, Iterable<T> {

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
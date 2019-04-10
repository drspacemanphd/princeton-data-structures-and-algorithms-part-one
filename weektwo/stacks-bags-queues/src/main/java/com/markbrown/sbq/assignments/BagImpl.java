package com.markbrown.sbq.assignments;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BagImpl<T> implements Bag<T>, Iterable<T> {

    private Object[] arr;
    private int currentIndex;

    public BagImpl() {
        arr = new Object[1];
        currentIndex = 0;
    }

    @Override
    public boolean isEmpty() {
        return currentIndex == 0;
    }

    @Override
    public int size() {
        return currentIndex;
    }

    @Override
    public void enqueue(T t) {
        if (currentIndex == arr.length) resize(arr.length * 2 - 1);
        arr[currentIndex] = t;
        currentIndex++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        if (currentIndex == (arr.length / 4) - 1) resize(arr.length / 2 - 1);
        int randomIndex = (int) Math.floor(Math.random() * currentIndex);
        T dataToRemove = (T) arr[randomIndex];
        T dataToReplace = (T) arr[--currentIndex];
        arr[randomIndex] = dataToReplace;
        arr[currentIndex] = null;
        return dataToRemove;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int randomIndex = (int) Math.floor(Math.random() * currentIndex);
        return (T) arr[randomIndex];
    }

    private void resize(int endIndex) {
        Object[] newArr = new Object[endIndex + 1];
        for (int i = 0; i < currentIndex; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<T> {

        int randomIndex;
        Object[] copy;
        int cursor;

        public BagIterator() {
            copy = new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                copy[i] = arr[i];
            }
            cursor = currentIndex; 
        }
        
        @Override
        public boolean hasNext() {
            return cursor != 0;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            randomIndex = (int) Math.floor(Math.random() * cursor);
            T data = (T) copy[randomIndex];
            T dataToReplace = (T) copy[--cursor];
            copy[randomIndex] = dataToReplace;
            copy[cursor] = null;
            return data;
        }

    }

}
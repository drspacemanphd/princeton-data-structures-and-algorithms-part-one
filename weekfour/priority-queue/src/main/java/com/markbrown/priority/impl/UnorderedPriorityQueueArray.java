package com.markbrown.priority.impl;

public class UnorderedPriorityQueueArray<T extends Comparable<T>> {

    private T[] arr;
    private int currIndex;

    public UnorderedPriorityQueueArray() {
        arr = (T[]) new Comparable[4];
    }

    private void resize(int exclEnd, int newLength) {
        T[] temp = (T[]) new Comparable[newLength];
        for (int i = 0; i < exclEnd; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    private void shuffleElementsLeft(int start, int exclEnd) {
        for (int i = start; i < exclEnd; i++) {
            arr[i - 1] = arr[i];
        }
    }

    public T insert(T data) {
        if (currIndex == arr.length) resize(currIndex, arr.length * 2);
        arr[currIndex++] = data;
        return data;
    }

    public T removeMax() {
        if (currIndex == arr.length / 4) resize(currIndex, arr.length / 2);
        if (currIndex == arr.length) resize(currIndex, arr.length * 2);
        int maxIndex = 0; 
        for (int i = 1; i < currIndex; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) maxIndex = i;
        }
        arr[currIndex] = arr[maxIndex];
        shuffleElementsLeft(maxIndex + 1, currIndex);
        return arr[currIndex--];
    }

    public int size() {
        return currIndex;
    }

    public boolean isEmpty() {
        return currIndex == 0;
    }

}
package com.markbrown.priority.impl;

public class SortedPriorityQueueArray<T extends Comparable<T>> {

    public T[] arr;
    public int currIndex;

    public SortedPriorityQueueArray() {
        arr = (T[]) new Comparable[4];
    }

    private void resize(int exclEnd, int newLength) {
        T[] temp = (T[]) new Comparable[newLength];
        for (int i = 0; i < exclEnd; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    private void shuffleElementsRight(int start, int end) {
        for (int i = end; i >= start; i--) {
            arr[i + 1] = arr[i];
        }
    }

    public T insert(T data) {
        if (currIndex == arr.length) resize(currIndex, arr.length * 2);
        if (currIndex == 0) {
            arr[currIndex++] = data;
            return data;
        }
        else if (arr[0].compareTo(data) > 0) {
            shuffleElementsRight(0, currIndex - 1);
            arr[0] = data;
            currIndex++;
            return data;
        }
        else if (arr[currIndex - 1].compareTo(data) < 0) {
            arr[currIndex++] = data;
            return data;
        }
        else {
            for (int i = 1; i < currIndex; i++) {
                if (arr[i].compareTo(data) >= 0 && arr[i - 1].compareTo(data) < 0) {
                    shuffleElementsRight(i, currIndex - 1);
                    arr[i] = data;
                    currIndex++;
                    break;
                }
            }
        }

        return data;
    }

    public T removeMax() {
        return arr[--currIndex];
    }

    public int size() {
        return currIndex;
    }

    public boolean isEmpty() {
        return currIndex == 0;
    }

}
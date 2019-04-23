package com.markbrown.priority.impl;

import java.util.stream.Stream;

public class BinaryHeap<T extends Comparable<T>> {

    private T[] arr;
    private int currIndex;

    public BinaryHeap() {
        arr = (T[]) new Comparable[4];
        currIndex = 1;
    }

    private void resize(int exclEnd, int newLength) {
        T[] temp = (T[]) new Comparable[newLength];
        for (int i = 0; i < exclEnd; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    private void exchange(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void swim(int i) {
        while (i > 1 && arr[i].compareTo(arr[i / 2]) >= 0) {
            exchange(i, i / 2);
            i /= 2;
        }
    }

    private void sink(int i) {
        while (2 * i < currIndex) {
            int j = i * 2;
            if (j + 1 < currIndex - 1 && arr[j].compareTo(arr[j + 1]) < 0) j++;
            if (arr[i].compareTo(arr[j]) > 0 || j + 1 >= currIndex) break;
            exchange(i, j);
            i = j;
        }
    }

    public T insert(T data) {
        if (currIndex == arr.length) resize(currIndex, arr.length * 2);
        arr[currIndex++] = data;
        swim(currIndex - 1);
        System.out.println(currIndex);
        return data;
    }

    public T removeMax() {
        if (isEmpty()) return null;
        if (currIndex == arr.length / 4) resize(currIndex, arr.length / 2);
        T max = arr[1];
        exchange(1, currIndex - 1);
        sink(1);
        arr[--currIndex] = null;
        System.out.println(" ");
        Stream.of(arr).forEach(e -> System.out.print(e + ", "));
        System.out.println(" ");
        System.out.println(currIndex);
        System.out.println(" ");
        return max;
    }

    public int size() {
        return currIndex - 1;
    }

    public boolean isEmpty() {
        return currIndex == 1;
    }

}
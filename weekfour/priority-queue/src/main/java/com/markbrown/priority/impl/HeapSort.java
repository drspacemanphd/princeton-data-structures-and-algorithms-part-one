package com.markbrown.priority.impl;

import java.util.stream.Stream;

public class HeapSort {

    public <T extends Comparable<T>> T[] sort(T[] arr) {
        createMaxHeap(arr);
        _sort(arr);
        return arr;
    }

    private <T extends Comparable<T>> void _sort(T[] arr) {
        int n = arr.length;
        while (n > 1) {
            exchange(arr, 1, n--);
            sink(arr, 1, n);
        }
    }

    private <T extends Comparable<T>> void createMaxHeap(T[] arr) {
        for (int i = arr.length / 2; i >= 1; i--) {
            sink(arr, i, arr.length);
        }
    }

    private <T extends Comparable<T>> void exchange(T[] arr, int i, int j) {
        T temp = arr[i - 1];
        arr[i - 1] = arr[j - 1];
        arr[j - 1] = temp;
    }

    private <T extends Comparable<T>> void sink(T[] arr, int i, int n) {
        while (i * 2 < n) {
            int j = i * 2;
            if (j < n && arr[j - 1].compareTo(arr[j]) < 0) j++;
            if (arr[i - 1].compareTo(arr[j - 1]) >= 0) break;
            else exchange(arr, i, j);
            i = j;
        }
    }

}
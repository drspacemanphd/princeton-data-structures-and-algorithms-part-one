package com.markbrown.quicksort.impl;

public class ThreeWayQuickSort {

    public <T extends Comparable<T>> T[] sort(T[] arr) {
        shuffle(arr);
        _sort(arr, 0, arr.length - 1);
        return arr;
    }

    private <T extends Comparable<T>> void _sort (T[] arr, int start, int end) {
        if (start >= end) return;

        int i = start, j = start, k = end;
        T partition = arr[start];

        while (j <= k) {
            if (arr[j].compareTo(partition) < 0) {
                exchange(arr, i++, j++);
            } else if (arr[j].compareTo(partition) > 0) {
                exchange(arr, j, k--);
            } else {
                j++;
            }
        }

        _sort(arr, start, i - 1);
        _sort(arr, k + 1, end);
    }

    private <T extends Comparable<T>> void shuffle(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int randIndex = (int) Math.floor(Math.random() * (i + 1));
            T temp = arr[randIndex];
            arr[randIndex] = arr[i];
            arr[i] = temp;
        }
    }

    private <T extends Comparable<T>> void exchange(T[] arr, int i, int j) {
        T temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}
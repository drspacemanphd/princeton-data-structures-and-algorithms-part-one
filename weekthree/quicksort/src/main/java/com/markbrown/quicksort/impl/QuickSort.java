package com.markbrown.quicksort.impl;

public class QuickSort {

    public <T extends Comparable<T>> T[] sort(T[] arr) {
        shuffle(arr);
        _sort(arr, 0, arr.length - 1);
        return arr;
    }

    private <T extends Comparable<T>> void _sort(T[] arr, int low, int high) {
        if (low >= high) return;

        T partition = arr[low];
        int i = low + 1;
        int j = high;

        while (true) {
            while (i <= high && partition.compareTo(arr[i]) > 0) i++;
            while (j >= low && partition.compareTo(arr[j]) < 0) j--;
            if (i >= j) {
                arr[low] = arr[j];
                arr[j] = partition;
                partition = arr[low];
                break;
            } else {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

        }

        _sort(arr, low, j-1);
        _sort(arr, i, high);

    }

    // Knuth Shuffle
    private <T extends Comparable<T>> void shuffle(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index = (int) Math.floor(Math.random() * (i + 1));
            T temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

}
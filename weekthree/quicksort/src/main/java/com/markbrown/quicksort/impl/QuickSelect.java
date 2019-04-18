package com.markbrown.quicksort.impl;

public class QuickSelect {

    public <T extends Comparable<T>> T selectMth(T[] arr, int m) {
        shuffle(arr);
        return _sort(arr, 0, arr.length - 1, m);
    }

    private <T extends Comparable<T>> T _sort(T[] arr, int start, int end, int m) {
        int i = start, j = start, k = end;
        T partition = arr[start];
        while (j <= k) {
            if (arr[j].compareTo(partition) < 0) exchange(arr, i++, j++);
            else if (arr[j].compareTo(partition) > 0) exchange(arr, j, k--);
            else j++;
        }
        if (k == arr.length - m) return arr[k];
        else if (k > arr.length - m) return _sort(arr, start, i - 1, m);
        else return _sort(arr, k + 1, end, m);
    }

    private <T extends Comparable<T>> void exchange(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private <T extends Comparable<T>> void shuffle(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int randIndex = (int) Math.floor(Math.random() * (i + 1));
            T temp = arr[i];
            arr[i] = arr[randIndex];
            arr[randIndex] = temp;
        }
    }

}
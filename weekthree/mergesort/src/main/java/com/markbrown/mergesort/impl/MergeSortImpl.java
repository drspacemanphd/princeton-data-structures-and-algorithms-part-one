package com.markbrown.mergesort.impl;

public class MergeSortImpl implements Sort {

    public <T extends Comparable<T>> T[] sort(T[] arr) {
        T[] temp = (T[]) new Comparable[arr.length];
        _sort(arr, temp, 0, arr.length - 1);
        return arr;
    }

    private <T extends Comparable<T>> void _sort(T[] arr, T[] temp, int start, int inclEnd) {
        if (start >= inclEnd) return;
        int low = start;
        int high = inclEnd;
        int mid = start + ((inclEnd - start) / 2);

        _sort(arr, temp, low, mid);
        _sort(arr, temp, mid + 1, high);
        _merge(arr, temp, low, mid, high);
    }

    private <T extends Comparable<T>> void _merge(T[] arr, T[] temp, int start, int mid, int inclEnd) {
        int i = start;
        int j = mid + 1;

        for (int k = start; k <= inclEnd; k++) {
            temp[k] = arr[k];
        }

        for (int k = start; k <= inclEnd; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > inclEnd) {
                arr[k] = temp[i];
                i++;
            } else if (temp[j].compareTo(temp[i]) < 0) {
                arr[k] = temp[j];
                j++;
            } else {
                arr[k] = temp[i];
                i++;
            }
        }
    }

}
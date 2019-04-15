package com.markbrown.mergesort.impl;

import java.util.stream.Stream;

public class BottomUpMergeSortImpl implements Sort {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        
        T[] temp = (T[]) new Comparable[arr.length];

        int n = arr.length;
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n - len; lo += len + len) {
                int mid = lo + len - 1; 
                int hi = Math.min(lo + len + len - 1, n - 1);
                sort(arr, temp, lo, mid, hi);
            }
        }

        return arr;
    }

    private <T extends Comparable<T>> void sort(T[] arr, T[] temp, int start, int mid, int inclEnd) {

        for (int k = start; k <= inclEnd; k++) {
            temp[k] = arr[k];
        }

        int i = start;
        int j = mid + 1;

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
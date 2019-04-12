package com.markbrown.sorts.impl;

public class ShellSortImpl extends AbstractSortImpl {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int hIndex = 1;
        while ((hIndex * 3) + 1 < arr.length) hIndex = (hIndex * 3 + 1);
        while (hIndex >= 1) {
            for (int i = hIndex; i < arr.length; i++) {
                for (int j = i; j - hIndex >= 0 && less(arr[j], arr[j - hIndex]); j -= hIndex) {
                    swap(arr, j, j - hIndex);
                }

            }
            hIndex = (hIndex - 1) / 3;
        }
        return arr;
    }

}
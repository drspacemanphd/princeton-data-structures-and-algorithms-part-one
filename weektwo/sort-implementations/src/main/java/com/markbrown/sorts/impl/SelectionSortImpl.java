package com.markbrown.sorts.impl;

public class SelectionSortImpl extends AbstractSortImpl {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (less(arr[j], arr[minIndex])) minIndex = j;
            }
            swap(arr, minIndex, i);
        }
        return arr;
    }

}
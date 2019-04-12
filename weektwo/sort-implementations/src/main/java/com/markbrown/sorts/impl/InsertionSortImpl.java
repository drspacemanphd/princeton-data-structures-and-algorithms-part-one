package com.markbrown.sorts.impl;

public class InsertionSortImpl extends AbstractSortImpl {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = i;
            int toCompare = i - 1;
            while (toCompare >= 0 && less(arr[current], arr[toCompare])) {
                swap(arr, current, toCompare);
                current--;
                toCompare--;
            }
        } 
        return arr;
    }

}
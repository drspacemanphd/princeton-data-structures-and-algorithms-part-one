package com.markbrown.sorts.impl;

public class InsertionSortImpl extends AbstractSortImpl {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                swap(arr, j, j-1);
            }
        } 
        return arr;
    }

}
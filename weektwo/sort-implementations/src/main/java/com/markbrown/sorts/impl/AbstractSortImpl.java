package com.markbrown.sorts.impl;

public abstract class AbstractSortImpl implements Sort {

    public abstract <T extends Comparable<T>> T[] sort(T[] arr);

    protected <T extends Comparable<T>> boolean less(T ths, T that) {
        return ths.compareTo(that) < 0;
    }

    protected <T extends Comparable<T>> void swap(T[] arr, int i, int r) {
        T temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
    }

}
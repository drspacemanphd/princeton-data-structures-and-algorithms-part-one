package com.markbrown.quicksort.quiz;

public class NutsAndBolts {

    public <T extends Comparable<T>> void pair(T[] nuts, T[] bolts) {
        _pair(nuts, bolts, 0, nuts.length - 1);
    }

    private <T extends Comparable<T>> void _pair(T[] nuts, T[] bolts, int start, int end) {
        if (start >= end) return;
        T bPartition = bolts[start];
        int partitionIndex = _partition(nuts, bPartition, start, end);
        _partition(bolts, bPartition, start, end);
        _pair(nuts, bolts, start, partitionIndex - 1);
        _pair(nuts, bolts, partitionIndex + 1, end);
    }

    private <T extends Comparable<T>> int _partition(T[] arr, T partition, int start, int end) {
        int i = start, j = start, k = end;
        while (j <= k) {
            if (arr[j].compareTo(partition) < 0) exchange(arr, i++, j++);
            else if (arr[j].compareTo(partition) > 0) exchange(arr, j, k--);
            else j++;
        }
        return k;
    }

    private <T extends Comparable<T>> void exchange(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
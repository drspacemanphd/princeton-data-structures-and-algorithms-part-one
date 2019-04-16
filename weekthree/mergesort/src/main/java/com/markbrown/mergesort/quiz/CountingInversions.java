package com.markbrown.mergesort.quiz;

import java.util.Comparator;

public class CountingInversions {

    public <T> long countInversions(T[] arr, Comparator<T> comparator) {
        T[] temp = (T[]) new Object[arr.length];
        return getInversions(arr, temp, comparator, 0, arr.length - 1);
    }

    private <T> long getInversions(T[] arr, T[] temp, Comparator<T> comparator, int start, int end) {
        if (start >= end) return 0;

        int inversions = 0;
        int low = start;
        int high = end;
        int mid = start + ((end - start) / 2);
        inversions += getInversions(arr, temp, comparator, low, mid);
        inversions += getInversions(arr, temp, comparator, mid + 1, high);
        inversions += getInversionsFromMerge(arr, temp, comparator, low, mid, high);
        return inversions;
    }

    private <T> long getInversionsFromMerge(T[] arr, T[] temp, Comparator<T> comparator, int start, int mid, int end) {
        int inversions = 0;
        
        for (int k = start; k <= end; k++) {
            temp[k] = arr[k];
        }

        int i = start;
        int j = mid + 1;

        for (int k = start; k <= end; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > end) {
                arr[k] = temp[i];
                i++;
            } else if (comparator.compare(temp[j], temp[i]) < 0) {
                arr[k] = temp[j];
                j++;
                inversions += (mid - i + 1);
            } else {
                arr[k] = temp[i];
                i++;
            }
        }

        return inversions;
    }

}
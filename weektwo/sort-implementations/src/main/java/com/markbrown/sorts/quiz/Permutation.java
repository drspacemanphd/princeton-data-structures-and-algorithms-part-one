package com.markbrown.sorts.quiz;

public class Permutation {

    public <T extends Comparable<T>> boolean arePermutations(T[] arrOne, T[] arrTwo) {
        if (arrOne.length != arrTwo.length) return false;
        T[] sortedOne = sort(arrOne);
        T[] sortedTwo = sort(arrTwo);
        for (int i = 0; i < arrOne.length; i++) {
            if (sortedOne[i] != sortedTwo[i]) return false;
        }
        return true;
    }

    private <T extends Comparable<T>> T[] sort(T[] arr) {
        int hIndex = 1;
        while ((hIndex * 3) + 1 < arr.length) hIndex = (hIndex * 3) + 1;
        while (hIndex >= 1) {
            for (int i = hIndex; i < arr.length; i++) {
                for (int j = i; j - hIndex >= 0 && lessThan(arr[j], arr[j - hIndex]); j -= hIndex) {
                    swap(arr, j, j - hIndex);
                }
            }
            hIndex = (hIndex - 1) / 3;
        }
        return arr;
    }

    private <T extends Comparable<T>> boolean lessThan(T ths, T that) {
        return ths.compareTo(that) < 0;
    }

    private <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
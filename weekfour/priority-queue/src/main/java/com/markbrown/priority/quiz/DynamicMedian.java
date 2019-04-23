package com.markbrown.priority.quiz;

import java.util.stream.Stream;

public class DynamicMedian<T extends Comparable<T>> {

    private T[] minHeap;
    private T[] maxHeap;
    private int minHeapFirstIndex;
    private int minHeapCurrIndex;
    private int maxHeapFirstIndex;
    private int maxHeapCurrIndex;

    public DynamicMedian() {
        minHeap = (T[]) new Comparable[4];
        maxHeap = (T[]) new Comparable[4];
        minHeapFirstIndex = 1;
        minHeapCurrIndex = 1;
        maxHeapFirstIndex = 1;
        maxHeapCurrIndex = 1;
    }

    private void resizeMinHeap(int start, int exclEnd, int newLength) {
        T[] temp = (T[]) new Comparable[newLength];
        for (int i = 0; i + start < exclEnd; i++) {
            temp[i] = minHeap[i + start];
        }
        minHeap = temp;
    }

    private void resizeMaxHeap(int start, int exclEnd, int newLength) {
        T[] temp = (T[]) new Comparable[newLength];
        for (int i = 0; i + start < exclEnd; i++) {
            temp[i] = maxHeap[i + start];
        }
        maxHeap = temp;
    }

    private void exchange(T[] arrOne, int i, T[] arrTwo, int j) {
        T temp = arrOne[i];
        arrOne[i] = arrTwo[j];
        arrTwo[j] = temp;
    }

    private boolean isLessThan(T[] arrOne, int i, T[] arrTwo, int j) {
        return arrOne[i].compareTo(arrTwo[j]) < 0;
    }

    private void sinkInMinHeap(int i) {
        while (i < minHeapCurrIndex) {
            int j = i * 2;
            if (j >= minHeapCurrIndex - 1) break;
            if (j + 1 < minHeapCurrIndex - 1 && isLessThan(minHeap, j, minHeap, j + 1)) j++;
            if (isLessThan(minHeap, i, minHeap, j)) break;
            exchange(minHeap, i, minHeap, j);
            i = j;
        }
    }

    private void sinkInMaxHeap(int i) {
        while (i < maxHeapCurrIndex) {
            int j = i * 2;
            if (j >= maxHeapCurrIndex - 1) break;
            if (j + 1 < maxHeapCurrIndex - 1 && isLessThan(maxHeap, j, maxHeap, j + 1)) j++;
            if (!isLessThan(maxHeap, i, maxHeap, j)) break;
            exchange(maxHeap, i, maxHeap, j);
            i = j;
        }
    }

    private void swimInMaxHeap(int i) {
        while (i / 2 >= maxHeapFirstIndex) {
            int j = i / 2;
            if (isLessThan(maxHeap, i, maxHeap, j)) break;
            exchange(maxHeap, i, maxHeap, j);
            i = j;
        }
    }

    private void swimInMinHeap(int i) {
        while (i / 2 >= minHeapFirstIndex) {
            int j = i / 2;
            if (!isLessThan(minHeap, i, minHeap, j)) break;
            exchange(minHeap, i, minHeap, j);
            i = j;
        }
    }

    private int getMinHeapSize() {
        return minHeapCurrIndex - minHeapFirstIndex;
    }

    private int getMaxHeapSize() {
        return maxHeapCurrIndex - maxHeapFirstIndex;
    }

    private void rebalanceMinHeapToMaxHeap() {
        maxHeap[maxHeapCurrIndex++] = minHeap[minHeapFirstIndex];
        swimInMaxHeap(maxHeapCurrIndex - 1);
        minHeap[minHeapFirstIndex++] = null;
        if (minHeap[minHeapFirstIndex + 1] != null && !isLessThan(minHeap, minHeapFirstIndex, minHeap, minHeapFirstIndex + 1)) {
            exchange(minHeap, minHeapFirstIndex, minHeap, minHeapFirstIndex + 1);
        }
        sinkInMinHeap(minHeapFirstIndex);
    }

    private void rebalanceMaxHeapToMinHeap() {
        minHeap[minHeapCurrIndex++] = maxHeap[maxHeapFirstIndex];
        swimInMinHeap(minHeapCurrIndex - 1);
        maxHeap[maxHeapFirstIndex++] = null;
        if (maxHeap[maxHeapFirstIndex + 1] != null && isLessThan(maxHeap, maxHeapFirstIndex, maxHeap, maxHeapFirstIndex + 1)) {
            exchange(maxHeap, maxHeapFirstIndex, maxHeap, maxHeapFirstIndex + 1);
        }
        sinkInMaxHeap(maxHeapFirstIndex);    
    }

    public T getMedian() {
        if (maxHeap[maxHeapFirstIndex] == null) return minHeap[minHeapFirstIndex];
        else if (minHeap[minHeapFirstIndex] == null) return maxHeap[maxHeapFirstIndex];
        else if (getMaxHeapSize() > getMinHeapSize()) return maxHeap[maxHeapFirstIndex];
        else if (getMinHeapSize() > getMaxHeapSize()) return minHeap[minHeapFirstIndex];
        else if (getMinHeapSize() == getMaxHeapSize()) {
            return isLessThan(maxHeap, maxHeapFirstIndex, minHeap, minHeapFirstIndex) ? maxHeap[maxHeapFirstIndex] : minHeap[minHeapFirstIndex];
        }
        throw new RuntimeException();
    }

    public T insert(T data) {
        if (minHeapCurrIndex >= minHeap.length) resizeMinHeap(minHeapFirstIndex - 1, minHeapCurrIndex, minHeap.length * 2);
        if (maxHeapCurrIndex >= maxHeap.length) resizeMaxHeap(maxHeapFirstIndex - 1, maxHeapCurrIndex, maxHeap.length * 2);

        if (minHeapFirstIndex == minHeapCurrIndex) {
            minHeap[minHeapCurrIndex++] = data;
            swimInMinHeap(minHeapCurrIndex - 1);
        } else if (maxHeapFirstIndex == maxHeapCurrIndex) {
            maxHeap[maxHeapCurrIndex++] = data;
            swimInMaxHeap(maxHeapCurrIndex - 1);
        } else if (data.compareTo(minHeap[minHeapFirstIndex]) > 0) {
            minHeap[minHeapCurrIndex++] = data;
            swimInMinHeap(minHeapCurrIndex - 1);
        } else {
            maxHeap[maxHeapCurrIndex++] = data;
            swimInMaxHeap(maxHeapCurrIndex - 1);
        }

        if (getMaxHeapSize() > getMinHeapSize() + 1) rebalanceMaxHeapToMinHeap();
        if (getMinHeapSize() > getMaxHeapSize() + 1) rebalanceMinHeapToMaxHeap();

        Stream.of(minHeap).forEach(e -> System.out.print(e + ", "));
        System.out.println(" ");
        Stream.of(maxHeap).forEach(e -> System.out.print(e + ", "));
        System.out.println(" ");
        System.out.println(" ");

        return data;
    }

    public void print(T[] arr) {
        Stream.of(arr).forEach(e -> System.out.print(e + ", "));
        System.out.println(" ");
    }
}
package com.markbrown.symbol.impl;

import com.markbrown.symbol.OrderedSymbolTable;

public class ArraySymbolTableImpl<K extends Comparable<K>, V> implements OrderedSymbolTable<K, V> {

    private Node<K, V>[] arr;
    private int firstIndex;
    private int currIndex;

    public ArraySymbolTableImpl() {
        arr = (Node<K, V>[]) new Node[4];
    }

    private void resize(int start, int exclEnd, int newLength) {
        Node<K, V>[] temp = (Node<K, V>[]) new Node[newLength];
        for (int i = 0; i + start < exclEnd; i++) {
            temp[i] = arr[i + start];
        }
        arr = temp;
    }

    private void shuffleToRight(int start, int end) {
        for (int i = end; i >= start; i--) {
            arr[i] = arr[i - 1];
        }
    }

    private void shuffleToLeft(int start, int end) {
        for (int i = start; i <= end; i++) {
            arr[i] = arr[i + 1];
        }
    }

    @Override
    public V put(K key, V value) {

        if (currIndex == arr.length) resize(firstIndex, currIndex, arr.length * 2);

        if (currIndex == firstIndex) {
            arr[currIndex++] = new Node<>(key, value);
            return value;
        }

        int low = firstIndex, high = currIndex - 1, mid = 0;

        while (low <= high) {

            mid = (high + low) / 2;

            if (arr[mid].getKey().equals(key)) {
                arr[mid].setValue(value);
                return value;
            } else if (arr[mid].getKey().compareTo(key) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        shuffleToRight(low + 1, currIndex++);
        arr[low] = new Node<>(key, value);

        return value;
    }

    @Override
    public V get(K key) {
        int low = firstIndex, high = currIndex - 1, mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid].getKey().equals(key)) return arr[mid].getValue();
            else if (arr[mid].getKey().compareTo(key) < 0) low = mid + 1;
            else high = mid - 1;
        }

        return null;
    }

    @Override
    public boolean remove(K key) {

        if (firstIndex == currIndex) return false;
        if (currIndex - firstIndex == arr.length / 4) {
            resize(firstIndex, currIndex, arr.length / 2);
            currIndex -= firstIndex;
            firstIndex = 0;
        }

        int low = firstIndex, high = currIndex - 1, mid = 0;

        while (low <= high) {
            mid = (high + low) / 2;
            if (arr[mid].getKey().equals(key)) {
                shuffleToLeft(mid, currIndex--);
                return true;
            } else if (arr[mid].getKey().compareTo(key) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return currIndex - firstIndex;
    }

    @Override
    public boolean isEmpty() {
        return currIndex == firstIndex;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public K min() {
        return arr[firstIndex].getKey();
    }

    @Override
    public K max() {
        return arr[currIndex - 1].getKey();
    }

    private class Node<T, U> {

        private T key;
        private U value;

        public Node(T key, U value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return this.key;
        }

        public U getValue() {
            return this.value;
        }

        public void setValue(U value) {
            this.value = value;
        }

    }


}
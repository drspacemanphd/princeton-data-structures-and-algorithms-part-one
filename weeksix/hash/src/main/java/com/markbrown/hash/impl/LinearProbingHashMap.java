package com.markbrown.hash.impl;

public class LinearProbingHashMap<K, V> {

    private class Node<S, T> {

        private S key;
        private T value;

        public Node(S key, T value) {
            this.key = key;
            this.value = value;
        }

    }

    private int M = 97;
    private int N = 0;
    private Node<K, V>[] arr = (Node<K, V>[]) new Node[M];

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int start, int end, int newLength) {
        Node<K, V>[] temp = (Node<K, V>[]) new Node[newLength];
        for (int i = 0; i + start < end; i++) {
            temp[i] = arr[i + start];
        }
        arr = temp;
    } 

    public V get(K key) {
        int hash = hash(key);
        if (arr[hash] == null) return null;
        else if (arr[hash].key.equals(key)) return arr[hash].value;
        else {
            int i = hash;
            while (!arr[i].key.equals(key)) {
                if (++i >= arr.length) i = 0;
                if (i == hash || arr[i] == null) return null;
            }
            return arr[i].value;
        }
    }

    public V put(K key, V value) {
        if (N >= M * 2) resize(0, M, M * 2);
        int hash = hash(key);
        int i = hash;
        while (arr[i] != null) {
            if (arr[i].key.equals(key)) {
                arr[i].value = value;
                return value;
            }
            i = i + 1 >= arr.length ? 0 : i + 1;
        }
        arr[i] = new Node<>(key, value);
        N++;
        return value;
    }

    public void delete(K key) {
        int hash = hash(key);
        int i = hash;
        while (arr[i] != null) {
            if (arr[i].key.equals(key)) {
                N--;
                arr[i] = null;
                return;
            }
            i = i + 1 >= arr.length ? 0 : i + 1;
        }
        return;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }
    
}
package com.markbrown.hash.impl;

public class SeparateChainingHashMap<K, V> {

    private class Node<S, T> {

        private S key;
        private T value;
        private Node<S, T> next;

        public Node(S key, T value, Node<S, T> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    private int M = 31;
    private int N = 0;
    private Node<K, V>[] arr = (Node<K, V>[]) new Node[M];

    private void resize(int start, int end, int newLength) {
        Node<K, V>[] temp = (Node<K, V>[]) new Node[newLength];
        for (int i = 0; i + start < end; i++) {
            temp[i] = arr[i + start];
        }
        arr = temp;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public V get(K key) {
        int hash = hash(key);
        Node<K, V> i = arr[hash];
        while (i != null) {
            if (i.key.equals(key)) return i.value;
            else i = i.next;
        } return null;
    }

    public V put(K key, V value) {
        if (N / M > 5) {
            resize(0, M, M * 2);
            M *= 2;
        }
        int hash = hash(key);
        for (Node<K, V> i = arr[hash]; i != null; i = i.next) {
            if (i.key.equals(key)) {
                i.value = value;
                return value;
            } else if (i.next == null) {
                i.next = new Node<>(key, value, null);
                N++;
                return value;
            }
        }
        arr[hash] = new Node<>(key, value, null);
        N++;
        return value;
    }

    public void delete(K key) {
        int hash = hash(key);
        if (arr[hash] == null) return;
        if (arr[hash].key.equals(key)) {
            N--;
            arr[hash] = arr[hash].next;
            return;
        }
        for (Node<K, V> i = arr[hash]; i.next != null; i = i.next) { 
            if (i.next.key.equals(key)) {
                N--;
                i.next = i.next.next;
                return;
            }
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
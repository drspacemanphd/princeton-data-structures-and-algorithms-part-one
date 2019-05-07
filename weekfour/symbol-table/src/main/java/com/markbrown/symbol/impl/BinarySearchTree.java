package com.markbrown.symbol.impl;

import java.util.ArrayDeque;
import java.util.Queue;

import com.markbrown.symbol.OrderedSymbolTable;

public class BinarySearchTree<K extends Comparable<K>, V> implements OrderedSymbolTable<K, V> {

    private Node<K, V> root;

    @Override
    public V get(K key) {
        Node<K, V> i = root;
        while (i != null) {
            int cmp = i.key.compareTo(key);
            if (cmp == 0)
                return i.value;
            else if (cmp > 0)
                i = i.left;
            else
                i = i.right;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        root = put(root, key, value);
        return value;
    }

    private Node<K, V> put(Node<K, V> x, K key, V value) {
        if (x == null) return new Node<>(key, value);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    @Override
    public int size() {
        return root != null ? size(root) : 0;
    }

    private int size(Node<K, V> node) {
        return node != null ? node.size : 0;
    }

    @Override
    public boolean isEmpty() {
        return size(root) == 0;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public K min() {
        Node<K, V> i = root;
        while (i != null && i.left != null) {
            i = i.left;
        }
        return i.key;
    }

    @Override
    public K max() {
        Node<K, V> i = root;
        while (i != null && i.right != null) {
            i = i.right;
        }
        return i.key;
    }

    public Iterable<K> keys() {
        Queue<K> queue = new ArrayDeque<>();
        enqueue(root, queue);
        return queue;
    }

    private void enqueue(Node<K, V> node, Queue<K> queue) {
        if (node == null) return;
        enqueue(node.left, queue);
        queue.add(node.key);
        enqueue(node.right, queue);
    }

    private class Node<T, U> {

        private T key;
        private U value;
        private Node<T, U> left;
        private Node<T, U> right;
        private int size;

        public Node(T key, U value) {
            this.key = key;
            this.value = value;
            size = 1;
        }

    }

}
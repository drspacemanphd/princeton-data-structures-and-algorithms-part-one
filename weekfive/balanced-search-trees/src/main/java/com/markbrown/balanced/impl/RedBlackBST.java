package com.markbrown.balanced.impl;

public class RedBlackBST<K extends Comparable<K>, V> {

    private class Node<S, T> {
        
        private S key;
        private T value;
        private Node<S, T> left;
        private Node<S, T> right;
        private int size;
        private boolean isRed;

        public Node(S key, T value, boolean isRed) {
            this.key = key;
            this.value = value;
            this.isRed = isRed;
            size = 1;
        }

    }

    private Node<K, V> root;

    private Node<K, V> rotateLeft(Node<K, V> h) {
        Node<K, V> x = h.right;
        if (x == null) return h;
        h.right = x.left;
        x.left = h;
        x.isRed = h.isRed;
        h.isRed = true;
        setSize(h);
        setSize(x);
        return x;
    }

    private Node<K, V> rotateRight(Node<K, V> h) {
        Node<K, V> x = h.left;
        if (x == null) return h;
        h.left = x.right;
        x.right = h;
        x.isRed = h.isRed;
        h.isRed = true;
        setSize(h);
        setSize(x);
        return x;
    }

    private Node<K, V> flipColors(Node<K, V> x) {
        if (x.right != null) x.right.isRed = false;
        if (x.left != null) x.left.isRed = false;
        x.isRed = true;
        return x;
    }

    private void setSize(Node<K, V> x) {
        int leftSize = x.left != null ? x.left.size : 0;
        int rightSize = x.right != null ? x.right.size : 0;
        x.size = leftSize + rightSize + 1;
    }

    private boolean isRed(Node<K, V> x) {
        return x != null ? x.isRed : false;
    }

    private Node<K, V> _put(Node<K, V> x, K key, V value) {
        if (x == null) return new Node<>(key, value, true);
        int cmp = key.compareTo(x.key);
        if (cmp > 0) x.right = _put(x.right, key, value);
        else if (cmp < 0) x.left = _put(x.left, key, value);
        else x.value = value;


        if (isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right)) flipColors(x);

        setSize(x);

        return x;
    }

    public V get(K key) {
        Node<K, V> i = root;
        while (i != null) {
            int cmp = i.key.compareTo(key);
            if (cmp < 0) i = i.right;
            else if (cmp > 0) i = i.left;
            else return i.value;
        }
        return null;
    } 

    public V put(K key, V value) {
        root = _put(root, key, value);
        return value;
    }

    public int size() {
        return root.size;
    }

    public boolean isEmpty() {
        return root == null;
    }


}
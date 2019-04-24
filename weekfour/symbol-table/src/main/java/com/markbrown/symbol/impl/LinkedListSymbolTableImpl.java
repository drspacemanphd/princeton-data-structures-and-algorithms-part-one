package com.markbrown.symbol.impl;

import com.markbrown.symbol.UnorderedSymbolTable;

public class LinkedListSymbolTableImpl<K, V> implements UnorderedSymbolTable<K, V> {

    private Node<K, V> first;

    @Override
    public V put(K key, V value) {

        Node<K, V> i = first;
        Node<K, V> newNode = new Node<>(key, value, null);

        if (i == null) {
            first = newNode;
            return value;
        }

        while (i != null) {

            if (i.getNext() == null) {
                i.setNext(newNode);
                return value;
            }

            if (i.getKey().equals(key)) {
                i.setValue(value);
                return value;
            }

            i = i.getNext();
        }

        return value;
    }

    @Override
    public V find(K key) {
        Node<K, V> i = first;
        while (i != null) {
            if (i.getKey().equals(key)) return i.getValue();
            i = i.getNext();
        }
        return null;
    }

    @Override
    public boolean delete(K key) {

        Node<K, V> i = first;

        if (i == null) return false;

        if (i.getKey().equals(key)) {
            first = first.getNext();
            return true;
        }

        while (i.getNext() != null) {
            if (i.getNext().getKey().equals(key)) {
                i.setNext(i.getNext().getNext());
                return true;
            }
            i = i.getNext();
        }

        return false;
    }

    @Override
    public int size() {
        int size = 0;
        Node<K, V> i = first;
        while (i != null) {
            size++;
            i = i.getNext();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private class Node<T, U> {

        private T key;
        private U value;
        private Node<T, U> next;

        public Node(T key, U value, Node<T, U> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public T getKey() {
            return this.key;
        }

        public U getValue() {
            return this.value;
        }

        public Node<T, U> getNext() {
            return this.next;
        }

        public void setValue(U value) {
            this.value = value;
        }

        public void setNext(Node<T, U> next) {
            this.next = next;
        }

    }

}
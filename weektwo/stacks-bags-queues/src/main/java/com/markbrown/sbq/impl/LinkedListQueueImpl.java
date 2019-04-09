package com.markbrown.sbq.impl;

public class LinkedListQueueImpl<T> implements Queue<T> {

    private Node<T> first, last;

    @Override
    public T enqueue(T t) {
        Node<T> oldLast = this.last;
        this.last = new Node<T>(t, null);
        if (oldLast != null) oldLast.setNext(this.last);
        else {
            oldLast = this.last;
            this.first = this.last;
        }
        return t;
    }

    @Override
    public T dequeue() {
        if (this.first == null) return null;
        T payload = this.first.getPayload();
        this.first = this.first.getNext();
        if (this.first == null) this.last = null;
        return payload;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int size() {
        if (this.first == null) return 0;
        int size = 1;
        Node<T> start = this.first;
        while (start != null && start.getNext() != null) {
            size++;
            start = start.getNext();
        }
        return size;
    }

    private class Node<U> {
        U payload;
        Node<U> next;

        public Node(U payload, Node<U> next) {
            this.payload = payload;
            this.next = next;
        }

        public U getPayload() {
            return this.payload;
        }

        public Node<U> getNext() {
            return this.next;
        }

        public void setPayload(U payload) {
            this.payload = payload;
        }

        public void setNext(Node<U> next) {
            this.next = next;
        }

    }

}
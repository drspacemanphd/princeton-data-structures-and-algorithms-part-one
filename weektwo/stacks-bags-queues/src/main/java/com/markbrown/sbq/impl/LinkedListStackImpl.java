package com.markbrown.sbq.impl;

public class LinkedListStackImpl<T> implements Stack<T> {

    private Node<T> first;

    public T push(T payload) {
        Node<T> oldFirst = this.first;
        first = new Node<T>(payload, oldFirst);
        System.out.println(first.getNext());
        return payload;
    }

    public T pop() {
       T payload = this.first == null ? null : this.first.payload;
       first = this.first == null ? null : first.getNext();
       return payload;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        if (first == null) return 0;
        Node<T> start = first;
        int size = 1;
        while(start != null && start.getNext() != null) {
            size++;
            start = start.getNext();
        }
        return size;
    }

    private class Node<U> {

        private Node<U> next;
        private U payload;
        
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

    }

}
package com.markbrown.sbq.assignments;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeueImpl<T> implements Dequeue<T>, Iterable<T> {

    private Node<T> first;
    private Node<T> last;

    @Override
    public boolean isEmpty() {
        return first == null || last == null;
    }

    @Override
    public int size() {
        if (isEmpty()) return 0;
        int size = 1;
        Node<T> start = first;
        while (start != null && start.getNext() != null) {
            start = start.getNext();
            size++;
        }
        return size;
    }

    @Override
    public void addFirst(T t) {
        Node<T> oldFirst = first;
        first = new Node<T>(t, null, oldFirst);
        if (oldFirst != null) oldFirst.setPrev(first);
        else last = first;
    }

    @Override
    public void addLast(T t) {
        Node<T> oldLast = last;
        last = new Node<T>(t, oldLast, null);
        if (oldLast != null) oldLast.setNext(last);
        else first = last;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        T data = first.getData();
        first = first.getNext();
        if (first != null) first.setPrev(null);
        else last = null;
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        T data = last.getData();
        last = last.getPrev();
        if (last != null) last.setNext(null);
        else first = null;
        return data;
    }

    @Override
    public Iterator<T> iterator() {
        return new DequeueIterator();
    }

    private class DequeueIterator implements Iterator<T> {

        private Node<T> current;

        public DequeueIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            return current.getNext().getData();
        }

        public boolean hasPrev() {
            return current.getPrev() != null;
        }

        public T prev() {
            return current.getPrev().getData();
        }

    }

    private class Node<U> {

        U data;
        Node<U> prev;
        Node<U> next;

        public Node(U data, Node<U> prev, Node<U> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public U getData() { return this.data; }

        public Node<U> getNext() { return this.next; }

        public Node<U> getPrev() { return this.prev; }

        public void setData(U data) {
            this.data = data;
        }

        public void setNext(Node<U> next) {
            this.next = next;
        }

        public void setPrev(Node<U> prev) {
            this.prev = prev;
        }
    }

}
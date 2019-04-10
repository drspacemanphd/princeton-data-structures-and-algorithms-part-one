package com.markbrown.sbq.quiz;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxStackListImpl<T extends Comparable<? super T>> implements Iterable<T> {

    private Node<T> first;

    public T push(T t) {
        Node<T> oldFirst = this.first;
        Node<T> newFirst = new Node<T>(t, oldFirst);
        this.first = newFirst;
        return t;
    }

    public T pop() {
        if (this.first == null)
            throw new NoSuchElementException();
        T dataToPop = this.first.getData();
        first = this.first.getNext();
        return dataToPop;
    }

    public int size() {
        Node<T> start = this.first;
        if (start == null)
            return 0;
        int size = 1;
        while (start != null && start.getNext() != null) {
            size++;
            start = start.getNext();
        }
        return size;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T getMax() {
        if (this.first == null)
            throw new NoSuchElementException();
        T max = first.getData();
        Node<T> start = this.first;
        while (start != null && start.getNext() != null) {
            start = start.getNext();
            if (max.compareTo(start.getData()) < 0)
                max = start.getData();
        }
        return max;
    }

    public T getMin() {
        if (this.first == null)
            throw new NoSuchElementException();
        T min = first.getData();
        Node<T> start = this.first;
        while (start != null && start.getNext() != null) {
            start = start.getNext();
            if (min.compareTo(start.getData()) > 0)
                min = start.getData();
        }
        return min;
    }

    @Override
    public Iterator<T> iterator() {
        return new MaxStackListImplIterator();
    }

    private class MaxStackListImplIterator implements Iterator<T> {

        private Node<T> start;

        public MaxStackListImplIterator() {
            start = first; 
        }

        @Override
        public boolean hasNext() {
            return start.getNext() != null;
        }

        @Override
        public T next() {
            T data = start.getData();
            start = start.getNext();
            return data;
        }

    }

    private class Node<U> {

        private U data;
        private Node<U> next;

        public Node(U data, Node<U> next) {
            this.data = data;
            this.next = next;
        }

        public U getData() {
            return this.data;
        }

        public Node<U> getNext() {
            return this.next;
        }

        public void setData(U data) {
            this.data = data;
        }

        public void setNext(Node<U> next) {
            this.next = next;
        }

    }

}
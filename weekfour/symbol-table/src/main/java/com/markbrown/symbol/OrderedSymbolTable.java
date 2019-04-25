package com.markbrown.symbol;

public interface OrderedSymbolTable<K extends Comparable<K>, V> {

    V put(K key, V value);

    V get(K key);

    boolean remove(K key);

    int size();

    boolean isEmpty();

    boolean contains(K key);

    K min();

    K max();

}
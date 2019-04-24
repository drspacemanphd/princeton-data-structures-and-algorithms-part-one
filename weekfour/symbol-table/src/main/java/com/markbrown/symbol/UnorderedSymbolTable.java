package com.markbrown.symbol;

public interface UnorderedSymbolTable<K, V> {

    V put(K key, V value);

    V find(K key);

    boolean delete(K key);

    int size();

    boolean isEmpty();
    
}
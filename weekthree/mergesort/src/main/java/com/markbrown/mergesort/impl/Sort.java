package com.markbrown.mergesort.impl;

public interface Sort {

    <T extends Comparable<T>> T[] sort(T [] arr);
    
}
package com.markbrown.sorts.impl;

public interface Sort {

    <T extends Comparable<T>> T[] sort(T[] arr);

}
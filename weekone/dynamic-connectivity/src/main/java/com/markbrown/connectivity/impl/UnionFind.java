package com.markbrown.connectivity.impl;

public interface UnionFind {

    int[] union(int a, int b);

    boolean connected(int a, int b);

}
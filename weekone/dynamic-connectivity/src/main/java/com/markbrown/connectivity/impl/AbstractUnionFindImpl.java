package com.markbrown.connectivity.impl;

public abstract class AbstractUnionFindImpl implements UnionFind {

    protected int[] arr;

    public AbstractUnionFindImpl(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) { arr[i] = n; }
    }

    public AbstractUnionFindImpl(int[] arr) {
        this.arr = arr;
    }

    @Override
    public abstract int[] union(int a, int b);

    @Override
    public abstract boolean connected(int a, int b);

    protected int getRoot(int a) {
        if (a != arr[a]) return getRoot(arr[a]);
        return a;
    }

}
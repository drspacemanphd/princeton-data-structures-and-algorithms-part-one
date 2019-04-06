package com.markbrown.connectivity.impl;

public class QuickUnionImpl extends AbstractUnionFindImpl {

    public QuickUnionImpl(int n) {
        super(n);
    }

    public QuickUnionImpl(int[] arr) {
        super(arr);
    }

    @Override
    public int[] union(int a, int b) {
        int rootA = getRoot(a);
        int rootB = getRoot(b);
        arr[rootB] = rootA;
        return this.arr;
    }

    @Override
    public boolean connected(int a, int b) {
        return getRoot(a) == getRoot(b);
    }

}
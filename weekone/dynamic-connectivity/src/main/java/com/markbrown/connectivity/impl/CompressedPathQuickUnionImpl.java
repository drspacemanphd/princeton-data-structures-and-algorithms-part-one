package com.markbrown.connectivity.impl;

public class CompressedPathQuickUnionImpl extends AbstractUnionFindImpl {

    public CompressedPathQuickUnionImpl(int n) {
        super(n);
    }

    public CompressedPathQuickUnionImpl(int[] arr) {
        super(arr);
    }
    
    @Override
    public int[] union(int a, int b) {
        int rootA = this.getRoot(a);
        int rootB = this.getRoot(b);
        arr[rootB] = rootA;
        return arr;
    }

    @Override
    public boolean connected(int a, int b) {
        return this.getRoot(a) == this.getRoot(b);
    }

    @Override
    protected int getRoot(int a) {
        compressPath(a);
        if (arr[a] != a) { return getRoot(arr[a]); }
        else return a;
    }

    private void compressPath(int a) {
        int value = arr[a];
        while (value != a && arr[value] != value) {
            arr[a] = arr[value];
            arr[value] = arr[arr[value]];
            value = arr[a];
        }
    }

}
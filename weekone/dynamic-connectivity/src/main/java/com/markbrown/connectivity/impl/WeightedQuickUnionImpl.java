package com.markbrown.connectivity.impl;

import java.util.Arrays;

public class WeightedQuickUnionImpl extends AbstractUnionFindImpl {

    private int[] treeSizes;

    public WeightedQuickUnionImpl(int n) {
        super(n);
        treeSizes = new int[n];
        Arrays.fill(treeSizes, 1);
    }

    public WeightedQuickUnionImpl(int[] arr) {
        super(arr);
        treeSizes = new int[arr.length];
        Arrays.fill(treeSizes, 1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                int size = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == i && i != j) size++;
                }
                treeSizes[i] += size;
            }
        }
    }

    @Override
    public int[] union(int a, int b) {
        int rootA = getRoot(a);
        int rootB = getRoot(b);
        if (treeSizes[rootB] < treeSizes[rootA]) {
            this.arr[rootB] = rootA;
            treeSizes[rootA] += treeSizes[rootB];
        }
        else {
            this.arr[rootA] = rootB;
            treeSizes[rootB] += treeSizes[rootA];
        }
        return this.arr;
    }

    @Override
    public boolean connected(int a, int b) {
        return getRoot(a) == getRoot(b);
    }

    public int[] getTreeSizes() {
        return this.treeSizes;
    }

}
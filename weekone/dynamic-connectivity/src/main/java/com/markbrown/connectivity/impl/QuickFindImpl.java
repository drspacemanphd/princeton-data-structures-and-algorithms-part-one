package com.markbrown.connectivity.impl;

public class QuickFindImpl extends AbstractUnionFindImpl {

    public QuickFindImpl(int n) {
        super(n);
    }

    public QuickFindImpl(int[] arr) {
        super(arr);
    }

    @Override
    public int[] union(int a, int b) {

        int valueA = this.arr[a];
        int valueB = this.arr[b];

        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == valueB) this.arr[i] = valueA;
        }

        return this.arr;

    }

    @Override
    public boolean connected(int a, int b) {
        return this.arr[a] == this.arr[b];
    }

}
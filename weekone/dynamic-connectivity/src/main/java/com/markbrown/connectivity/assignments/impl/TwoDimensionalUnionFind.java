package com.markbrown.connectivity.assignments.impl;

public class TwoDimensionalUnionFind implements UnionFind {
    
    private int virtualRootOne;
    private int virtualRootTwo;
    private int[] network;
    private int[] treeSizes;

    public TwoDimensionalUnionFind(int dimension) {

        network = new int[(dimension * dimension) + 2];
        for (int i = 0; i < network.length; i++) { network[i] = i; }

        treeSizes = new int[(dimension * dimension) + 2];
        for (int i = 0; i < treeSizes.length; i++) { treeSizes[i] = 1; }

        virtualRootOne = 0;
        virtualRootTwo = network.length - 1;

        for (int i = virtualRootOne + 1; i < dimension + 1; i++) { network[i] = virtualRootOne; }
        treeSizes[virtualRootOne] += dimension;

        for (int i = virtualRootTwo - dimension; i < virtualRootTwo; i++) { network[i] = virtualRootTwo; }
        treeSizes[virtualRootTwo] += dimension;
    
    }

    @Override
    public void union(int a, int b) {
        int rootA = getRoot(a);
        int rootB = getRoot(b);
        if (treeSizes[rootB] < treeSizes[rootA]) {
            this.network[rootB] = rootA;
            this.treeSizes[rootA] += this.treeSizes[rootB];
        } else {
            this.network[rootA] = rootB;
            this.treeSizes[rootB] += this.treeSizes[rootA];
        }
    }

    @Override
    public boolean connected(int a, int b) {
        return getRoot(a) == getRoot(b);
    }

    private int getRoot(int a) {
        if (a != network[a]) return getRoot(network[a]);
        return a;
    }

}
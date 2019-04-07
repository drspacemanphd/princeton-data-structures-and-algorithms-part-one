package com.markbrown.connectivity.assignments.impl;

public class TwoDimensionalQuickFind implements UnionFind {

    private int virtualRootOne;
    private int virtualRootTwo;
    private int[] network;

    public TwoDimensionalQuickFind(int dimension) {

        network = new int[(dimension * dimension) + 2];
        for (int i = 0; i < network.length; i++) {
            network[i] = i;
        }

        virtualRootOne = 0;
        virtualRootTwo = network.length - 1;

        for (int i = virtualRootOne + 1; i < dimension + 1; i++) {
            network[i] = virtualRootOne;
        }

        for (int i = virtualRootTwo - dimension; i < virtualRootTwo; i++) {
            network[i] = virtualRootTwo;
        }

    }

    @Override
    public void union(int a, int b) {
        int valueA = network[a];
        int valueB = network[b];
        for (int i = 0; i < network.length; i++) {
            if (network[i] == valueB) network[i] = valueA;
        }
    }

    @Override
    public boolean connected(int a, int b) {
        return network[a] == network[b];
    }

}
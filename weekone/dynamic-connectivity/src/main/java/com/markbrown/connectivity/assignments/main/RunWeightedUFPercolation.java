package com.markbrown.connectivity.assignments.main;

import com.markbrown.connectivity.assignments.apps.WeightedUFPercolationApp;

public class RunWeightedUFPercolation {

    public static void main(String[] args) {
        WeightedUFPercolationApp app = new WeightedUFPercolationApp(500, 1);
        app.runSimulations();
    }

}
package com.markbrown.connectivity.assignments.apps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.markbrown.connectivity.assignments.Stat;
import com.markbrown.connectivity.assignments.impl.TwoDimensionalUnionFind;

public class WeightedUFPercolationApp extends AbstractPercolationApp<TwoDimensionalUnionFind> {

    public WeightedUFPercolationApp(int dimension, int trials) {
        super(dimension, trials);
        this.resetSimulation();
    }

    public void runSimulations() {
        List<Double> pValues = new ArrayList<>();
        List<Double> times = new ArrayList<>();

        for (int i = 0; i < this.trials; i++) {
            double start = (double) System.currentTimeMillis();
            while(!isPercolationComplete()) {
                Integer site = this.openSite();
                this.performUnions(site);
            }

            double end = (double) System.currentTimeMillis();
            times.add((end - start) / 1000);
            pValues.add((double) ((this.dimension * this.dimension) - this.closedSites.size()) / (this.dimension * this.dimension));
            this.resetSimulation();
        }

        new Stat(pValues).printData();
        new Stat(times).printData();

    }

    private void resetSimulation() {
        algorithm = new TwoDimensionalUnionFind(dimension);
        closedSites = new HashMap<>();
        for (int i = 1; i < (dimension * dimension) + 1; i++) {
            closedSites.put(i, true);
        }
    }

}
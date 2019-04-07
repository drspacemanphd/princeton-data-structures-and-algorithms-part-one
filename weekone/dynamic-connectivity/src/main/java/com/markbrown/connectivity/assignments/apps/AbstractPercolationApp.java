package com.markbrown.connectivity.assignments.apps;

import java.util.ArrayList;
import java.util.Map;

import com.markbrown.connectivity.assignments.impl.UnionFind;

public abstract class AbstractPercolationApp<T extends UnionFind> {

    protected int dimension;
    protected int trials;
    protected Map<Integer, Boolean> closedSites;
    protected T algorithm;

    public AbstractPercolationApp(int dimension, int trials) {
        this.dimension = dimension;
        this.trials = trials;
    }

    public abstract void runSimulations();

    protected boolean isPercolationComplete() {
        return this.algorithm.connected(0, (this.dimension * this.dimension + 1));
    }

    protected Integer openSite() {
        int randomIndex = (int) ((Math.random() * this.closedSites.size()));
        Integer siteToOpen = new ArrayList<>(this.closedSites.keySet()).get(randomIndex);
        this.closedSites.remove(siteToOpen);
        return siteToOpen;
    }

    protected void performUnions(Integer site) {
        if (!isSiteOnLeftEdge(site)) {
            if (this.closedSites.get(site + 1) == null)
                this.algorithm.union(site, site + 1);
        }
        if (!isSiteOnRightEdge(site)) {
            if (this.closedSites.get(site - 1) == null)
                this.algorithm.union(site, site - 1);
        }
        if (!isSiteOnTopEdge(site)) {
            if (this.closedSites.get(site - dimension) == null)
                this.algorithm.union(site, site - dimension);
        }
        if (!isSiteOnBottomEdge(site)) {
            if (this.closedSites.get(site + dimension) == null)
                this.algorithm.union(site, site + dimension);
        }
    }

    protected boolean isSiteOnTopEdge(Integer site) {
        return site >= 0 && site <= dimension;
    }

    protected boolean isSiteOnRightEdge(Integer site) {
        return site % dimension == 0;
    }

    protected boolean isSiteOnLeftEdge(Integer site) {
        return (site - 1) % dimension == 0;
    }

    protected boolean isSiteOnBottomEdge(Integer site) {
        return site >= (dimension * dimension) - dimension + 1 && site <= (dimension * dimension);
    }

}
package com.markbrown.connectivity.assignments;

import java.util.List;

public class Stat {

    private List<Double> data;
    private int count;
    private double avg;
    private double stdev;

    public Stat(List<Double> data) {
        this.data = data;
        computeStats(this.data);
    }

    public void printData() {
        System.out.println("NUMBER OF TRIALS: " + this.count);
        System.out.println("MEAN: " + avg);
        System.out.println("STANDARD DEVIATION: " + stdev);
        System.out.println(" ");
    }

    private void computeStats(List<Double> data) {
        this.count = data.size();

        double sum = 0;
        for (Double datum : data) {
            sum += datum;
        }
        this.avg = sum / this.count;

        double sumForStDev = 0;
        for (Double datum : data) {
            sumForStDev += Math.pow(this.avg - datum, 2);
        }
        this.stdev = Math.sqrt(sumForStDev);
    }

}
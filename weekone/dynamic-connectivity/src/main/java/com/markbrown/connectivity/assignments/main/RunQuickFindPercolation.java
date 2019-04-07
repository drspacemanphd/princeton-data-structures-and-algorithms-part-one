package com.markbrown.connectivity.assignments.main;

import com.markbrown.connectivity.assignments.apps.QuickFindPercolationApp;

public class RunQuickFindPercolation {

    public static void main(String[] args) {
        QuickFindPercolationApp app = new QuickFindPercolationApp(500, 1);
        app.runSimulations();
    }

}
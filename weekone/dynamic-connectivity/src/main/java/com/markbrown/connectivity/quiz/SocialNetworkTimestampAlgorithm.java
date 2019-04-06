package com.markbrown.connectivity.quiz;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

public class SocialNetworkTimestampAlgorithm {

    private int root;
    private int[] network;
    private int[] treeSizes;
    private List<Connection> connections;

    public SocialNetworkTimestampAlgorithm(int n, String logFilePath) {
        this.root = -1;
        this.network = new int[n];
        for (int i = 0; i < n; i++) network[i] = i;
        this.treeSizes = new int[n];
        Arrays.fill(treeSizes, 1);
        this.initializeConnections(logFilePath);
    }

    public Timestamp getEarliestConnectionDate() {
        for (Connection connection : this.connections) {
            union(connection.getFriendOne(), connection.getFriendTwo());
            if (treeSizes[this.root] == network.length) return connection.getTimestamp();
        }
        return null;
    }

    private void union(int a, int b) {
        int rootA = getRoot(a);
        int rootB = getRoot(b);
        if (this.root == -1) {
            this.root = rootA;
        }
        if (treeSizes[rootB] < treeSizes[rootA]) {
            network[rootB] = rootA;
            treeSizes[rootA] += treeSizes[rootB];
            this.root = rootA;
        } else {
            network[rootA] = rootB;
            treeSizes[rootB] += treeSizes[rootA];
            this.root = rootB;
        }
    }

    private int getRoot(int a) {
        if (network[a] != a) return getRoot(network[network[a]]);
        return a;
    }

    private void initializeConnections(String logFilePath) {
        connections = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                connections.add(new Connection(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Timestamp.valueOf(values[2])));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Connection {

    private int friendOne;
    private int friendTwo;
    private Timestamp timestamp;

    public Connection(int friendOne, int friendTwo, Timestamp timestamp) {
        this.friendOne = friendOne;
        this.friendTwo = friendTwo;
        this.timestamp = timestamp;
    }

    public int getFriendOne() {
        return this.friendOne;
    }

    public int getFriendTwo() {
        return this.friendTwo;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

}
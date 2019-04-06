package com.markbrown.connectivity.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WeightedQuickUnionImplTest {

    private WeightedQuickUnionImpl weightedQuickUnionImpl;

    @Test
    public void testThatUnionCanBePerformed() {
        int[] arr = { 0, 1, 9, 4, 9, 6, 6, 7, 8, 9 };
        weightedQuickUnionImpl = new WeightedQuickUnionImpl(arr);

        // Test
        int[] result = weightedQuickUnionImpl.union(2, 5);
        int[] trees = weightedQuickUnionImpl.getTreeSizes();

        // Assert
        assertEquals(0, result[0], 0);
        assertEquals(1, result[1], 0);
        assertEquals(9, result[2], 0);
        assertEquals(4, result[3], 0);
        assertEquals(9, result[4], 0);
        assertEquals(6, result[5], 0);
        assertEquals(9, result[6], 0);
        assertEquals(7, result[7], 0);
        assertEquals(8, result[8], 0);
        assertEquals(9, result[9], 0);

        assertEquals(1, trees[0], 0);
        assertEquals(1, trees[1], 0);
        assertEquals(1, trees[2], 0);
        assertEquals(1, trees[3], 0);
        assertEquals(1, trees[4], 0);
        assertEquals(2, trees[6], 0);
        assertEquals(1, trees[7], 0);
        assertEquals(1, trees[8], 0);
        assertEquals(5, trees[9], 0);
    }

    @Test
    public void testThatUnionCanBePerformedTwo() {
        int[] arr = { 0, 1, 9, 4, 9, 6, 6, 7, 8, 9 };
        weightedQuickUnionImpl = new WeightedQuickUnionImpl(arr);

        // Test
        int[] result = weightedQuickUnionImpl.union(5, 2);
        int[] trees = weightedQuickUnionImpl.getTreeSizes();

        // Assert
        assertEquals(0, result[0], 0);
        assertEquals(1, result[1], 0);
        assertEquals(9, result[2], 0);
        assertEquals(4, result[3], 0);
        assertEquals(9, result[4], 0);
        assertEquals(6, result[5], 0);
        assertEquals(9, result[6], 0);
        assertEquals(7, result[7], 0);
        assertEquals(8, result[8], 0);
        assertEquals(9, result[9], 0);

        assertEquals(1, trees[0], 0);
        assertEquals(1, trees[1], 0);
        assertEquals(1, trees[2], 0);
        assertEquals(1, trees[3], 0);
        assertEquals(1, trees[4], 0);
        assertEquals(2, trees[6], 0);
        assertEquals(1, trees[7], 0);
        assertEquals(1, trees[8], 0);
        assertEquals(5, trees[9], 0);
    }

    @Test
    public void testThatConnectedCanBePerformed() {
        // Setup
        int[] arr = { 0, 1, 9, 4, 9, 6, 6, 7, 8, 9 };
        weightedQuickUnionImpl = new WeightedQuickUnionImpl(arr);

        // Test
        boolean resultOne = weightedQuickUnionImpl.connected(2, 5);
        boolean resultTwo = weightedQuickUnionImpl.connected(2, 9);

        // Assert
        assertFalse(resultOne);
        assertTrue(resultTwo);

    }
}
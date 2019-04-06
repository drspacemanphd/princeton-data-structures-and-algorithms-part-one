package com.markbrown.connectivity.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CompressedPathQuickUnionImplTest {

    private CompressedPathQuickUnionImpl compressedPathQuickUnionImpl;

    @Test
    public void testThatUnionCanBePerformed() {
        int[] arr = { 0, 1, 3, 4, 9, 6, 6, 7, 8, 9 };
        compressedPathQuickUnionImpl = new CompressedPathQuickUnionImpl(arr);

        // Test
        int[] result = compressedPathQuickUnionImpl.union(2, 5);

        // Assert
        assertEquals(0, result[0], 0);
        assertEquals(1, result[1], 0);
        assertEquals(9, result[2], 0);
        assertEquals(9, result[3], 0);
        assertEquals(9, result[4], 0);
        assertEquals(6, result[5], 0);
        assertEquals(9, result[6], 0);
        assertEquals(7, result[7], 0);
        assertEquals(8, result[8], 0);
        assertEquals(9, result[9], 0);

    }

    @Test
    public void testThatUnionCanBePerformedTwo() {
        int[] arr = { 0, 1, 3, 4, 9, 6, 6, 7, 8, 9 };
        compressedPathQuickUnionImpl = new CompressedPathQuickUnionImpl(arr);

        // Test
        int[] result = compressedPathQuickUnionImpl.union(5, 3);

        // Assert
        assertEquals(0, result[0], 0);
        assertEquals(1, result[1], 0);
        assertEquals(3, result[2], 0);
        assertEquals(9, result[3], 0);
        assertEquals(9, result[4], 0);
        assertEquals(6, result[5], 0);
        assertEquals(6, result[6], 0);
        assertEquals(7, result[7], 0);
        assertEquals(8, result[8], 0);
        assertEquals(6, result[9], 0);

    }

    @Test
    public void testThatConnectedCanBePerformed() {
        // Setup
        int[] arr = { 0, 1, 9, 4, 9, 6, 6, 7, 8, 9 };
        compressedPathQuickUnionImpl = new CompressedPathQuickUnionImpl(arr);

        // Test
        boolean resultOne = compressedPathQuickUnionImpl.connected(2, 5);
        boolean resultTwo = compressedPathQuickUnionImpl.connected(2, 9);

        // Assert
        assertFalse(resultOne);
        assertTrue(resultTwo);

    }
}
package com.markbrown.connectivity.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class QuickUnionImplTest {

    QuickUnionImpl quickUnionImpl;

    @Test
    public void testThatUnionCanBePerformed() {
        // Setup
        int[] arr = { 0, 1, 9, 4, 9, 6, 6, 7, 8, 9 };
        quickUnionImpl = new QuickUnionImpl(arr);

        // Test
        int[] result = quickUnionImpl.union(2, 5);

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

    }

    @Test
    public void testThatConnectedCanBePerformed() {
        // Setup
        int[] arr = { 0, 1, 9, 4, 9, 6, 6, 7, 8, 9 };
        quickUnionImpl = new QuickUnionImpl(arr);

        // Test
        boolean resultOne = quickUnionImpl.connected(2, 5);
        boolean resultTwo = quickUnionImpl.connected(2, 9);

        // Assert
        assertFalse(resultOne);
        assertTrue(resultTwo);

    }

}
package com.markbrown.connectivity.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class QuickFindImplTest {

    private QuickFindImpl quickFind;

    @Test
    public void testTwoPointsCanBeConnected() {
        // Setup
        int[] arr = {0, 4, 5, 2, 0, 5, 3, 6, 4};
        quickFind = new QuickFindImpl(arr);

        // Test
        int[] result = quickFind.union(0, 2);

        // Assert
        assertEquals(9, result.length, 0);
        assertEquals(0, result[0], 0);
        assertEquals(4, result[1], 0);
        assertEquals(0, result[2], 0);
        assertEquals(2, result[3], 0);
        assertEquals(0, result[4], 0);
        assertEquals(0, result[5], 0);
        assertEquals(3, result[6], 0);
        assertEquals(6, result[7], 0);
        assertEquals(4, result[8], 0);
    }

    @Test
    public void testThatTwoPointsCanBeTestedForConnectivity() {
        // Setup
        int[] arr = { 0, 4, 5, 2, 0, 5, 3, 6, 4 };
        quickFind = new QuickFindImpl(arr);

        // Test
        boolean resultOne = quickFind.connected(0, 4);
        boolean resultTwo = quickFind.connected(0, 2);

        // Assert
        assertTrue(resultOne);
        assertFalse(resultTwo);
    }

}
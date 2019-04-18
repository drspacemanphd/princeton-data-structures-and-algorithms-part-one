package com.markbrown.quicksort.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class ThreeWayQuickSortTest {

    private ThreeWayQuickSort quickSort;
    
    @Before
    public void setup() {
        quickSort = new ThreeWayQuickSort();
    }

    @Test
    public void testQuickSortOne() {
        // Assert
        Integer[] arr = { -1, 4, 2, -3, 0, -2, -4, 1, 3 };

        // Test
        Integer[] returnedArr = quickSort.sort(arr);

        // Assert
        assertNotNull(returnedArr);
        assertEquals(9, returnedArr.length, 0);
        assertEquals(-4, returnedArr[0], 0);
        assertEquals(-3, returnedArr[1], 0);
        assertEquals(-2, returnedArr[2], 0);
        assertEquals(-1, returnedArr[3], 0);
        assertEquals(0, returnedArr[4], 0);
        assertEquals(1, returnedArr[5], 0);
        assertEquals(2, returnedArr[6], 0);
        assertEquals(3, returnedArr[7], 0);
        assertEquals(4, returnedArr[8], 0);

    }

    @Test
    public void testQuickSortTwo() {
        // Assert
        String[] arr = { "Q", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };

        // Test
        String[] returnedArr = quickSort.sort(arr);

        // Assert
        assertNotNull(returnedArr);
        assertEquals(16, returnedArr.length, 0);
        assertEquals("A", returnedArr[0]);
        assertEquals("C", returnedArr[1]);
        assertEquals("E", returnedArr[2]);
        assertEquals("E", returnedArr[3]);
        assertEquals("I", returnedArr[4]);
        assertEquals("K", returnedArr[5]);
        assertEquals("L", returnedArr[6]);
        assertEquals("M", returnedArr[7]);
        assertEquals("O", returnedArr[8]);
        assertEquals("P", returnedArr[9]);
        assertEquals("Q", returnedArr[10]);
        assertEquals("R", returnedArr[11]);
        assertEquals("S", returnedArr[12]);
        assertEquals("T", returnedArr[13]);
        assertEquals("U", returnedArr[14]);
        assertEquals("X", returnedArr[15]);

    }
}
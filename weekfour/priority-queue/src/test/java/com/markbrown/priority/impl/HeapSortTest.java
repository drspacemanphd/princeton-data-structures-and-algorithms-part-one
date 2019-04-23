package com.markbrown.priority.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HeapSortTest {

    @Test
    public void testThatIntegersCanBeSorted() {

        // Setup
        Integer[] arr = { 1, 5, 3, 5, 8, 9, -2, 4 };
        HeapSort heapSort = new HeapSort();

        // Test
        Integer returnedArr[] = heapSort.sort(arr);

        // Assert
        assertEquals(-2, returnedArr[0], 0);
        assertEquals(1, returnedArr[1], 0);
        assertEquals(3, returnedArr[2], 0);
        assertEquals(4, returnedArr[3], 0);
        assertEquals(5, returnedArr[4], 0);
        assertEquals(5, returnedArr[5], 0);
        assertEquals(8, returnedArr[6], 0);
        assertEquals(9, returnedArr[7], 0);

    }
}
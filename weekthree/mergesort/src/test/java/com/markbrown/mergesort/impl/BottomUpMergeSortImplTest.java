package com.markbrown.mergesort.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class BottomUpMergeSortImplTest {

    private BottomUpMergeSortImpl mergeSortImpl;

    @Before
    public void setup() {
        mergeSortImpl = new BottomUpMergeSortImpl();
    }

    @Test
    public void testMergeSort() {
        // Setup
        Integer[] arr = { 1, -4, 6, 3, 7, 2, -6, 4, 2, 10, 0, -3 };

        // Test
        Integer[] returnedArr = mergeSortImpl.sort(arr);

        // Assert
        assertNotNull(returnedArr);
        assertEquals(-6, returnedArr[0], 0);
        assertEquals(-4, returnedArr[1], 0);
        assertEquals(-3, returnedArr[2], 0);
        assertEquals(0, returnedArr[3], 0);
        assertEquals(1, returnedArr[4], 0);
        assertEquals(2, returnedArr[5], 0);
        assertEquals(2, returnedArr[6], 0);
        assertEquals(3, returnedArr[7], 0);
        assertEquals(4, returnedArr[8], 0);
        assertEquals(6, returnedArr[9], 0);
        assertEquals(7, returnedArr[10], 0);
        assertEquals(10, returnedArr[11], 0);

    }

}
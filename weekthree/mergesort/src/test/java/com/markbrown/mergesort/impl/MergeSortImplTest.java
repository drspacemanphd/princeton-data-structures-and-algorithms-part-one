package com.markbrown.mergesort.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class MergeSortImplTest {

    private MergeSortImpl mergeSortImpl;

    @Before
    public void setup() {
        mergeSortImpl = new MergeSortImpl();
    }

    @Test
    public void testMergeSort() {
        // Setup
        Integer[] arr = {1, -4, 3, 6, 2, 7, -6, 4, 2};

        // Test
        Integer[] returnedArr = mergeSortImpl.sort(arr);

        // Assert
        assertNotNull(returnedArr);
        assertEquals(-6, returnedArr[0], 0);
        assertEquals(-4, returnedArr[1], 0);
        assertEquals(1, returnedArr[2], 0);
        assertEquals(2, returnedArr[3], 0);
        assertEquals(2, returnedArr[4], 0);
        assertEquals(3, returnedArr[5], 0);
        assertEquals(4, returnedArr[6], 0);
        assertEquals(6, returnedArr[7], 0);
        assertEquals(7, returnedArr[8], 0);

    }
}
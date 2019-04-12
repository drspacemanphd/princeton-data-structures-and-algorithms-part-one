package com.markbrown.sorts.impl;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class SelectionSortImplTest {

    private SelectionSortImpl sort;

    @Before
    public void setup() {
        sort = new SelectionSortImpl();
    }

    @Test
    public void testIntArrayCanBeSorted() {

        // Setup
        Integer[] arr = {9, -1, 3, 4, 2, 5, -3, 0};

        // Test
        Integer[] returned = sort.sort(arr);
        
        // Assert
        assertEquals(arr, returned);
        assertEquals(0, returned.length, 8);
        assertEquals(-3, returned[0], 0);
        assertEquals(-1, returned[1], 0);
        assertEquals(0, returned[2], 0);
        assertEquals(2, returned[3], 0);
        assertEquals(3, returned[4], 0);
        assertEquals(4, returned[5], 0);
        assertEquals(5, returned[6], 0);
        assertEquals(9, returned[7], 0);

    }

}
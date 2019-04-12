package com.markbrown.sorts.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ShellSortImplTest {

    private ShellSortImpl sort;

    @Before
    public void setup() {
        sort = new ShellSortImpl();
    }

    @Test
    public void testIntArrayCanBeSorted() {

        // Setup
        Integer[] arr = { 9, -1, 3, 4, 2, 5, -3, 0 };

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

    @Test
    public void testStringArrayCanBeSorted() {

        // Setup
        String[] arr = { "BLUE", "GREEN", "AZALEA", "BLACK", "PURPLE", "MAROON", "CYAN", "NEON" };

        // Test
        String[] returned = sort.sort(arr);

        // Assert
        assertEquals(arr, returned);
        assertEquals(0, returned.length, 8);
        assertEquals("AZALEA", returned[0]);
        assertEquals("BLACK", returned[1]);
        assertEquals("BLUE", returned[2]);
        assertEquals("CYAN", returned[3]);
        assertEquals("GREEN", returned[4]);
        assertEquals("MAROON", returned[5]);
        assertEquals("NEON", returned[6]);
        assertEquals("PURPLE", returned[7]);

    }

}
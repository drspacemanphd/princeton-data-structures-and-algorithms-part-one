package com.markbrown.quicksort.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class QuickSelectTest {

    private QuickSelect quickSelect;

    @Before
    public void setup() {
        quickSelect = new QuickSelect();
    }

    @Test
    public void testThatFirstElementCanBeObtained() {
        // Setup
        Integer[] arr = { -1, 4, 2, -3, 0, -2, -4, 1, 3 };

        // Test
        int topOneth = quickSelect.selectMth(arr, 1);

        // Assert
        assertEquals(4, topOneth, 0);
    }

    @Test
    public void testThatSecondElementCanBeObtained() {
        // Setup
        Integer[] arr = { -1, 4, 2, -3, 0, -2, -4, 1, 3 };

        // Test
        int number = quickSelect.selectMth(arr, 2);

        // Assert
        assertEquals(3, number, 0);
    }

    @Test
    public void testThatMiddleElementCanBeObtained() {
        // Setup
        Integer[] arr = { -1, 4, 2, -3, 0, -2, -4, 1, 3 };

        // Test
        int number = quickSelect.selectMth(arr, 5);

        // Assert
        assertEquals(0, number, 0);
    }

    @Test
    public void testThatLastElementCanBeObtained() {
        // Setup
        Integer[] arr = { -1, 4, 2, -3, 0, -2, -4, 1, 3 };

        // Test
        int number = quickSelect.selectMth(arr, 9);

        // Assert
        assertEquals(-4, number, 0);
    }
}
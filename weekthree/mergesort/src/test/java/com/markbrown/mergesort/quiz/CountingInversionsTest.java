package com.markbrown.mergesort.quiz;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CountingInversionsTest {

    private CountingInversions countingInversions;

    @Before
    public void setup() {
        countingInversions = new CountingInversions();
    }

    @Test
    public void testThatInversionsCanBeCountedOne() {

        // Setup
        String[] arr = {"A", "B", "C", "D", "E"};

        // Test
        long inversions = countingInversions.countInversions(arr, String.CASE_INSENSITIVE_ORDER);

        // Assert
        assertEquals(0, inversions, 0);

    }

    @Test
    public void testThatInversionsCanBeCountedTwo() {

        // Setup
        String[] arr = { "E", "D", "C", "B", "A" };

        // Test
        long inversions = countingInversions.countInversions(arr, String.CASE_INSENSITIVE_ORDER);

        // Assert
        assertEquals(10, inversions, 0);

    }
}
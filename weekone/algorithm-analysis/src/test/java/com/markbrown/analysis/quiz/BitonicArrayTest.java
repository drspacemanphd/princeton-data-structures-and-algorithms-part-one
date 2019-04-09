package com.markbrown.analysis.quiz;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BitonicArrayTest {

    @Test
    public void testThatBitonicArrayCanBeSearchedOne() {
        // Setup
        BitonicArray array = new BitonicArray();
        int[] test = {1, 2, 3, 4, 8, 2, 1, 0};

        // Test
        boolean result = array.doesNumberExist(test, 3);
        boolean resultTwo = array.doesNumberExist(test, 7);

        // Assert
        assertTrue(result);
        assertFalse(resultTwo);

    }

}
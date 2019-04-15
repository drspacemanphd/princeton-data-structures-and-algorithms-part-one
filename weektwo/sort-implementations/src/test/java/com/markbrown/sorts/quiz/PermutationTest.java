package com.markbrown.sorts.quiz;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PermutationTest {

    private Permutation permutation;

    @Before
    public void setup() {
        permutation = new Permutation();
    }

    @Test
    public void testThatPermutationsCanBeProperlyDetermined() {
        // Setup
        Integer[] arrOne = {1, -4, 2, -3, 1, 4, 3};
        Integer[] arrTwo = {-4, 2, 1, 1, -3, 3, 4};

        String[] arrThree = { "BLACK", "BLUE", "RED", "GREEN" };
        String[] arrFour = { "GREEN", "BLUE", "ORANGE", "RED" };

        // Test
        boolean resultOne = permutation.arePermutations(arrOne, arrTwo);
        boolean resultTwo = permutation.arePermutations(arrThree, arrFour);
        
        // Assert
        assertTrue(resultOne);
        assertFalse(resultTwo);
    }
}
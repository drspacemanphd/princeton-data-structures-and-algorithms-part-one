package com.markbrown.priority.quiz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DynamicMedianTest {

    @Test
    public void testDyanmicMedianWithIntegers() {

        // Setup
        DynamicMedian<Integer> dynamicMed = new DynamicMedian<>();

        dynamicMed.insert(4);
        dynamicMed.insert(-2);
        dynamicMed.insert(2);
        dynamicMed.insert(9);

        Integer medianOne = dynamicMed.getMedian();
        assertEquals(2, medianOne, 0);

        dynamicMed.insert(5);
        Integer medianTwo = dynamicMed.getMedian();
        assertEquals(4, medianTwo, 0);

        dynamicMed.insert(6);
        Integer medianThree = dynamicMed.getMedian();
        assertEquals(4, medianThree, 0);

        dynamicMed.insert(7);
        Integer medianFour = dynamicMed.getMedian();
        assertEquals(5, medianFour, 0);

    }
}
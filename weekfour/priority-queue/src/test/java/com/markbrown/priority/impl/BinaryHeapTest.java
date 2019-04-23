package com.markbrown.priority.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinaryHeapTest {

    @Test
    public void testPriorityQueueOfIntegers() {
        // Setup
        BinaryHeap<Integer> queue = new BinaryHeap<>();

        queue.insert(1);
        queue.insert(5);
        queue.insert(3);
        queue.insert(5);
        queue.insert(8);
        queue.insert(9);
        queue.insert(-2);
        queue.insert(4);
        assertEquals(8, queue.size(), 0);
        assertFalse(queue.isEmpty());

        // Test
        Integer removedOne = queue.removeMax();
        assertEquals(9, removedOne, 0);
        assertEquals(7, queue.size(), 0);
        assertFalse(queue.isEmpty());

        Integer removedTwo = queue.removeMax();
        assertEquals(8, removedTwo, 0);
        assertEquals(6, queue.size(), 0);
        assertFalse(queue.isEmpty());

        Integer removedThree = queue.removeMax();
        assertEquals(5, removedThree, 0);
        assertEquals(5, queue.size(), 0);
        assertFalse(queue.isEmpty());

        Integer removedFour = queue.removeMax();
        assertEquals(5, removedFour, 0);
        assertEquals(4, queue.size(), 0);
        assertFalse(queue.isEmpty());

        Integer removedFive = queue.removeMax();
        assertEquals(4, removedFive, 0);
        assertEquals(3, queue.size(), 0);
        assertFalse(queue.isEmpty());

        Integer removedSix = queue.removeMax();
        assertEquals(3, removedSix, 0);
        assertEquals(2, queue.size(), 0);
        assertFalse(queue.isEmpty());

        Integer removedSeven = queue.removeMax();
        assertEquals(1, removedSeven, 0);
        assertEquals(1, queue.size(), 0);
        assertFalse(queue.isEmpty());

        Integer removedEight = queue.removeMax();
        assertEquals(-2, removedEight, 0);
        assertEquals(0, queue.size(), 0);
        assertTrue(queue.isEmpty());

        queue.insert(-3);
        assertEquals(1, queue.size(), 0);
        assertFalse(queue.isEmpty());
    }
}
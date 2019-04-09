package com.markbrown.sbq.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArrayQueueImplTest {

    @Test
    public void testThatQueueCanBeCreatedBasedOnList() {

        ArrayQueueImpl<String> queue = new ArrayQueueImpl<String>();
        queue.enqueue("Hello ");
        queue.enqueue("World! ");
        queue.enqueue("I ");
        queue.enqueue("Am ");
        queue.enqueue("Mark");

        assertEquals(5, queue.size(), 0);

        String poppedOne = queue.dequeue();
        assertEquals("Hello ", poppedOne);
        assertEquals(4, queue.size(), 0);

        String poppedTwo = queue.dequeue();
        assertEquals("World! ", poppedTwo);
        assertEquals(3, queue.size(), 0);

        String poppedThree = queue.dequeue();
        assertEquals("I ", poppedThree);
        // assertEquals(2, stack.size(), 0);

        String poppedFour = queue.dequeue();
        assertEquals("Am ", poppedFour);
        assertEquals(1, queue.size(), 0);
        assertFalse(queue.isEmpty());

        String poppedFive = queue.dequeue();
        assertEquals("Mark", poppedFive);
        assertEquals(0, queue.size(), 0);
        assertTrue(queue.isEmpty());

        String poppedSix = queue.dequeue();
        assertNull(poppedSix);
        assertEquals(0, queue.size(), 0);

        queue.enqueue("ANOTHER");
        assertEquals(1, queue.size(), 0);
        assertEquals("ANOTHER", queue.dequeue());

    }
    
}
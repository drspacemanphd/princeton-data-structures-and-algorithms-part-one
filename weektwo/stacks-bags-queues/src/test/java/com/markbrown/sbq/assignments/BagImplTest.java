package com.markbrown.sbq.assignments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BagImplTest {

    private Bag<String> bag;

    @Before
    public void setup() {
        bag = new BagImpl<>();
    }

    @Test
    public void testDequeueImpl() {

        assertEquals(0, bag.size(), 0);
        assertTrue(bag.isEmpty());

        bag.enqueue("BLACK");
        bag.enqueue("BLUE");
        bag.enqueue("RED");
        bag.enqueue("WHITE");
        bag.enqueue("GREEN");

        assertEquals(5, bag.size(), 0);
        assertFalse(bag.isEmpty());

        String one = bag.dequeue();

        assertEquals(4, bag.size(), 0);
        assertFalse(bag.isEmpty());

        String two = bag.dequeue();
        assertEquals(3, bag.size(), 0);
        assertFalse(bag.isEmpty());

        String three = bag.dequeue();

        assertEquals(2, bag.size(), 0);
        assertFalse(bag.isEmpty());

        String four = bag.dequeue();

        assertEquals(1, bag.size(), 0);
        assertFalse(bag.isEmpty());

        String five = bag.dequeue();

        assertEquals(0, bag.size(), 0);
        assertTrue(bag.isEmpty());

    }

}
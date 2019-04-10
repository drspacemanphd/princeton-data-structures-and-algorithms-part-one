package com.markbrown.sbq.assignments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DequeueImplTest {

    private DequeueImpl<String> dequeue;

    @Before
    public void setup() {
        dequeue = new DequeueImpl<>();
    }

    @Test
    public void testDequeueImpl() {

        assertEquals(0, dequeue.size(), 0);
        assertTrue(dequeue.isEmpty());

        dequeue.addFirst("BLACK");
        dequeue.addLast("BLUE");
        dequeue.addFirst("RED");
        dequeue.addLast("WHITE");
        dequeue.addLast("GREEN");
        dequeue.addFirst("ORANGE");

        assertEquals(6, dequeue.size(), 0);
        assertFalse(dequeue.isEmpty());

        String one = dequeue.removeFirst();
        assertEquals("ORANGE", one);
        assertEquals(5, dequeue.size(), 0);
        assertFalse(dequeue.isEmpty());

        String two = dequeue.removeLast();
        assertEquals("GREEN", two);
        assertEquals(4, dequeue.size(), 0);
        assertFalse(dequeue.isEmpty());

        String three = dequeue.removeLast();
        assertEquals("WHITE", three);
        assertEquals(3, dequeue.size(), 0);
        assertFalse(dequeue.isEmpty());

        String four = dequeue.removeLast();
        assertEquals("BLUE", four);
        assertEquals(2, dequeue.size(), 0);
        assertFalse(dequeue.isEmpty());

        String five = dequeue.removeFirst();
        assertEquals("RED", five);
        assertEquals(1, dequeue.size(), 0);
        assertFalse(dequeue.isEmpty());

        String six = dequeue.removeLast();
        assertEquals("BLACK", six);
        assertEquals(0, dequeue.size(), 0);
        assertTrue(dequeue.isEmpty());

    }
}
package com.markbrown.sbq.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class LinkedListStackImplTest {

    @Test
    public void testThatStackCanBeCreatedBasedOnArray() {

        LinkedListStackImpl<String> stack = new LinkedListStackImpl<String>();
        stack.push("Hello ");
        stack.push("World! ");
        stack.push("I ");
        stack.push("Am ");
        stack.push("Mark");

        assertEquals(5, stack.size(), 0);

        String poppedOne = stack.pop();
        assertEquals("Mark", poppedOne);
        assertEquals(4, stack.size(), 0);

        String poppedTwo = stack.pop();
        assertEquals("Am ", poppedTwo);
        assertEquals(3, stack.size(), 0);

        String poppedThree = stack.pop();
        assertEquals("I ", poppedThree);
        // assertEquals(2, stack.size(), 0);

        String poppedFour = stack.pop();
        assertEquals("World! ", poppedFour);
        assertEquals(1, stack.size(), 0);

        String poppedFive = stack.pop();
        assertEquals("Hello ", poppedFive);
        assertEquals(0, stack.size(), 0);

        String poppedSix = stack.pop();
        assertNull(poppedSix);
        assertEquals(0, stack.size(), 0);

        stack.push("ANOTHER");
        assertEquals(1, stack.size(), 0);
        assertEquals("ANOTHER", stack.pop());

    }
}
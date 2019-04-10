package com.markbrown.sbq.quiz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class MaxStackListImplTest {

    public MaxStackListImpl<Integer> stack;

    @Before
    public void setup() {
        stack = new MaxStackListImpl<>();
    }

    @Test
    public void testMaxStackListImpl() {

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size(), 0);
        
        stack.push(1);
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(0);
        assertEquals(5, stack.size(), 0);
        assertFalse(stack.isEmpty());
        assertEquals(5, stack.getMax(), 0);
        assertEquals(0, stack.getMin(), 0);

        Integer poppedOne = stack.pop();
        assertEquals(0, poppedOne, 0);
        assertEquals(4, stack.size(), 0);
        assertFalse(stack.isEmpty());
        
        Integer poppedTwo = stack.pop();
        assertEquals(3, poppedTwo, 0);
        assertEquals(3, stack.size(), 0);
        assertFalse(stack.isEmpty());

        Integer poppedThree = stack.pop();
        assertEquals(2, poppedThree, 0);
        assertEquals(2, stack.size(), 0);
        assertFalse(stack.isEmpty());

        Integer poppedFour = stack.pop();
        assertEquals(5, poppedFour, 0);
        assertEquals(1, stack.size(), 0);
        assertFalse(stack.isEmpty());

        Integer poppedFive = stack.pop();
        assertEquals(1, poppedFive, 0);
        assertEquals(0, stack.size(), 0);
        assertTrue(stack.isEmpty());

    }

    @Test(expected = NoSuchElementException.class)
    public void testThatExceptionIsThrownWhenPoppingEmptyStack() {

        assertTrue(stack.isEmpty());
        stack.pop();

    }

    @Test(expected = NoSuchElementException.class)
    public void testThatExceptionIsThrownWhenGettingMaxOfEmptyStack() {

        assertTrue(stack.isEmpty());
        stack.getMax();

    }

    @Test(expected = NoSuchElementException.class)
    public void testThatExceptionIsThrownWhenGettingMinOfEmptyStack() {

        assertTrue(stack.isEmpty());
        stack.getMin();

    }
}
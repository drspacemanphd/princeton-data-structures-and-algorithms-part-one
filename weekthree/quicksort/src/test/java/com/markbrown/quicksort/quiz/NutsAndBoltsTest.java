package com.markbrown.quicksort.quiz;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NutsAndBoltsTest {

    private NutsAndBolts nutsAndBolts;

    @Before
    public void setup() {
        nutsAndBolts = new NutsAndBolts();
    }

    @Test
    public void testNutsAndBoltsOne() {
        Integer[] nuts = { 2, 0, 3, 4, 1};
        Integer[] bolts = { 1, 4, 2, 0, 3 };

        nutsAndBolts.pair(nuts, bolts);

        assertEquals(0, nuts[0], 0);
        assertEquals(1, nuts[1], 0);
        assertEquals(2, nuts[2], 0);
        assertEquals(3, nuts[3], 0);
        assertEquals(4, nuts[4], 0);
        
        assertEquals(0, bolts[0], 0);
        assertEquals(1, bolts[1], 0);
        assertEquals(2, bolts[2], 0);
        assertEquals(3, bolts[3], 0);
        assertEquals(4, bolts[4], 0);
    }

    @Test
    public void testNutsAndBoltsTwo() {
        Character[] nuts = { '@', '#', '$', '%', '^', '&' };
        Character[] bolts = {'$', '%', '&', '^', '@', '#'};

        nutsAndBolts.pair(nuts, bolts);

        assertEquals('#', nuts[0], 0);
        assertEquals('$', nuts[1], 0);
        assertEquals('%', nuts[2], 0);
        assertEquals('&', nuts[3], 0);
        assertEquals('@', nuts[4], 0);
        assertEquals('^', nuts[5], 0);

        assertEquals('#', bolts[0], 0);
        assertEquals('$', bolts[1], 0);
        assertEquals('%', bolts[2], 0);
        assertEquals('&', bolts[3], 0);
        assertEquals('@', bolts[4], 0);
        assertEquals('^', bolts[5], 0);

    }
}
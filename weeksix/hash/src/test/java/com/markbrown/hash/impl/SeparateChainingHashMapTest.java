package com.markbrown.hash.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.markbrown.hash.impl.SeparateChainingHashMap;

import org.junit.Test;

public class SeparateChainingHashMapTest {

    @Test
    public void testHashMap() {

        SeparateChainingHashMap<String, Integer> symTable = new SeparateChainingHashMap<>();

        assertTrue(symTable.isEmpty());

        symTable.put("ONE", 1);
        symTable.put("EIGHT", 8);
        symTable.put("NINE", 9);
        symTable.put("FOURTEEN", 14);
        symTable.put("GOOGLE", Integer.MAX_VALUE);
        symTable.put("ONE", -1);

        assertFalse(symTable.isEmpty());
        assertEquals(5, symTable.size(), 0);
        assertEquals(symTable.get("ONE"), -1, 0);
        assertEquals(symTable.get("EIGHT"), 8, 0);
        assertEquals(symTable.get("NINE"), 9, 0);
        assertEquals(symTable.get("FOURTEEN"), 14, 0);
        assertEquals(symTable.get("GOOGLE"), Integer.MAX_VALUE, 0);

        symTable.delete("A DUMMY");
        assertFalse(symTable.isEmpty());
        assertEquals(5, symTable.size(), 0);

        symTable.delete("GOOGLE");
        assertFalse(symTable.isEmpty());
        assertEquals(4, symTable.size(), 0);

        symTable.delete("ONE");
        assertFalse(symTable.isEmpty());
        assertEquals(3, symTable.size(), 0);

        symTable.delete("EIGHT");
        assertFalse(symTable.isEmpty());
        assertEquals(2, symTable.size(), 0);

        symTable.delete("FOURTEEN");
        assertFalse(symTable.isEmpty());
        assertEquals(1, symTable.size(), 0);

        symTable.delete("NINE");
        assertTrue(symTable.isEmpty());
        assertEquals(0, symTable.size(), 0);

        symTable.delete("NINE");
        assertTrue(symTable.isEmpty());
        assertEquals(0, symTable.size(), 0);
    }
}
package com.markbrown.symbol.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArraySymbolTableImplTest {

    @Test
    public void testSymbolMap() {

        ArraySymbolTableImpl<String, Integer> symTable = new ArraySymbolTableImpl<>();

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
        assertTrue(symTable.contains("ONE"));
        assertTrue(symTable.contains("EIGHT"));
        assertTrue(symTable.contains("NINE"));
        assertTrue(symTable.contains("FOURTEEN"));
        assertTrue(symTable.contains("GOOGLE"));

        assertEquals("ONE", symTable.max());
        assertEquals("EIGHT", symTable.min());

        symTable.remove("GOOGLE");
        assertEquals(4, symTable.size(), 0);
        assertNull(symTable.get("GOOGLE"));

        symTable.remove("ONE");
        assertEquals(3, symTable.size(), 0);
        assertNull(symTable.get("ONE"));
        assertEquals("NINE", symTable.max());

    }
}
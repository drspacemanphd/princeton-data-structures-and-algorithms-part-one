package com.markbrown.symbol.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class LinkedListSymbolTableImplTest {

    @Test
    public void testSymbolTableOne() {

        LinkedListSymbolTableImpl<String, Integer> symTable = new LinkedListSymbolTableImpl<>();

        symTable.put("ONE", 1);
        symTable.put("TWO", 2);
        symTable.put("THREE", 3);
        symTable.put("FOUR", 4);
        symTable.put("FIVE", 5);

        assertEquals(1, symTable.find("ONE"), 0);
        assertEquals(2, symTable.find("TWO"), 0);
        assertEquals(3, symTable.find("THREE"), 0);
        assertEquals(4, symTable.find("FOUR"), 0);
        assertEquals(5, symTable.find("FIVE"), 0);

        assertEquals(5, symTable.size(), 0);

        symTable.delete("THREE");
        assertEquals(4, symTable.size(), 0);
        assertNull(symTable.find("THREE"));

    }

}
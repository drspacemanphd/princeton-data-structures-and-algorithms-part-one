package com.markbrown.balanced;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RedBlackBSTTest {

    @Test
    public void testRedBlack() {

        RedBlackBST<String, Integer> symTable = new RedBlackBST<>();

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

    }
}
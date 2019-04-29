package com.markbrown.symbol;

import com.markbrown.symbol.impl.BinarySearchTree;

public class App {

    public static void main(String[] args) {

        BinarySearchTree<String, Integer> symTable = new BinarySearchTree<>();

        symTable.put("ONE", 1);
        symTable.put("EIGHT", 8);
        symTable.put("NINE", 9);
        symTable.put("FOURTEEN", 14);
        symTable.put("GOOGLE", Integer.MAX_VALUE);
        symTable.put("ONE", -1);
        
    }
}
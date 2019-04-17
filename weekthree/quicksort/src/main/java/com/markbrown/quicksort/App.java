package com.markbrown.quicksort;

import com.markbrown.quicksort.impl.QuickSort;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new QuickSort().sort(new Integer[]{-1, 4, 2, -3, 0, -2, -4, 1, 3});
    }
}

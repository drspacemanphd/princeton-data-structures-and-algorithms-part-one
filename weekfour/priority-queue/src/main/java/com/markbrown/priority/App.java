package com.markbrown.priority;

import com.markbrown.priority.impl.BinaryHeap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BinaryHeap<Integer> queue = new BinaryHeap<>();

        queue.insert(1);
        queue.insert(5);
        queue.insert(3);
        queue.insert(5);
        queue.insert(8);
        queue.insert(9);
        queue.insert(-2);
        queue.insert(4);

        queue.removeMax();
        queue.removeMax();
        queue.removeMax();
        queue.removeMax();
        queue.removeMax();
        queue.removeMax();
        queue.removeMax();
        queue.removeMax();

    }
}

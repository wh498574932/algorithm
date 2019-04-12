package com.wh498574932.algorithm.airbnb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ImplementQueueWithFixedSizeArrayListTest {
    @Test
    public void test() {
        ImplementQueueWithFixedSizeArrayList q = new ImplementQueueWithFixedSizeArrayList(2);
        q.offer(1);
        q.print();
        assertEquals(1, q.poll());
        assertEquals(0, q.size());
        q.print();
        q.offer(2);
        q.print();
        q.offer(3);
        q.print();
        q.offer(4);
        q.print();
        q.offer(5);
        q.print();
        assertEquals(4, q.size());
        assertEquals(2, q.poll());
        q.print();
        assertEquals(3, q.poll());
        q.print();
    }
}

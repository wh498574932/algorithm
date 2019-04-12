package com.wh498574932.algorithm.airbnb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CollatzConjectureTest {
    @Test
    public void test() {
        assertEquals(19, new CollatzConjecture().maxSteps(10));
    }
}

package com.wh498574932.algorithm.lc161;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class OneEditDistanceTest {
    private final OneEditDistance subject = new OneEditDistance();

    @Test
    public void test1() {
        assertFalse(subject.isOneEditDistance("ab","acab"));
    }

    @Test
    public void test2() {
        assertFalse(subject.isOneEditDistance("abd","cbc"));
    }

    @Test
    public void test3() {
        assertFalse(subject.isOneEditDistance("123456","23457"));
    }

    @Test
    public void test4() {
        assertTrue(subject.isOneEditDistance("1234", "12345"));
    }

    @Test
    public void test5() {
        assertTrue(subject.isOneEditDistance("1234", "2234"));
    }
}

package com.haowu.leetcode.lc560;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SubarraySumEqualsKTest {
    @Test
    public void test() {
        assertEquals(2, new SubarraySumEqualsK().subarraySum(new int[]{1, 1, 1}, 2));
    }
}

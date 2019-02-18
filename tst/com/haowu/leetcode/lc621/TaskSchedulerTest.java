package com.haowu.leetcode.lc621;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskSchedulerTest {
    @Test
    public void test() {
        char[] cs = new char[]{'A','A','A','B','B','B'};
        assertEquals(8, new TaskScheduler().leastInterval(cs, 2));
    }
}

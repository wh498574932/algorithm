package com.haowu.leetcode.lc002;

import static com.haowu.leetcode.utilities.LinkedList.createLinkedList;
import static com.haowu.leetcode.utilities.LinkedList.validateTwoLinkedList;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AddTwoNumbersInNormalOrderTest {

    /**
     * 999 + 11 = 1010
     */
    @Test
    public void test() {
        assertTrue(
            validateTwoLinkedList(
                createLinkedList(new int[]{1,0,1,0}),
                new AddTwoNumbersInNormalOrder().addTwoNumbers(
                    createLinkedList(new int[]{9,9,9}),
                    createLinkedList(new int[]{1,1})
                )
            )
        );
    }
}

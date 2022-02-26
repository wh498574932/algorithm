package com.wh498574932.algorithm.lc004;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOfTwoSortedArrays_IterTest {

    @Test
    public void test() {
        assertEquals(new MedianOfTwoSortedArrays_Iter().findMedianSortedArrays(
            new int[]{1,3},
            new int[]{2}
            ), 2
        );
    }
}

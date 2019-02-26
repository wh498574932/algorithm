package com.wh498574932.algorithm.feb19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaxFontSizeFitInRectangleTest {
    @Test
    public void test() {
        assertEquals(
            8,
            new MaxFontSizeFitInRectangle().maxFontSizeFitInRectangle(
                50,
                50,
                "abcdefghijklmnopqrstuvwxyz"));
    }
}

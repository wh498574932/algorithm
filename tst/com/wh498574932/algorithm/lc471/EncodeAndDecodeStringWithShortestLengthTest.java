package com.wh498574932.algorithm.lc471;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EncodeAndDecodeStringWithShortestLengthTest {
    private static final String RAW_STRING = "abb8888dddddddddddddddddddddddd4xgkkkkk";

    private final EncodeAndDecodeStringWithShortestLength subject = new EncodeAndDecodeStringWithShortestLength();

    @Test
    public void test() {
        assertEquals(
            RAW_STRING,
            subject.decode(subject.encode(RAW_STRING))
        );
    }
}

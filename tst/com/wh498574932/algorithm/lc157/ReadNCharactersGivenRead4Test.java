package com.wh498574932.algorithm.lc157;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReadNCharactersGivenRead4Test {
    @Test
    public void test_3_chars() {
        assertEquals(
            3,
            new ReadNCharactersGivenRead4()
                .read("123".toCharArray(), 4)
        );
    }

    @Test
    public void test_5_chars() {
        assertEquals(
            4,
            new ReadNCharactersGivenRead4()
                .read("12345".toCharArray(), 4)
        );
    }

    @Test
    public void test_25_chars() {
        assertEquals(
            9,
            new ReadNCharactersGivenRead4()
                .read("12345123451234512345".toCharArray(), 9)
        );
    }
}

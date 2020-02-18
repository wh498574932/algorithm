package com.wh498574932.algorithm.lc157;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReadNCharactersGivenRead4Test {
    @Test
    public void test_3_chars() {
        char[] buf = new char[4];
        assertEquals(
            3,
            new ReadNCharactersGivenRead4("123".toCharArray())
                .read(buf, 4)
        );
        assertEquals("123", new String(buf).trim());
    }

    @Test
    public void test_4_chars() {
        char[] buf = new char[4];
        assertEquals(
            4,
            new ReadNCharactersGivenRead4("1234".toCharArray())
                .read(buf, 4)
        );
        assertEquals("1234", new String(buf).trim());
    }

    @Test
    public void test_25_chars() {
        char[] buf = new char[9];
        assertEquals(
            9,
            new ReadNCharactersGivenRead4("12345123451234512345".toCharArray())
                .read(buf, 9)
        );
        assertEquals("123451234", new String(buf).trim());
    }
}

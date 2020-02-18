package com.wh498574932.algorithm.lc158;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReadNCharactersGivenRead4IITest {
    private static final String CONTENT = "0123456789";

    private final ReadNCharactersGivenRead4II subject = new ReadNCharactersGivenRead4II(CONTENT.toCharArray());

    @Test
    public void test_4_5_6_chars() {
        char[] buf4 = new char[4];
        assertEquals(
            4,
            subject.read(buf4, 4)
        );
        assertEquals("0123", new String(buf4).trim());

        char[] buf5 = new char[5];
        assertEquals(
            5,
            subject.read(buf5, 5)
        );
        assertEquals("45678", new String(buf5).trim());

        char[] buf6 = new char[6];
        assertEquals(
            1,
            subject.read(buf6, 6)
        );
        assertEquals("9", new String(buf6).trim());
    }

    @Test
    public void test_10_chars() {
        char[] buf10 = new char[10];
        assertEquals(
            10,
            subject.read(buf10, 10)
        );
        assertEquals("0123456789", new String(buf10).trim());
    }
}

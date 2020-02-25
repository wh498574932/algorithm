package com.wh498574932.algorithm.lc159;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LongestSubstringWithAtMostTwoDistinctCharactersTest {
    private final LongestSubstringWithAtMostTwoDistinctCharacters subject =
        new LongestSubstringWithAtMostTwoDistinctCharacters();

    @Test
    public void test1() {
        assertEquals(3, subject.lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    @Test
    public void test2() {
        assertEquals(5, subject.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}

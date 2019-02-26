package com.haowu.leetcode.utilities;

import java.util.Collections;
import java.util.List;

/**
 * Utility Class for ArrayList
 */
public class ArrayList {

    /**
     * Create An {@code ArrayList} of {@code T} for given array.
     * @param ts array of {@code T}.
     * @param <T> {@code T}
     * @return {@code List} of {@code T}.
     */
    public static <T> List<T> createArrayList(T[] ts) {
        List<T> list = new java.util.ArrayList<>();
        Collections.addAll(list, ts);
        return list;
    }
}

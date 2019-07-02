package com.wh498574932.algorithm.lc077;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * Time:        4 ms        85.45%      O(N)?
 * Space:       40.6 MB     42.51%      O(N)?
 *
 * https://leetcode.com/problems/combinations/
 */
public class Combinations_Math {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (k > n || k < 0) return ret;
        if (k == 0) { ret.add(new ArrayList<>()); return ret; }
        List<List<Integer>> res = combine(n - 1, k - 1);
        for (List<Integer> a : res) a.add(n);
        for (List<Integer> a : combine(n - 1, k)) res.add(a);
        return res;
    }
}

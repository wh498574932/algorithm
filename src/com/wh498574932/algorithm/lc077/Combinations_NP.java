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
 * Time:        34 ms       25.07%      Exponential
 * Space:       39.5 MB     71.89%      Exponential
 *
 * https://leetcode.com/problems/combinations/
 */
public class Combinations_NP {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if( k < 1 || k > n ) { return ret; }
        helper( ret, new ArrayList<>(), 1, n, k );
        return ret;
    }

    private void helper(
        List<List<Integer>> ret,
        List<Integer> res,
        int start,
        int n,
        int k)
    {
        if( res.size() == k ) {
            ret.add( new ArrayList<>(res) );
            return;
        }
        for(int i = start; i <= n; ++i) {
            if( !res.contains(i) ) {
                res.add(i);
                helper( ret, res, i + 1, n, k );
                res.remove(res.size()-1);
            }
        }
    }
}

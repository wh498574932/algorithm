package com.wh498574932.algorithm.lc046;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * Time:        1 ms        99.71%      Exponential
 * Space:       35.9 MB     98.55%      Exponential
 *
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if( nums == null || nums.length < 1 ) { return ret; }
        helper( ret, new ArrayList<>(), nums );
        return ret;
    }

    private void helper(
        List<List<Integer>> ret,
        List<Integer> res,
        int[] nums)
    {
        if( res.size() == nums.length ) {
            ret.add( new ArrayList<>(res) );
        } else {
            for (int num : nums) {
                if (!res.contains(num)) {
                    res.add(num);
                    helper(ret, res, nums);
                    res.remove(res.size() - 1);
                }
            }
        }
    }
}

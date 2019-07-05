package com.wh498574932.algorithm.lc078;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * Time:        0 ms        100.00%     Exponential
 * Space:       37.6 MB     97.50%      Exponential
 *
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add( new ArrayList<>() );
        helper(ret, new ArrayList<>(), 0, nums);
        return ret;
    }

    private void helper(
        List<List<Integer>> ret,
        List<Integer> res,
        int start,
        int[] nums)
    {
        if( start == nums.length ) { return; }
        for(int i = start; i < nums.length; ++i) {
            res.add(nums[i]);
            ret.add( new ArrayList<>(res) );
            helper( ret, res, i + 1, nums );
            res.remove( res.size() - 1 );
        }
    }
}

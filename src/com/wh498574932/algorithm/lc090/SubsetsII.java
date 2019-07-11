package com.wh498574932.algorithm.lc090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * Time:        1 ms        100.00%     Exponential
 * Space:       37.3 MB     99.29%      Exponential
 *
 * https://leetcode.com/problems/subsets-ii/
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        if( nums == null || nums.length < 1 ) { return ret; }
        Arrays.sort(nums);
        helper(ret, new ArrayList<>(), 0, nums, new boolean[nums.length]);
        return ret;
    }

    private void helper(
        List<List<Integer>> ret,
        List<Integer> res,
        int start,
        int[] nums,
        boolean[] visited)
    {
        if(start == nums.length) { return; }
        for(int i = start; i < nums.length; ++i) {
            if(i > start && nums[i] == nums[i-1] && !visited[i-1]) { continue; }
            res.add(nums[i]);
            visited[i] = true;
            ret.add(new ArrayList<>(res));
            helper(ret, res, i + 1, nums, visited);
            visited[i] = false;
            res.remove(res.size()-1);
        }
    }
}

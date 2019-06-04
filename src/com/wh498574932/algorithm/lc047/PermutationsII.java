package com.wh498574932.algorithm.lc047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * Time:        2 ms        74.40%      Exponential
 * Space:       38.4 MB     98.84%      Exponential
 *
 * https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if( nums == null || nums.length < 1 ) { return ret; }
        Arrays.sort( nums );
        helper( ret, new ArrayList<>(), nums, new boolean[nums.length] );
        return ret;
    }

    private void helper(
        List<List<Integer>> ret,
        List<Integer> res,
        int[] nums,
        boolean[] visited)
    {
        if( res.size() == nums.length ) {
            ret.add( new ArrayList<>(res) );
            return;
        }
        for(int i = 0; i < nums.length; ++i) {
            if( i > 0 && nums[i] == nums[i-1] && !visited[i-1] ) { continue; }
            if( !visited[i] ) {
                visited[i] = true;
                res.add(nums[i]);
                helper(ret, res, nums, visited);
                res.remove( res.size()-1 );
                visited[i] = false;
            }
        }
    }
}

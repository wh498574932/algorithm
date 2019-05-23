package com.wh498574932.algorithm.lc040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
 * candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * Time:        2 ms        99.97%      Exponential
 * Space:       35.7 MB     99.92%      Exponential
 *
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if( candidates == null || candidates.length < 1 || target < 1 ) { return ret; }
        Arrays.sort( candidates );
        helper( ret, new ArrayList<>(), candidates, target, 0 );
        return ret;
    }

    private void helper(
        List<List<Integer>> ret,
        List<Integer> res,
        int[] candidates,
        int target,
        int start)
    {
        if( target == 0 ) {
            ret.add( new ArrayList<>(res) );
            return;
        }
        for(int i = start; i < candidates.length; ++i) {
            if( i > start && candidates[i] == candidates[i-1] ) { continue; }
            if( candidates[i] > target ) { break; }
            res.add( candidates[i] );
            helper( ret, res, candidates, target - candidates[i], i + 1 );
            res.remove( res.size() - 1 );
        }
    }
}

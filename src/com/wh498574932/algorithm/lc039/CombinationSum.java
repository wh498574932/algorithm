package com.wh498574932.algorithm.lc039;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * Time:        2 ms        99.90%      Exponential
 * Space:       36.4 MB     98.96%      Exponential
 *
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if( candidates == null || candidates.length < 1 ) { return ret; }
        helper( ret, new ArrayList<Integer>(), candidates, target, 0 );
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
            ret.add( new ArrayList<Integer>(res) );
            return;
        }
        for(int i = start; i < candidates.length; ++i) {
            if( target < candidates[i] ) { continue; }
            res.add( candidates[i] );
            helper( ret, res, candidates, target-candidates[i], i );
            res.remove( res.size()-1 );
        }
    }
}

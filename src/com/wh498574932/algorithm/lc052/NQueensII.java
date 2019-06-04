package com.wh498574932.algorithm.lc052;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * Time:        4 ms        28.48%      Exponential
 * Space:       35.9 MB     13.38%      Exponential
 *
 * https://leetcode.com/problems/n-queens-ii/
 */
public class NQueensII {
    public int totalNQueens(int n) {
        if( n < 1 ) { return 0; }
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        int[] board = new int[n];
        boolean[] cols = new boolean[n];
        helper(ret, board, 0, n, cols, new HashSet<>(), new HashSet<>());
        return ret.get(0);
    }

    private void helper(
        List<Integer> ret,
        int[] board,
        int start,
        int n,
        boolean[] cols,
        Set<Integer> sum,
        Set<Integer> diff)
    {
        if( start == n ) {
            ret.set(0, ret.get(0) + 1);
            return;
        }
        for(int i = 0; i < n; ++i) {
            if( !cols[i] && !sum.contains(start+i) && !diff.contains(start-i) ) {
                cols[i] = true;
                sum.add(start+i);
                diff.add(start-i);
                board[start] = i;
                helper( ret, board, start + 1, n, cols, sum, diff );
                cols[i] = false;
                sum.remove(start+i);
                diff.remove(start-i);
                board[start] = 0;
            }
        }
    }
}

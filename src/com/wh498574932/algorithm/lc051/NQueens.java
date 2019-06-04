package com.wh498574932.algorithm.lc051;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
 * queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
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
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 *
 * Time:        5 ms        43.28%      Exponential
 * Space:       38.4 MB     71.67%      Exponential
 *
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        if( n < 1 ) { return ret; }
        int[] board = new int[n];
        boolean[] cols = new boolean[n];
        helper(ret, board, 0, n, cols, new HashSet<>(), new HashSet<>());
        return ret;
    }

    private void helper(
        List<List<String>> ret,
        int[] board,
        int start,
        int n,
        boolean[] cols,
        Set<Integer> sum,
        Set<Integer> diff)
    {
        if( start == n ) {
            ret.add( toList(board, n) );
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

    private List<String> toList(int[] board, int n) {
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; ++j) {
                sb.append( board[i] == j ? 'Q' : '.' );
            }
            ret.add( sb.toString() );
        }
        return ret;
    }
}

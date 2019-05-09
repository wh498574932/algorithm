package com.wh498574932.algorithm.lc022;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * Time:        1 ms        96.06%      O(2^N)
 * Space:       37.4 MB     95.79%      O(2^N)
 *
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if( n < 1 ) { return ret; }
        helper( ret, "", 0, 0, n );
        return ret;
    }

    private void helper(List<String> ret, String res, int l, int r, int n) {
        if( l == n && r == n ) {
            ret.add( res );
        }
        else if( l == n ) {
            helper( ret, res + ")", l, r + 1, n );
        }
        else if( l == r ) {
            helper( ret, res + "(", l + 1, r, n );
        }
        else if( l > r ){
            helper( ret, res + "(", l + 1, r, n );
            helper( ret, res + ")", l, r + 1, n );
        }
    }
}

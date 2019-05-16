package com.wh498574932.algorithm.lc032;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 * Time:        6 ms        77.89%      O(N)
 * Space:       36.1 MB     95.76%      O(N)
 *
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if( s == null || s.length() < 2 ) { return 0; }
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        for(int start = 0, i = 0; i < s.length(); ++i) {
            if( s.charAt(i) == ')' ) {
                if( stack.isEmpty() ) {
                    start = i + 1;
                } else {
                    stack.pop();
                    ret = Math.max( ret, stack.isEmpty() ? i - start + 1 : i - stack.peek() );
                }
            } else {
                stack.push(i);
            }
        }
        return ret;
    }
}

package com.wh498574932.algorithm.lc020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 *
 * Time:        2 ms        83.71%      O(N)
 * Space:       33.5 MB     100.00%        O(N)
 *
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if( s == null ) { return false; }
        if( s.length() < 1 ) { return true; }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if( map.containsKey(c) ) {
                if( stack.isEmpty() || stack.pop() != map.get(c) ) { return false; }
            } else {
                stack.push( c );
            }
        }
        return stack.isEmpty();
    }
}

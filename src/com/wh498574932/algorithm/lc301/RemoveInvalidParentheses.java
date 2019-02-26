package com.wh498574932.algorithm.lc301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();
        if(s.length() < 1) {
            ret.add(s);
            return ret;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(s);
        set.add(s);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                String string = queue.poll();
                if(isValid(string)) {
                    ret.add(string);
                } else {
                    for(int j = 0; j < string.length(); ++j) {
                        if(string.charAt(j) == '(' || string.charAt(j) == ')') {
                            String newString = string.substring(0, j) + string.substring(j+1);
                            if(!set.contains(newString)) {
                                set.add(newString);
                                queue.offer(newString);
                            }
                        }
                    }
                }
            }
            if(!ret.isEmpty()) {
                return ret;
            }
        }
        return ret;
    }

    private boolean isValid(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') {
                cnt++;
            } else if(s.charAt(i) == ')') {
                cnt--;
            }
            if(cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
}
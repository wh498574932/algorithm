package com.wh498574932.algorithm.lc003;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Time:    14 ms       89.56%
 * Space:   37.9 MB     39.63%
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1) {
            return 0;
        }
        int l = 0, r = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while(r < s.length()) {
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r++));
            max = Math.max(max, set.size());
        }
        return max;
    }
}

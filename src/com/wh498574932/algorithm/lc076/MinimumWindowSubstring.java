package com.wh498574932.algorithm.lc076;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity
 * O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * Time:        20 ms       48.99%      O(N)
 * Space:       38.2 MB     90.02%      O(1)
 *
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if( s == null || t == null || s.length() < 1 ) { return ""; }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); ++i) {
            map.put( t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1 );
        }
        int l = 0, r = 0, count = 0, min = Integer.MAX_VALUE;
        String ret = "";
        while( r < s.length() ) {
            char c = s.charAt(r);
            if( map.containsKey(c) ) {
                map.put( c, map.get(c) - 1 );
                if( map.get(c) >= 0 ) { count++; }
                while( count == t.length() ) {
                    if( r - l + 1 < min ) {
                        min = r - l + 1;
                        ret = s.substring( l, r + 1 );
                    }
                    char left = s.charAt(l);
                    if( map.containsKey(left) ) {
                        map.put( left, map.get(left) + 1 );
                        if(map.get(left) > 0) { count--; }
                    }
                    l++;
                }
            }
            r++;
        }
        return ret;
    }
}

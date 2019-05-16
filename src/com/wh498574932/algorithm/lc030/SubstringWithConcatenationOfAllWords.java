package com.wh498574932.algorithm.lc030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of
 * substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * Example 1:
 *
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 * Example 2:
 *
 * Input:
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * Output: []
 *
 * Time:        11 ms       89.06%      O(N)
 * Space:       38.8 MB     91.52%      O(N)
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        if( s == null || s.length() < 1 || words == null || words.length < 1 ) {
            return ret;
        }
        Map<String, Integer> dict = new HashMap<>();
        for(String word : words) {
            dict.put( word, dict.getOrDefault( word, 0 ) + 1 );
        }
        int len = words[0].length();
        for(int start = 0; start < len; ++start) {
            Map<String, Integer> map = new HashMap<>();
            for(int l = start, r = start; r <= s.length()-len; r += len) {
                String curr = s.substring( r, r + len );
                if(dict.containsKey(curr)) {
                    while( dict.get(curr) == map.getOrDefault(curr, 0) ) {
                        String remove = s.substring( l, l + len );
                        map.put( remove, map.get(remove) - 1 );
                        l += len;
                    }
                    map.put( curr, map.getOrDefault(curr, 0) + 1 );
                    if( map.equals(dict) ) {
                        ret.add(l);
                        String remove = s.substring( l, l + len );
                        map.put( remove, map.get(remove) - 1 );
                        l += len;
                    }
                } else {
                    map.clear();
                    l = r + len;
                }
            }
        }
        return ret;
    }
}

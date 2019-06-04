package com.wh498574932.algorithm.lc049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 * Time:        9 ms        83.78%      O(M*NlogN)
 * Space:       44.2 MB     40.34%      O(M)
 *
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        if( strs == null || strs.length < 1 ) { return ret; }
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            List<String> value = map.getOrDefault( key, new ArrayList<>() );
            value.add( str );
            map.put( key, value );
        }
        ret.addAll(map.values());
        return ret;
    }
}

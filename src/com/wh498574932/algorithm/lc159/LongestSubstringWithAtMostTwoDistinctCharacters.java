package com.wh498574932.algorithm.lc159;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() < 1) { return 0; }
        final Map<Character, Integer> map = new HashMap<>();
        int unique = 0, max = 0;
        int l = 0, r = 0;
        while(r <= s.length()) {
            while(unique > 2) {
                char cLeft = s.charAt(l++);
                map.put(cLeft, map.get(cLeft) - 1);
                if(map.get(cLeft) == 0) { unique--; }
            }
            max = Math.max(max, r - l);
            if( r == s.length() ) { break; }
            char c = s.charAt(r++);
            int rNum = map.getOrDefault(c, 0);
            if( rNum == 0 ) {
                unique++;
            }
            map.put(c, rNum + 1);
        }
        return max;
    }
}

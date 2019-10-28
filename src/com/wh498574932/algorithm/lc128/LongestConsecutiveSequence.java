package com.wh498574932.algorithm.lc128;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Time:        6 ms        84.09%      O(N)
 * Space:       37.8 MB     68.97%      O(N)
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if( nums == null || nums.length < 1 ) { return 0; }
        Set<Integer> set = new HashSet<>();
        for(int num : nums) { set.add(num); }
        int ret = 0;
        while( !set.isEmpty() ) {
            Iterator<Integer> iter = set.iterator();
            if( iter.hasNext() ) {
                int val = iter.next();
                iter.remove();
                int cnt = 1;
                for(int plus = val + 1; set.contains(plus); ++plus,++cnt) { set.remove(plus); }
                for(int minus = val - 1; set.contains(minus); --minus,++cnt) { set.remove(minus); }
                ret = Math.max( ret, cnt );
            }
        }
        return ret;
    }
}
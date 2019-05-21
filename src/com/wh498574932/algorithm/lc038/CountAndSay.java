package com.wh498574932.algorithm.lc038;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 *
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 *
 * Time:        1 ms        99.29%      O(N*M)
 * Space:       33.5 MB     100.00%     O(N)
 *
 * https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 1) { return "1"; }
        String pre = countAndSay(n - 1);
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i <= pre.length(); ++i ) {
            if( i == pre.length() || i > 0 && pre.charAt(i) != pre.charAt(i - 1) ) {
                sb.append(cnt);
                sb.append(pre.charAt(i - 1));
                cnt = 1;
            } else {
                cnt++;
            }
        }
        return sb.toString();
    }
}

package com.wh498574932.algorithm.lc093;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 *
 * Time:        1 ms        100.00%     Exponential
 * Space:       36.2 MB     99.54%      Exponential
 *
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if( s == null || s.length() < 4 ) { return ret; }
        helper(ret, "", 0, 0, s);
        return ret;
    }

    private void helper(
        List<String> ret,
        String res,
        int num,
        int start,
        String s)
    {
        if( num == 4 && start == s.length() ) { ret.add(res); return; }
        if( num == 4 || start == s.length() ) { return; }
        char c0 = s.charAt(start);
        String s0 = (num == 0 ? "" : ".") + c0;
        helper( ret, res + s0, num + 1, start + 1, s );
        if( c0 != '0' && start + 1 < s.length() )
        {
            char c1 = s.charAt(start + 1);
            String s1 = (num == 0 ? "" : ".") + s.substring(start, start + 2);
            helper( ret, res + s1, num + 1, start + 2, s );
            if( start + 2 < s.length() &&
                ( c0 == '1' || c0 == '2' && (c1 < '5' || c1 == '5' && s.charAt(start+2) <= '5') ) )
            {
                char c2 = s.charAt(start + 2);
                String s2 = (num == 0 ? "" : ".") + s.substring(start, start + 3);
                helper( ret, res + s2, num + 1, start + 3, s );
            }
        }
    }
}

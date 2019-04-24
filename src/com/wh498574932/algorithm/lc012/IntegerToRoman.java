package com.wh498574932.algorithm.lc012;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which
 * is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same
 * principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: 3
 * Output: "III"
 *
 * Example 2:
 *
 * Input: 4
 * Output: "IV"
 *
 * Example 3:
 *
 * Input: 9
 * Output: "IX"
 *
 * Example 4:
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 *
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * Time:        9 ms        63.90%      O(N)
 * Space:       41.4 MB     16.79%      O(1)
 *
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        int div = 1000;
        StringBuilder sb = new StringBuilder();
        Map<Integer, Map<Integer, Character>> map = map();
        while(div > 0) {
            sb.append( helper(map.get(div), num/div) );
            num %= div;
            div /= 10;
        }
        return sb.toString();
    }

    private Map<Integer, Map<Integer, Character>> map() {
        Map<Integer, Map<Integer, Character>> map = new HashMap<>();
        map.put(1000, digit('M', 'M', 'M'));
        map.put(100, digit('C', 'D', 'M'));
        map.put(10, digit('X', 'L', 'C'));
        map.put(1, digit('I', 'V', 'X'));
        return map;
    }

    private Map<Integer, Character> digit(char one, char five, char ten) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, one);
        map.put(5, five);
        map.put(10, ten);
        return map;
    }

    private String helper(Map<Integer, Character> digit, int val) {
        StringBuilder sb = new StringBuilder();
        if(val < 4) {
            while(val-- > 0) { sb.append(digit.get(1)); }
        }
        else if(val == 4) {
            sb.append(digit.get(1));
            sb.append(digit.get(5));
        }
        else if(val < 9) {
            sb.append(digit.get(5));
            while(val-- > 5) { sb.append(digit.get(1)); }
        }
        else if(val == 9) {
            sb.append(digit.get(1));
            sb.append(digit.get(10));
        }
        return sb.toString();
    }
}

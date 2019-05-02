package com.wh498574932.algorithm.lc017;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any
 * letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * Time:        0 ms        100.00%     O(M^N) (exponential)
 * Space:       37 MB       88.90%      O(M^N) (exponential)
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if(digits == null || digits.length() < 1) { return ret; }
        helper(digits, ret, "", 0, new String[]{
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        });
        return ret;
    }

    private void helper(
        String digits,
        List<String> ret,
        String res,
        int start,
        String[] buttons)
    {
        if(start == digits.length()) {
            ret.add(res);
        } else {
            String s = buttons[digits.charAt(start)-'2'];
            for( int i = 0; i < s.length(); ++i ) {
                helper( digits, ret, res + s.charAt(i), start + 1, buttons );
            }
        }
    }
}

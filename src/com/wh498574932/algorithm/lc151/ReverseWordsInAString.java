package com.wh498574932.algorithm.lc151;

/**
 * Given an input string, reverse the string word by word.
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Note:
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Time:        1 ms        99.80%      O(N)
 * Space:       41.1 MB     5.37%       O(N)
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if(s == null) { return null; }
        s = s.trim();
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; --i) {
            if(strs[i].length() > 0) {
                sb.append(sb.length() != 0 ? " " : "").append(strs[i]);
            }
        }
        return sb.toString();
    }
}

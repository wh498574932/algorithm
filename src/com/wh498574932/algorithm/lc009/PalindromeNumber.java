package com.wh498574932.algorithm.lc009;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 *
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 *
 * Time:        6 ms        100.00%     O(N)
 * Space:       35.3 MB     100.00%     O(1)
 *
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) { return false; }
        if(x < 10) { return true; }
        int div = 1;
        while(x/div>=10) { div*=10; }
        while(div>1) {
            if(x/div != x%10) { return false; }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}

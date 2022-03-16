package com.wh498574932.algorithm.lc680;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return isPal(s, l+1, r) || isPal(s, l, r-1);
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    private boolean isPal(String s, int l, int r) {
        while(l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        return l >= r;
    }
}

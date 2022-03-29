package com.wh498574932.algorithm.lc921;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int num = 0, left = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') {
                left++;
            } else if(s.charAt(i) == ')') {
                if(left > 0) {
                    left--;
                } else {
                    num++;
                }
            }
        }
        return num + left;
    }
}

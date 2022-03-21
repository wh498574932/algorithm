package com.wh498574932.algorithm.lc1249;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder first = new StringBuilder();
        int balance = 0, totalLeft = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') {
                balance++;
                totalLeft++;
            } else if(s.charAt(i) == ')') {
                if(balance == 0) {
                    continue;
                } else {
                    balance--;
                }
            }
            first.append(s.charAt(i));
        }
        int keepLeft = totalLeft - balance;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < first.length(); ++i) {
            if(first.charAt(i) == '(') {
                if(keepLeft <= 0) {
                    continue;
                }
                keepLeft--;
            }
            sb.append(first.charAt(i));
        }
        return sb.toString();
    }
}

package com.wh498574932.algorithm.lc227;

public class BasicCalculatorII {
    public int calculate(String s) {
        int num = 0, ret = 0, local = 0;
        char lastOper = '+';
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                num = num*10 + (c - '0');
            }
            if((c < '0' || c > '9') && c != ' ' || i == s.length() - 1) {
                if(lastOper == '+' || lastOper == '-') {
                    ret += local;
                    local = lastOper == '+' ? num : -num;
                } else if(lastOper == '*') {
                    local *= num;
                } else if(lastOper == '/') {
                    local /= num;
                }
                num = 0;
                lastOper = c;
            }
        }
        ret += local;
        return ret;
    }
}

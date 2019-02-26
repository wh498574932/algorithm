package com.wh498574932.algorithm.lc282;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators
 * (not unary) +, -, or * between the digits so they evaluate to the target value.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        if(num == null || num.length() < 2) {
            return ret;
        }
        helper(ret, "", 0, num, 0, 0, target);
        return ret;
    }

    private void helper(
        List<String> ret,
        String res,
        int index,
        String num,
        int lastOperationValue,
        int currentValue,
        int target)
    {
        if(index == num.length()) {
            if(currentValue == target) {
                ret.add(res);
            }
            return;
        }
        int val = 0;
        for(int i = index; i < num.length(); ++i) {
            int digit = num.charAt(i) - '0';
            if((Integer.MAX_VALUE-digit)/10 < val) {
                return;
            }
            val = val*10 + digit;
            if(index == 0) {
                helper(ret, String.valueOf(val), i+1, num, val, val, target);
            } else {
                helper(ret, res+'+'+val, i+1, num, val, currentValue+val, target);
                helper(ret, res+'-'+val, i+1, num, -val, currentValue-val, target);
                helper(
                    ret,
                    res+'*'+val,
                    i+1,
                    num,
                    lastOperationValue*val,
                    currentValue - lastOperationValue + lastOperationValue*val,
                    target
                );
            }
            if(i == index && digit == 0) {
                return;
            }
        }
    }
}

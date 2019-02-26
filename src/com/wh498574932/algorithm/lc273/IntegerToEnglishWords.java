package com.wh498574932.algorithm.lc273;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.
 */
public class IntegerToEnglishWords {

    public String numberToWords(int num) {
        if(num < 0) {
            return "";
        }
        if(num == 0) {
            return "Zero";
        }
        String[] digits = new String[]{"Billion ", "Million ", "Thousand ", ""};
        int div = 1000000000;
        Map<Integer, String> dict = dict();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < digits.length; ++i) {
            sb.append( convert(dict, num/div, digits[i]) );
            num %= div;
            div /= 1000;
        }
        return sb.toString().trim();
    }

    private String convert(Map<Integer, String> dict, int value, String postfix) {
        StringBuilder sb = new StringBuilder();
        if(value > 0) {
            sb.append(value/100 > 0 ? (dict.get(value/100) + "Hundred ") : "");
            value %= 100;
            if(value > 0) {
                sb.append(
                        value/10 > 1 ?
                                dict.get(value/10*10) + dict.get(value%10) :
                                dict.get(value)
                );
            }
            sb.append(postfix);
        }
        return sb.toString();
    }

    private Map<Integer, String> dict() {
        Map<Integer, String> dict = new HashMap<>();
        dict.put(0, "");
        dict.put(1, "One ");
        dict.put(2, "Two ");
        dict.put(3, "Three ");
        dict.put(4, "Four ");
        dict.put(5, "Five ");
        dict.put(6, "Six ");
        dict.put(7, "Seven ");
        dict.put(8, "Eight ");
        dict.put(9, "Nine ");
        dict.put(10, "Ten ");
        dict.put(11, "Eleven ");
        dict.put(12, "Twelve ");
        dict.put(13, "Thirteen ");
        dict.put(14, "Fourteen ");
        dict.put(15, "Fifteen ");
        dict.put(16, "Sixteen ");
        dict.put(17, "Seventeen ");
        dict.put(18, "Eighteen ");
        dict.put(19, "Nineteen ");
        dict.put(20, "Twenty ");
        dict.put(30, "Thirty ");
        dict.put(40, "Forty ");
        dict.put(50, "Fifty ");
        dict.put(60, "Sixty ");
        dict.put(70, "Seventy ");
        dict.put(80, "Eighty ");
        dict.put(90, "Ninety ");
        return dict;
    }
}

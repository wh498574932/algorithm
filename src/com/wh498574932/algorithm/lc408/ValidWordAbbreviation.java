package com.wh498574932.algorithm.lc408;

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int sub = 0, index = 0;
        for(int i = 0; i < abbr.length(); ++i) {
            if(abbr.charAt(i) <= '9' && abbr.charAt(i) >= '0') {
                if(sub == 0 && abbr.charAt(i) == '0') {
                    return false;
                }
                sub = sub * 10 + (abbr.charAt(i) - '0');
            } else if(sub != 0) {
                index += sub;
                i--;
                sub = 0;
            } else if(index >= word.length() || abbr.charAt(i) != word.charAt(index)) {
                return false;
            } else {
                index++;
            }
        }
        return (index + sub) == word.length();
    }
}

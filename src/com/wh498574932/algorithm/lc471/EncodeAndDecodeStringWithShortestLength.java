package com.wh498574932.algorithm.lc471;

/**
 * Given a non-empty string, encode the string such that its encoded length is the shortest.
 *
 * The encoding rule is: kx[char], where the char inside the square brackets is being repeated exactly
 * k times.
 *
 * Example:
 * RAW String:      abb8888dddddd4xgkkkkk
 * Encoded String:  abb4x86xd1x4xg5xk
 *
 * Note:
 * k will be a positive integer and encoded string will not be empty or have extra space.
 * You may assume that the input string contains [0-9a-z].
 * If an encoding process does not make the string shorter, then do not encode it.
 *
 * Feb 22nd, 2019
 */
public class EncodeAndDecodeStringWithShortestLength {

    public String encode(String raw) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < raw.length(); ++i) {
            if(i > 0 && raw.charAt(i) == raw.charAt(i-1)) {
                cnt++;
            } else {
                if( cnt > 3 || i > 0 && isNumber( raw.charAt(i-1) ) && raw.charAt(i) == 'x' ) {
                    encodeHelper(sb, cnt);
                }
                cnt = 1;
            }
            sb.append(raw.charAt(i));
        }
        if(cnt > 3) {
            encodeHelper(sb, cnt);
        }
        return sb.toString();
    }

    public String decode(String encode) {
        int cnt = 0, digits = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < encode.length(); ++i) {
            if(encode.charAt(i) == 'x' && cnt > 0 && i < encode.length()-1) {
                char next = encode.charAt(++i);
                sb.delete(sb.length() - digits, sb.length());
                digits = 0;
                while(cnt > 0) { sb.append(next); cnt--; }
            } else {
                sb.append(encode.charAt(i));
                if( isNumber( encode.charAt(i) ) ) {
                    digits++;
                    cnt = cnt*10 + (encode.charAt(i) - '0');
                } else {
                    digits = cnt = 0;
                }
            }
        }
        return sb.toString();
    }

    private void encodeHelper(StringBuilder sb, int cnt) {
        char pre = sb.charAt(sb.length()-1);
        sb.delete(sb.length()-cnt, sb.length());
        sb.append(String.format("%sx%s", cnt, pre));
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}

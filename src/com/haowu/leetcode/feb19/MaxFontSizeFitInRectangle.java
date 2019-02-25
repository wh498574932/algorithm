package com.haowu.leetcode.feb19;

/**
 * Given a string of characters to fit into a rectangle with size of height and width.
 *
 * Assume that for certain font size, different characters might have different width (spaces contained) but same height.
 *
 * The return value is the maximum font size that could fit this string of characters into the rectangle.
 */
public class MaxFontSizeFitInRectangle {
    private static final int MIN_FONT = 1;
    private static final int MAX_FONT = 10;

    public int maxFontSizeFitInRectangle(int height, int width, String s) {
        int l = MIN_FONT, r = MAX_FONT;
        while(l <= r) {
            int m = (l + r) / 2;
            if(isFit(height, width, s, m)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }

    private boolean isFit(int height, int width, String s, int fontSize) {
        int h = getHeight(fontSize);
        if(h > height) {
            return false;
        }
        int line = 0;
        for(int i = 0, len = 0; i < s.length() && line < height / h; ++i) {
            int w = getWidth(s.charAt(i), fontSize);
            if(w + len > width) {
                line++;
                len = w;
            } else {
                len += w;
            }
        }
        return line < height / h;
    }

    /**
     * Fake method to return width of character for given font size.
     *
     * For simple implementation purpose, assume the string only contains a-z.
     *
     * @param c character
     * @param fontSize font size of the character.
     * @return width of character.
     */
    private int getWidth(char c, int fontSize) {
        return (c - 'a') % 3 * fontSize;
    }

    /**
     * Fake Method to return height of characters for given font size.
     * @param fontSize Font Size of the Characters.
     * @return height of characters.
     */
    private int getHeight(int fontSize) {
        return fontSize;
    }
}

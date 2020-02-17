package com.wh498574932.algorithm.lc157;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 *
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left
 * in the file.
 *
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 *
 * Note:
 * The read function will only be called once for each test case.
 *
 * https://leetcode.com/problems/read-n-characters-given-read4/
 */
public class ReadNCharactersGivenRead4 extends Reader4 {

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        if(buf == null || buf.length < 1) { return 0; }
        if(n <= buf.length) { return n; }
        setContents(buf);
        int val = read4(buf);
        if(val < 4) { return val; }
        char[] newBuf = new char[buf.length-4];
        System.arraycopy(buf, 4, newBuf, 0, buf.length-4);
        return val + read(newBuf, n - val);
    }
}
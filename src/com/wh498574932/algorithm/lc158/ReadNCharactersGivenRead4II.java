package com.wh498574932.algorithm.lc158;

import com.wh498574932.algorithm.lc157.Reader4;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 *
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left
 * in the file.
 *
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 *
 * Note:
 * The read function may be called multiple times.
 */
public class ReadNCharactersGivenRead4II extends Reader4 {

    private int readPos = 0, writePos = 0;
    private char[] queue = new char[4];

    public ReadNCharactersGivenRead4II(char[] content) {
        setContents(content);
    }

    public int read(char[] buf, int n) {
        int ret = 0;
        while(readPos != writePos && ret < n) {
            buf[ret++] = queue[writePos++ % 4];
        }
        while(ret < n) {
            queue = new char[4];
            int read = read4(queue);
            readPos += read;
            int write = Math.min(read, n - ret);
            for(int i = 0; i < write; writePos++) {
                buf[ret++] = queue[i++];
            }
            if(read < 4) { break; }
        }
        return ret;
    }
}
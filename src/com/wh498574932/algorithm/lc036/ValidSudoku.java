package com.wh498574932.algorithm.lc036;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 *
 * Example 2:
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 *
 * Time:        2 ms        96.23%      O(N^2)
 * Space:       42 MB       95.93%      O(N)
 *
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; ++i) {
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            for(int j = 0; j < 9; ++j) {
                if(board[i][j] != '.') {
                    if(row[board[i][j] - '1']) { return false; }
                    else { row[board[i][j] - '1'] = true; }
                }
                if(board[j][i] != '.') {
                    if(col[board[j][i] - '1']) { return false; }
                    else { col[board[j][i] - '1'] = true; }
                }
            }
        }
        for(int b = 0; b < 9; ++b) {
            boolean[] visited = new boolean[9];
            for(int i = 0; i < 9; ++i) {
                if( board[b/3*3 + i/3][b%3*3 + i%3] != '.' ) {
                    if( visited[board[b/3*3 + i/3][b%3*3 + i%3] - '1'] ) { return false; }
                    else { visited[board[b/3*3 + i/3][b%3*3 + i%3] - '1'] = true; }
                }
            }
        }
        return true;
    }
}

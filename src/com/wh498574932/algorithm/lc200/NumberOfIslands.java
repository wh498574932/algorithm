package com.wh498574932.algorithm.lc200;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 *
 * https://leetcode.com/problems/number-of-islands/
 *
 * Accepted: 4 ms	41.6 MB
 *
 * Feb 4th, 2019
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int ret = 0;
        if(grid == null || grid.length < 1 || grid[0].length < 1) {
            return ret;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[0].length; ++j) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    ret++;
                    visited[i][j] = true;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return ret;
    }

    private void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        int[][] direction = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int k = 0; k < direction.length; ++k) {
            int i = direction[k][0] + r;
            int j = direction[k][1] + c;
            if(i >= 0 &&
                i < grid.length &&
                j >= 0 &&
                j < grid[0].length &&
                !visited[i][j] &&
                grid[i][j] == '1')
            {
                visited[i][j] = true;
                dfs(grid, visited, i, j);
            }
        }
    }
}

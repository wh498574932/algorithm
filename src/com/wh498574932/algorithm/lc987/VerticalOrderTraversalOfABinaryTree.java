package com.wh498574932.algorithm.lc987;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalOrderTraversalOfABinaryTree {
    private Map<Integer, Map<Integer, List<Integer>>> colMap = new HashMap<>();
    private int minCol = 0;
    private int maxCol = 0;
    private int minRow = 0;
    private int maxRow = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root, 0, 0);
        for(int i = this.minCol; i <= this.maxCol; ++i) {
            if(this.colMap.containsKey(i)) {
                Map<Integer, List<Integer>> rowMap = this.colMap.get(i);
                List<Integer> colList = new ArrayList<>();
                for(int j = this.minRow; j <= this.maxRow; ++j) {
                    if(rowMap.containsKey(j)) {
                        List<Integer> colRowList = rowMap.get(j);
                        if(colRowList.size() > 1) {
                            Collections.sort(colRowList);
                        }
                        colList.addAll(colRowList);
                    }
                }
                ret.add(colList);
            }
        }
        return ret;
    }

    private void dfs(TreeNode n, int col, int row) {
        if(n == null) {
            return;
        }
        this.minCol = Math.min(col, this.minCol);
        this.maxCol = Math.max(col, this.maxCol);
        this.minRow = Math.min(row, this.minRow);
        this.maxRow = Math.max(row, this.maxRow);
        Map<Integer, List<Integer>> rowMap = this.colMap.getOrDefault(col, new HashMap<>());
        List<Integer> list = rowMap.getOrDefault(row, new ArrayList<>());
        list.add(n.val);
        rowMap.put(row, list);
        this.colMap.put(col, rowMap);
        dfs(n.left, col-1, row+1);
        dfs(n.right, col+1, row+1);
    }
}

package com.wh498574932.algorithm.lc314;

import com.wh498574932.algorithm.model.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        Map<Integer, List<Integer>> treeMap = new TreeMap<>();
        q.offer(new Pair<>(root, 0));
        while(!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode n = p.getKey();
            int col = p.getValue();
            List<Integer> list = treeMap.getOrDefault(col, new ArrayList<>());
            list.add(n.val);
            treeMap.put(col, list);
            if(n.left != null) {
                q.offer(new Pair<>(n.left, col-1));
            }
            if(n.right != null) {
                q.offer(new Pair<>(n.right, col+1));
            }
        }
        return new ArrayList<>(treeMap.values());
    }
}

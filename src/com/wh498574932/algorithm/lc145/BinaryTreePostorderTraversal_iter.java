package com.wh498574932.algorithm.lc145;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [3,2,1]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * Time:        1 ms        56.54%      O(N)
 * Space:       35.1 MB     100.00%     O(N)
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal_iter {
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> ret = new ArrayList<>();
        final Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        while(!s.isEmpty() || root != null) {
            if(root != null) {
                s.push(root);
                root = root.left;
            } else {
                final TreeNode peek = s.peek();
                if(peek.right != null && peek.right != pre) {
                    root = peek.right;
                } else {
                    s.pop();
                    ret.add(peek.val);
                    pre = peek;
                }
            }
        }
        return ret;
    }
}

package com.wh498574932.algorithm.lc109;

import com.wh498574932.algorithm.model.ListNode;
import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * Time:        1 ms        100.00%     O(N)
 * Space:       38.9 MB     98.69%      O(N)
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head)
    {
        if( head == null ) { return null; }
        ListNode curr = head;
        int cnt = 0;
        while( curr != null ) { curr = curr.next; cnt++; }
        List<ListNode> node = new ArrayList<>();
        node.add(head);
        return build( node, 0, cnt - 1 );
    }

    private TreeNode build(List<ListNode> node, int l, int r)
    {
        if(l > r) { return null; }
        int m = l + ( r - l ) / 2;
        TreeNode left = build( node, l, m - 1 );
        TreeNode n = new TreeNode( node.get(0).val );
        node.set( 0, node.get(0).next );
        n.left = left;
        n.right = build( node, m + 1, r );
        return n;
    }
}

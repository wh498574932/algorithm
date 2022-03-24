package com.wh498574932.algorithm.lc1650;

import com.wh498574932.algorithm.model.binaryTreeWithParent.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LowestCommonAncestorOfABinaryTreeIII {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        visited.add(p);
        visited.add(q);
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(n.parent != null) {
                if(visited.contains(n.parent)) {
                    return n.parent;
                }
                visited.add(n.parent);
                queue.offer(n.parent);
            }
        }
        return null;
    }
}

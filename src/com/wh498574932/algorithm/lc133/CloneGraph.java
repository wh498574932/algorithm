package com.wh498574932.algorithm.lc133;

import com.wh498574932.algorithm.model.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the
 * graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * Example:
 *
 * Input:
 * {
 *   $id:"1",
 *   neighbors:[
 *     {
 *       $id:"2",
 *       neighbors:[
 *         {
 *           $ref:"1"
 *         },
 *         {
 *           $id:"3",
 *           neighbors:[
 *             {
 *               $ref:"2"
 *             },
 *             {
 *               $id:"4",
 *               neighbors:[
 *                 {
 *                   $ref:"3"
 *                 },
 *                 {
 *                   $ref:"1"
 *                 }
 *               ],
 *               val:4
 *             }
 *           ],
 *           val:3
 *         }
 *       ],
 *       val:2
 *     },
 *     {
 *       $ref:"4"
 *     }
 *   ],
 *   val:1
 * }
 *
 * Explanation:
 * Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 * Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 * Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 *
 * Note:
 *
 * The number of nodes will be between 1 and 100.
 * The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
 * Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
 * You must return the copy of the given node as a reference to the cloned graph.
 *
 * Time:        2 ms        46.81%      O(|E|+|V|)
 * Space:       34.3 MB     92.94%      O(|E|+|V|)
 *
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null) { return null; }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        Node newNode = new Node( node.val, new ArrayList<>() );
        map.put(node, newNode);
        while( !q.isEmpty() ) {
            Node curr = q.poll();
            for(Node currNeighbor : curr.neighbors) {
                if( !map.containsKey(currNeighbor) ) {
                    map.put(
                        currNeighbor,
                        new Node( currNeighbor.val, new ArrayList<>() )
                    );
                    q.offer( currNeighbor );
                }
                map.get( curr ).neighbors.add( map.get( currNeighbor ) );
            }
        }
        return newNode;
    }
}

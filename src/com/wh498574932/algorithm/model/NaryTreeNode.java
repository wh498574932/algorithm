package com.wh498574932.algorithm.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class represents N-ary Tree Node contains parent node.
 */
public class NaryTreeNode {
    public String name;
    public NaryTreeNode parent;
    public List<NaryTreeNode> children;

    public NaryTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }
}

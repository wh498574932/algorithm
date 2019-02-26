package com.haowu.leetcode.feb22;

import com.haowu.leetcode.model.NaryTreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implement a monarchy class which could handle birth and death of it members with unique name. And implement a method
 * to return the order of successors.
 */
public class Monarchy {
    private NaryTreeNode ruler;
    private Map<String, NaryTreeNode> map;

    /**
     * {@code Monarchy} class should always be created for given ruler member
     * @param ruler Ruler of this {@code Monarchy}
     */
    public Monarchy(NaryTreeNode ruler) {
        this.ruler = ruler;
        this.map = new HashMap<>();
        this.map.put(ruler.name, ruler);
    }

    /**
     * Give birth to certain member of this {@code Monarchy} under parent.
     * @param name new birth member
     * @param parent parent member
     */
    public void birth(String name, String parent) {
        if(map.containsKey(parent)) {
            NaryTreeNode p = map.get(parent);
            NaryTreeNode member = new NaryTreeNode(name);
            member.parent = p;
            this.map.put(name, member);
            p.children.add(member);
        } else {
            throw new RuntimeException("Parent not found in the Monarchy");
        }
    }

    /**
     * Death of certain member.
     * @param name dead member.
     */
    public void death(String name) {
        if(map.containsKey(name)) {
            NaryTreeNode deathMember = map.get(name);
            NaryTreeNode parentMember = deathMember.parent;
            List<NaryTreeNode> newChildren = new ArrayList<>();
            for(NaryTreeNode m : parentMember.children) {
                if(m.name.equals(deathMember.name)) {
                    deathMember.children.forEach(newChildren::add);
                } else {
                    newChildren.add(m);
                }
            }
            parentMember.children = newChildren;
            this.map.remove(name);
        } else {
            throw new RuntimeException("Name not found in the Monarchy");
        }
    }

    /**
     * Return successors of the ruler.
     * @return successors of the ruler.
     */
    public List<String> getSuccessors() {
        List<String> list = new ArrayList<>();
        preorder(ruler, list);
        return list;
    }

    private void preorder(NaryTreeNode m, List<String> list) {
        if(m == null) {
            return;
        }
        list.add(m.name);
        for(NaryTreeNode member : m.children) {
            preorder(member, list);
        }
    }
}

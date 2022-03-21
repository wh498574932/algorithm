package com.wh498574932.algorithm.lc339;

import com.wh498574932.algorithm.model.NestedInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>(nestedList);
        int depth = 0, ret = 0;
        while(!q.isEmpty()) {
            depth++;
            int size = q.size();
            for(int i = 0; i < size; ++i) {
                final NestedInteger ni = q.poll();
                if(ni.isInteger()) {
                    ret += (ni.getInteger() * depth);
                } else {
                    q.addAll(ni.getList());
                }
            }
        }
        return ret;
    }
}

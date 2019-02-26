package com.wh498574932.algorithm.feb22;

import static com.wh498574932.algorithm.utilities.ArrayList.createArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.wh498574932.algorithm.model.NaryTreeNode;
import org.junit.jupiter.api.Test;

public class MonarchyTest {
    @Test
    public void test() {
        NaryTreeNode n1 = new NaryTreeNode("1");
        Monarchy monarchy = new Monarchy(n1);
        monarchy.birth("2", "1");
        monarchy.birth("3", "1");
        monarchy.birth("4", "2");
        monarchy.birth("5", "2");
        monarchy.birth("6", "3");
        monarchy.birth("7", "3");
        assertEquals(createArrayList("1", "2", "4", "5", "3", "6", "7"), monarchy.getSuccessors());
        monarchy.death("3");
        assertEquals(createArrayList("1", "2", "4", "5", "6", "7"), monarchy.getSuccessors());
    }
}

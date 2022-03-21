package com.wh498574932.algorithm.model;

import java.util.List;

public interface NestedInteger {

    boolean isInteger();

    Integer getInteger();

    void setInteger(int value);

    void add(NestedInteger ni);

    List<NestedInteger> getList();
 }
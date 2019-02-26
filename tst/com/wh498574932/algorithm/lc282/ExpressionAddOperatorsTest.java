package com.wh498574932.algorithm.lc282;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperatorsTest {
    @Test
    public void test() {
        List<String> list = new ExpressionAddOperators().addOperators("105", 5);
        List<String> ret = new ArrayList<>();
        ret.add("10-5");
        ret.add("1*0+5");
        assertTrue( list.containsAll(ret) );
    }
}

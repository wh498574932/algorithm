package com.wh498574932.algorithm.airbnb;

import static com.wh498574932.algorithm.utilities.ArrayList.createArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class ListOfListIteratorTest {
    @Test
    public void test() {
        ListOfListIterator<Integer> iterator = new ListOfListIterator<>(
            createArrayList(
                createArrayList(1,2,3),
                createArrayList(4,5),
                createArrayList(),
                createArrayList(6,7)
            )
        );
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
        assertFalse(iterator.hasNext());
    }
}

package com.wh498574932.algorithm.airbnb;

import java.util.Iterator;
import java.util.List;

/**
 * Given an array of arrays, implement an iterator class to allow the client to traverse and remove elements in the
 * array list.
 *
 * This iterator should provide three public class member functions:
 *
 * boolean hasNext() return true if there is another element in the set
 * int next() return the value of the next element in the array
 * void remove() remove the last element returned by the iterator. That is, remove the element that the previous next()
 * returned. This method can be called only once per call to next(), otherwise an exception will be thrown.
 */
public class ListOfListIterator<T> implements Iterator<T> {
    private Iterator<List<T>> row;
    private Iterator<T> col;

    public ListOfListIterator(List<List<T>> lists) {
        row = lists.iterator();
        col = null;
    }

    @Override
    public boolean hasNext() {
        while( (col == null || !col.hasNext()) && row.hasNext() ) {
            col = row.next().iterator();
        }
        return col != null && col.hasNext();
    }

    @Override
    public T next() {
        // NPE thrown if col is null or hasNext() never got called.
        return col.next();
    }

    @Override
    public void remove() {
        if(col != null) {
            col.remove();
        } else {
            // IllegalStateException instead of NPE should be thrown if next() never got called.
            throw new IllegalStateException("Error.");
        }
    }
}

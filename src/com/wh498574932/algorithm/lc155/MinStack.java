package com.wh498574932.algorithm.lc155;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * Time:        7 ms        27.88%      O(1)
 */
public class MinStack {
    private final Stack<Integer> s = new Stack<>();
    private final Stack<Integer> min = new Stack<>();

    public void push(int x) {
        s.push(x);
        if(min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        if(s.peek().equals(min.peek())) {
            min.pop();
        }
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

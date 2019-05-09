package min_stack_155;

import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

        push(x) -- Push element x onto stack.
        pop() -- Removes the element on top of the stack.
        top() -- Get the top element.
        getMin() -- Retrieve the minimum element in the stack.
        Example:
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   --> Returns -3.
        minStack.pop();
        minStack.top();      --> Returns 0.
        minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    /** initialize your data structure here. */
    Stack<Node> minStack;

    //inner class to store information about min value of the stack
    class Node {
        int val;
        int min;
    }

    public MinStack() {
        minStack = new Stack<>();
    }

    public void push(int x) {
        Node  node = new Node();
        node.val = x;
        node.min = minStack.isEmpty() ? x : Math.min(getMin(), x);
        minStack.push(node);
    }

    public void pop() {
        minStack.pop();
    }

    public int top() {
        return minStack.peek().val;
    }

    public int getMin() {
        return minStack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
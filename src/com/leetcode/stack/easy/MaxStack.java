package com.leetcode.stack.easy;

import java.util.Stack;

class MaxStack {

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(3);
        maxStack.push(6);
        maxStack.push(4);
        System.out.println("Peek Max = "+maxStack.peekMax());
        System.out.println("Pop = "+maxStack.pop());
        maxStack.push(5);
        maxStack.push(2);
        maxStack.push(1);
        System.out.println("Top "+maxStack.top());
        System.out.println("Peek Max "+maxStack.peekMax());
        System.out.println("Pop Max = "+maxStack.popMax());
        System.out.println("Max = "+maxStack.peekMax());
        System.out.println("Top = "+maxStack.top());
    }

    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> max = new Stack<Integer>();
    /** initialize your data structure here. */
    public MaxStack() {

    }
    //O(1);
    public void push(int x) {
        data.push(x);
        if (max.isEmpty()) {
            max.push(x);
        }
        else {
            max.push(Math.max(x, max.peek()));
        }
    }
    public int pop() {
        max.pop();
        return data.pop();
    }
    public int top() {
        return data.peek();
    }
    public int peekMax() {
        return max.peek();
    }
    public int popMax() {
        int res = max.peek();
        Stack<Integer> tmp = new Stack<Integer>();
        while (data.peek() != res) {
            tmp.push(data.pop());
            max.pop();
        }
        data.pop();
        max.pop();
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        return res;
    }
}

package com.leetcode.stack.easy;

import java.util.Stack;

public class MinStack2 {

    Stack<Integer> s ;
    Stack<Integer> min ;

    public MinStack2() {
        s = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int val) {
        if(s.isEmpty()){
            s.push(val);
            min.push(val);
            return;
        }
        if(val > min.peek()){
            s.push(val);
        }else{
            s.push(val);
            min.push(val);
        }
    }

    public void pop() {
        int y = s.pop();
        if(y == min.peek()){
            min.pop();
        }

    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

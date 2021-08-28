package com.leetcode.stack.easy;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

        Queue<Integer> q ;
        public StackUsingQueue() {
            q = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q.add(x);
            int size = q.size();

            for(int i = 0 ; i < size -1 ; i++){
                int num = q.poll();
                q.add(num);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q.poll();
        }

        /** Get the top element. */
        public int top() {
            return q.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q.isEmpty();
        }
}

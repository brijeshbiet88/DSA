package com.leetcode.stack.easy;

import java.util.Map;
import java.util.Stack;

public class RemoveAllAdjacentDups2 {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1-----------------");
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println("Result = "+removeDuplicates(s,k));
        System.out.println();
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(s.charAt(0), 1));

        for(int i = 1; i < s.length(); i++)
        {
            if(stack.size() > 0)
            {
                Pair top = stack.peek();
                char ch = s.charAt(i);

                if(top.ch != ch)
                    stack.push(new Pair(ch, 1));

                else if(top.ch == ch)
                {
                    Pair pair = stack.peek();
                    stack.pop();
                    pair.count += 1;

                    if(pair.count < k)
                        stack.push(pair);

                    else if(pair.count == k)
                        continue;
                }
            }

            else
                stack.push(new Pair(s.charAt(i),1));
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty())
        {
            Pair top = stack.peek();
            char ch = top.ch;
            int count = top.count;

            while(count > 0)
            {
                sb.append(ch);
                count--;
            }
            stack.pop();
        }

        return sb.reverse().toString();
    }

    static class Pair
    {
        char ch;
        int count;

        Pair(char ch, int count)
        {
            this.ch=ch;
            this.count=count;
        }
    }
}

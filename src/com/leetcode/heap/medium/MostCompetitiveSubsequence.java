package com.leetcode.heap.medium;

import java.util.Stack;

public class MostCompetitiveSubsequence {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-------------------");
        int [] nums = {2,4,3,3,5,4,9,6};
        int k = 2;
        int [] res = mostCompetitive(nums , k);
        System.out.println("Print most competitive sub sequence :");
        for (int seq : res)
            System.out.print(seq+" ");
        System.out.println();
    }
    public static int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int [] res = new int[k];
        int n = nums.length;
        for (int i = 0 ; i < n ; i++){
            while (!stack.isEmpty() && nums[i] < stack.peek() && stack.size() + n -i > k ){
                stack.pop();
            }
            if(stack.size() < k)
                stack.push(nums[i]);
        }

        while (!stack.isEmpty()){
         res[--k] = stack.pop();
        }
        return res;
    }
}

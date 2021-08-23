package com.leetcode.stack.easy;

import java.util.HashMap;
import java.util.Stack;

public class NextGreater1 {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1-------------------");
        int [] nums1 = {4,1,2};
        int [] nums2 = {1,3,4,2};

        int [] nextGreater = nextGreaterElement(nums1 , nums2);
        for (int num : nextGreater)
            System.out.print(num+" ");
        System.out.println();
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer , Integer> nextGreater = new HashMap<Integer , Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for(Integer num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                nextGreater.put(stack.pop() , num);
            }
            stack.push(num);
        }
        for (int i = 0 ; i < nums1.length ; i++){
            nums1[i] = nextGreater.getOrDefault(nums1[i] , -1);
        }
        return nums1;
    }
}

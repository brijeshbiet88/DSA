package com.leetcode.stack.medium;

import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        System.out.println("-------------Test Case 1----------------");
        int [] nums = {1,2,3,4,3};
        int [] nextGreater = nextGreaterElements(nums);
        System.out.println("Print Next Greater Elements ");
        for (int num : nextGreater)
            System.out.print(num+" ");
        System.out.println();
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] nextGreaterElement = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            nextGreaterElement[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return nextGreaterElement;
    }
}

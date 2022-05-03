package com.leetcode.array.medium;

import java.util.Stack;

public class SortedUnsortedContArray {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1-------------------");
        int [] nums1 = {2,6,4,8,10,9,15};
        int len = findUnsortedSubarray(nums1);
        System.out.println("result = "+len);
        System.out.println();

        System.out.println("--------------Test Case 2-------------------");
        int [] nums2 = {2,6,4,9,1,8,15};
        len = findUnsortedSubarray(nums2);
        System.out.println("result = "+len);
        System.out.println();
    }

    public static int findUnsortedSubarray(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int left = nums.length - 1;

        for (int i = 0; i < nums.length; ) {
            if (st.empty()) {
                st.push(i);
                i++;
            } else {
                if (nums[st.peek()] > nums[i]) {
                    left = Math.min(left, st.peek());
                    st.pop();
                } else {
                    st.push(i);
                    i++;
                }
            }
        }

        st.clear();
        int right = 0;


        for (int i = nums.length - 1; i >= 0; ) {
            if (st.empty()) {
                st.push(i);
                i--;
            } else {
                if (nums[st.peek()] < nums[i]) {
                    right = Math.max(right, st.peek());
                    st.pop();
                } else {
                    st.push(i);
                    i--;
                }
            }
        }

        if (left >= right) {
            return 0;
        } else {
            return right - left + 1;
        }
    }

}


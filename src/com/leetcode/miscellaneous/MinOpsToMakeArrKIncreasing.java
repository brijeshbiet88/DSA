package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class MinOpsToMakeArrKIncreasing {
    public static void main(String[] args) {
        MinOpsToMakeArrKIncreasing mo = new MinOpsToMakeArrKIncreasing();
        System.out.println("-------------Test Case 1----------------");
        int [] arr1 = {4,1,5,2,6,2};
        int k = 2;
        int result = mo.kIncreasing(arr1 , k);
        System.out.println("Min Operations To Make Array K Increasing = "+result);
        System.out.println();

        System.out.println("-------------Test Case 2----------------");
        k = 3;
        result = mo.kIncreasing(arr1 , k);
        System.out.println("Min Operations To Make Array K Increasing = "+result);
        System.out.println();
    }

    public int kIncreasing(int[] arr, int k) {
        int result = 0;
        for(int i = 0; i < k; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = i; j < arr.length; j = j + k)
                list.add(arr[j]);
            result += list.size() - lengthOfLIS(list);
        }
        return result;
    }

    private int lengthOfLIS(List<Integer> nums){
        List<Integer> nonDecreasingList = new ArrayList<>();
        nonDecreasingList.add(nums.get(0));

        for(int i = 1; i < nums.size(); i++){
            int lastItem = nonDecreasingList.get(nonDecreasingList.size() - 1);
            if(nums.get(i) >= lastItem){
                nonDecreasingList.add(nums.get(i));
            } else {
                int index = nextGreaterIndex(nonDecreasingList, nums.get(i));
                nonDecreasingList.set(index, nums.get(i));
            }
        }
        return nonDecreasingList.size();
    }

    private int nextGreaterIndex(List<Integer> list, int num){
        int low = 0;
        int high = list.size() - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if(num >= list.get(mid))
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}

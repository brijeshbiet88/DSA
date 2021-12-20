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
        int size = nums.size();
        int lis[] = new int[nums.size()];
        int i, j, max = 0;

        for (i = 0; i < size; i++)
            lis[i] = 1;

        for (i = 1; i < size; i++)
            for (j = 0; j < i; j++)
                if (nums.get(i) >= nums.get(j))
                    lis[i] = Math.max(lis[i] , lis[j] + 1);

        for (i = 0; i < size; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }

}

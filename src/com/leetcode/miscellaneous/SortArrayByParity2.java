package com.leetcode.miscellaneous;

public class SortArrayByParity2 {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-----------------");
        int [] a1 = {1 , 4 , 2 , 3};
        sortArrayByParityII(a1);
        System.out.println("Array Elements After Sorting ");
        for (int num : a1)
            System.out.print(num+" ");
        System.out.println();

        System.out.println("---------------Test Case 2-----------------");
        int [] a2 = {1 , 4};
        sortArrayByParityII(a2);
        System.out.println("Array Elements After Sorting ");
        for (int num : a2)
            System.out.print(num+" ");
        System.out.println();
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int i = 0 , j = 1;
        while(i < nums.length){

            if(nums[i] % 2 == 0){
                i = i + 2;
            }else{
                while(j < nums.length && nums[j] % 2 != 0){
                    j = j + 2;
                }
                swap(nums , i , j);
                i = i + 2;
                j = j + 2;
            }
        }

        return nums;
    }

    public static void swap(int [] a , int i , int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

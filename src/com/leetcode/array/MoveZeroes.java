package com.leetcode.array;

public class MoveZeroes {
    public static void main(String[] args) {
     int nums [] = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println("Array Elements After Moving 0's ");
        for (int num : nums)
            System.out.print(num+" ");
    }


    public static void moveZeroes(int[] nums) {
      int nonZeroIndex = 0;
      int temp = 0 ;
      for(int i = 0 ; i < nums.length ; i++){
          if(nums[i] != 0){
              temp = nums[i];
              nums[i] = nums[nonZeroIndex];
              nums[nonZeroIndex++] = temp;
          }
      }
    }
}
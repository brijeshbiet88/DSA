package com.leetcode.miscellaneous;

public class SortArrayByParity {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-----------------");
        int [] nums1 = {3 , 1 , 2 , 4};
        System.out.println("Print Array After Sorting : ");
        sortArrayByParity(nums1);
        for (int num : nums1)
            System.out.print(num+" ");
        System.out.println();

        System.out.println("---------------Test Case 2-----------------");
        int [] nums2 = {0};
        System.out.println("Print Array After Sorting : ");
        sortArrayByParity(nums2);
        for (int num : nums2)
            System.out.print(num+" ");
        System.out.println();

        System.out.println("---------------Test Case 3-----------------");
        int [] nums3 = {0 , 1 , 2};
        System.out.println("Print Array After Sorting : ");
        sortArrayByParity(nums3);
        for (int num : nums3)
            System.out.print(num+" ");
        System.out.println();
    }
    public static int[] sortArrayByParity(int[] nums) {
        if(nums.length == 1) return nums;
        int slow = 0 , fast = 0;
        while (slow < nums.length && nums[slow]%2 == 0 ){
            slow++;
        }

        fast = slow + 1;
        while (fast < nums.length){
            if(nums[fast] % 2 == 0){
                swap(nums , slow , fast);
                slow++;
                fast++;
            }else{
                fast++;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int slow, int fast) {
        int temp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = temp;
    }
}

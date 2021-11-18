package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class AllNumbersDisappearedInArray {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1-------------------");
        int [] nums1= {1 ,1};
        List<Integer> result = findDisappearedNumbers(nums1);
        System.out.println("Print Result : ");
        result.forEach(num-> System.out.print(num+" "));
        result.clear();
        System.out.println();

        System.out.println("-----------------Test Case 2-------------------");
        int [] nums2= {4,3,2,7,8,2,3,1};
        result = findDisappearedNumbers(nums2);
        System.out.println("Print Result : ");
        result.forEach(num-> System.out.print(num+" "));
        result.clear();
        System.out.println();

        System.out.println("-----------------Test Case 3-------------------");
        int [] nums3= {5,5,5,5,5};
        result = findDisappearedNumbers(nums3);
        System.out.println("Print Result : ");
        result.forEach(num-> System.out.print(num+" "));
        result.clear();
        System.out.println();

        System.out.println("-----------------Test Case 4-------------------");
        int [] nums4= {3,4,5,4,3};
        result = findDisappearedNumbers(nums4);
        System.out.println("Print Result : ");
        result.forEach(num-> System.out.print(num+" "));
        result.clear();
        System.out.println();

        System.out.println("-----------------Test Case 5-------------------");
        int [] nums5= {1,1,1,1,5};
        result = findDisappearedNumbers(nums5);
        System.out.println("Print Result : ");
        result.forEach(num-> System.out.print(num+" "));
        result.clear();
        System.out.println();
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int len = nums.length;
        for(int i = 0 ; i < len ; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0 ){
                nums[index] = -nums[index];
            }
        }

        for(int i = 0 ; i < len ; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}

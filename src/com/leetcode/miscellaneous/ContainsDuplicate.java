package com.leetcode.miscellaneous;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println("-------------Test Case 1----------------");
        int [] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println("Contains Duplicate ? "+containsDuplicate(nums));
        System.out.println();

        System.out.println("-------------Test Case 2----------------");
        int [] nums2 = {1,2,5,7};
        System.out.println("Contains Duplicate ? "+containsDuplicate(nums2));
        System.out.println();


    }
    public static boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).mapToObj(s-> new Integer(s)).collect(Collectors.toSet()).size() != nums.length;
    }
}

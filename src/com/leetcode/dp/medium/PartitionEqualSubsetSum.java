package com.leetcode.dp.medium;

import java.util.HashMap;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1----------------------");
        PartitionEqualSubsetSum pess = new PartitionEqualSubsetSum();
        int[] nums1 = {1,5,5,11};
        System.out.println("Can the Array Be Partitioned in Equal Sum Subset ? "+pess.canPartition(nums1));
        System.out.println("Can the Array Be Partitioned in Equal Sum Subset DP ? "+pess.canPartition2(nums1));
        System.out.println();

        System.out.println("-----------------Test Case 2----------------------");
        int[] nums2 = {1,5,5,12};
        System.out.println("Can the Array Be Partitioned in Equal Sum Subset ? "+pess.canPartition(nums2));
        System.out.println("Can the Array Be Partitioned in Equal Sum Subset DP ? "+pess.canPartition2(nums2));
        System.out.println();
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums )
            sum += num;
        if(sum % 2 == 1 ) return false;
        return canPartition(nums , sum , 0 , 0);
    }

    private boolean canPartition(int [] nums , int total , int index , int currentSum){
        if(currentSum *2 == total)
            return true;

        if(currentSum*2 > total || index >= nums.length)
            return false;

        return canPartition(nums , total , index + 1, currentSum)
                || canPartition(nums , total , index + 1, currentSum + nums[index]);
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for(int num : nums )
            sum += num;
        if(sum % 2 == 1 ) return false;
        return canPartition2(nums , sum , 0 , 0 , new HashMap<String,Boolean>());
    }

    private boolean canPartition2(int [] nums , int total , int index , int currentSum ,
                                 HashMap<String , Boolean> map){

        String str = String.valueOf(index)+":"+currentSum;
        if(map.containsKey(str))
            return map.get(str);
        if(currentSum *2 == total)
            return true;

        if(currentSum*2 > total || index >= nums.length)
            return false;

        boolean result = canPartition2(nums , total , index + 1, currentSum , map)
                || canPartition2(nums , total , index + 1, currentSum + nums[index], map);
        map.put(str,result);
        return result;
    }
}

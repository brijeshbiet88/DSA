package com.leetcode.array.medium;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1------------------");
        int [] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println("Print Triplet :");
        res.forEach( triplet->{
            triplet.forEach(n-> System.out.print(n+" "));
            System.out.println();
        });
        System.out.println();

        System.out.println("-----------------Test Case 2------------------");
        List<List<Integer>> res2 = threeSumWithoutSet(nums);
        System.out.println("Print Triplet :");
        res2.forEach( triplet->{
            triplet.forEach(n-> System.out.print(n+" "));
            System.out.println();
        });
        System.out.println();

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
            int  k = nums.length-1;
            while(j<k){

                if(nums[i] + nums[j] + nums[k] == 0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                else if ( nums[i] + nums[j] + nums[k] > 0) k--;
                else if (nums[i] + nums[j] + nums[k] < 0) j++;
            }

        }
        return new ArrayList<>(res);
    }

    public static List<List<Integer>> threeSumWithoutSet(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList();
        int len = nums.length;
        for(int i = 0 ; i < len -2 ; i++) {

            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int low = i+1 , high = len-1 , sum = 0 - nums[i];

                while(low < high) {

                    if(nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low] , nums[high]));

                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;

                        low++;
                        high--;
                    }

                    else if(nums[low] + nums[high] < sum) {
                        low++;
                    }else
                        high--;

                }
            }

        }
        return result;


    }
}

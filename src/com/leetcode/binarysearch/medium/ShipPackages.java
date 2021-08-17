package com.leetcode.binarysearch.medium;

public class ShipPackages {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1---------------------");
        int [] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println("Least Weight Capacity of Ship "+shipWithinDays(weights , days));
        System.out.println();
    }

    public static int shipWithinDays(int[] weights, int days) {
       int low = findMax(weights);
        int high = sum(weights);
        int mid , d, weightSum ;
        int result = 0;

        while(low <= high) {

            mid = low+ (high-low)/ 2;
            d = 1;
            weightSum = 0;

            for(int w: weights) {
                if (weightSum + w > mid ) {
                    d++;
                    weightSum = w;
                } else {
                    weightSum += w;
                }
            }

            if(d <= days) {
                result = mid ;
                high = mid -1;
            } else {
                low = mid + 1;
            }

        }
        
        return result;
    }



    private static int sum(int[] weights) {
        int sum = 0;
        for (int i = 0 ; i < weights.length ; i++)
            sum += weights[i];
        return sum;
    }

    private static int findMax(int[] weights) {
        int max = weights[0];
        for (int i = 0 ; i < weights.length ; i++)
            max = Math.max(max , weights[i]);
        return max;
    }
}

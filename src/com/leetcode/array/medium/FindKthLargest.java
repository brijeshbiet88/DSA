package com.leetcode.array.medium;

public class FindKthLargest {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1------------------");
        int [] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println("Kth where k = "+k+" largest Element = "+findKthLargest(nums , k));
        System.out.println();


        System.out.println("----------------Test Case 1------------------");
        int [] nums2 = {3,2,3,1,2,4,5,5,6};
        k = 2;
        System.out.println("Kth where k = "+k+" largest Element = "+findKthLargest(nums2 , k));
        System.out.println();
    }

    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSort(nums , 0 , nums.length -1 , k);
    }

    public static int quickSort(int [] nums , int low , int high , int k){

        if(high < low) return -1;
        int partitionIndex = partition(nums , low , high);
        if(partitionIndex == k)
            return nums[partitionIndex];

        if(partitionIndex > k )
            return quickSort(nums , low , partitionIndex - 1 , k);
        return quickSort(nums , partitionIndex + 1 , high , k);


    }

    public static int partition(int [] nums , int low , int high){

        int j = low - 1 ;
        int i = low;
        while(i < high){
            if(nums[i] < nums[high]){
                j++;
                swap(nums , i , j);
            }
            i++;
        }
        j++;
        swap(nums , j , high);
        return j;
    }

    public static void swap(int [] nums , int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

package com.leetcode.array.medium;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println("-----------------Test case 1-------------------");
        int [] nums1 = {1,3};
        int [] nums2 = {2};
        System.out.println("Median of Two Arrays = "+findMedianSortedArrays(nums1,nums2));
        System.out.println();

        System.out.println("-----------------Test case 2-------------------");
        int [] nums3 = {2,4};
        System.out.println("Median of Two Arrays = "+findMedianSortedArrays(nums1,nums3));
        System.out.println();

        System.out.println("-----------------Test case 3-------------------");
        int [] nums4 = {0,0};
        int [] nums5 = {0,0};
        System.out.println("Median of Two Arrays = "+findMedianSortedArrays(nums4,nums5));
        System.out.println();

        System.out.println("-----------------Test case 4-------------------");
        int [] nums6 = {};
        int [] nums7 = {1};
        System.out.println("Median of Two Arrays = "+findMedianSortedArrays(nums6,nums7));
        System.out.println();

        System.out.println("-----------------Test case 5-------------------");
        int [] nums8 = {2};
        int [] nums9 = {};
        System.out.println("Median of Two Arrays = "+findMedianSortedArrays(nums8,nums9));
        System.out.println();
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length ;
        int len2 = nums2.length;

        if((len1+len2)%2 == 0){
            return findMedianInEvenLength(nums1 , nums2 , len1 , len2);
        }else{
            return findMedianInOddLength(nums1 , nums2 , len1 , len2);
        }
    }

    private static double findMedianInEvenLength(int [] nums1 , int [] nums2 , int len1 , int len2){
        double sum = 0.0;
        int i = 0 , j = 0;
        int marker = 0;
        while(i < len1 || j < len2 ){
            if(i < len1 && j < len2 && nums1[i] < nums2[j]){
                i++;
                marker = 0;
            }else if (i < len1 && j < len2 && nums1[i] >= nums2[j]){
                j++;
                marker = 1;
            }else if(i < len1 && j == len2){
                i++;
                marker = 0;
            }else if(i == len1 && j < len2){
                j++;
                marker = 1;
            }

            if( (i+j) == (len1+len2)/2 ){
                if(marker == 0){
                    sum += (double) nums1[i-1];
                }else{
                    sum += (double) nums2[j-1];
                }
            }

            if((i+j) == (len1+len2)/2+1){
                if(marker == 0){
                    sum += (double) nums1[i-1];
                }else{
                    sum += (double) nums2[j-1];
                }
                break;
            }

        }

        return sum/2.0;
    }

    private static double findMedianInOddLength(int [] nums1 , int [] nums2 , int len1 , int len2){
        int i = 0 , j = 0;
        int marker = 0;
        double result = 0.0;
        while(i < len1 || j < len2 ){
            if(i < len1 && j < len2 && nums1[i] < nums2[j]){
                i++;
                marker = 0;
            }else if (i < len1 && j < len2 && nums1[i] >= nums2[j]){
                j++;
                marker = 1;
            }else if(i < len1 && j == len2){
                i++;
                marker = 0;
            }else if(i == len1 && j < len2){
                j++;
                marker = 1;
            }

            if((i+j) == (len1+len2)/2+1){
                if(marker == 0){
                    result = (double) nums1[i-1];
                }else{
                    result = (double) nums2[j-1];
                }

                break;
            }
        }

        return result;

    }
}

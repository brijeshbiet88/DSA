package com.leetcode.array.medium;

public class SearchInSortedArrayOfUnknownSize {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1---------------");
        int [] a = {-3 , 0 , 1 , 5 , 7 , 10 ,12 , 18 , 20 , 30 , 50 , 80 , 100};
        int target = 80;
        System.out.println("Index of Target = "+target+" in Array = "+search(a,target));
        System.out.println();

        System.out.println("--------------Test Case 2---------------");
        target = -3;
        System.out.println("Index of Target = "+target+" in Array = "+search(a,target));
        System.out.println();

        System.out.println("--------------Test Case 3---------------");
        target = 100;
        System.out.println("Index of Target = "+target+" in Array = "+search(a,target));
        System.out.println();

        System.out.println("--------------Test Case 4---------------");
        target = 0;
        System.out.println("Index of Target = "+target+" in Array = "+search(a,target));
        System.out.println();

        System.out.println("--------------Test Case 5---------------");
        target = 30;
        System.out.println("Index of Target = "+target+" in Array = "+search(a,target));
        System.out.println();

        System.out.println("--------------Test Case 6---------------");
        target = 480;
        System.out.println("Index of Target = "+target+" in Array = "+search(a,target));
        System.out.println();

        System.out.println("--------------Test Case 7---------------");
        target = 37;
        System.out.println("Index of Target = "+target+" in Array = "+search(a,target));
        System.out.println();
    }

    public static int search(int [] a , int target){
        int index = -1;
        int left = 0;
        int right = 1;

        while (get(a,right) < target){
            left = right;
            right = 2 * right ;
        }
        int mid ;
        while (left <= right){

            mid = left + (right - left) /2;
            if(get(a,mid) == target) return mid;

            else if(get(a,mid) > target){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static int get(int [] a , int i){
        try {
            return a[i];
        }catch (Exception e){
            return Integer.MAX_VALUE;
        }

    }
}

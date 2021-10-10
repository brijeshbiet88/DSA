package com.leetcode.miscellaneous;

public class NUniqueIntsSum0 {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1-----------------");
        int [] res = sumZero(5);
        System.out.println("Print Array :");
        for (int num : res)
            System.out.print(num+" ");
        System.out.println();

        System.out.println("--------------Test Case 2-----------------");
        int [] res2 = sumZero(6);
        System.out.println("Print Array :");
        for (int num : res2)
            System.out.print(num+" ");
        System.out.println();
    }

    public static int[] sumZero(int n) {
        if (n == 1) return new int[] {0};

        int[] arr = new int[n];
        int num = 0;

        for (int i = -n/2; i <= n/2; i++) {
            if (n % 2 == 0) {
                if (i == 0) continue;
                else arr[num] = i;
            } else {
                arr[num] = i;
            }

            num++;
        }

        return arr;
    }
}

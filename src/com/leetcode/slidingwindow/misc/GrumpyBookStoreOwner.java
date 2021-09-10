package com.leetcode.slidingwindow.misc;

public class GrumpyBookStoreOwner {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1----------------");
        int [] customers = {1,0,1,2,1,1,7,5};
        int [] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println("Max Satisfied Customers "+maxSatisfied(customers,grumpy,minutes));
        System.out.println();

    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int satisfiedCustomers = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfiedCustomers += customers[i];
            }
        }

        int max = 0;
        for (int i = 0; i < customers.length - minutes + 1; i++) {
            int maxUnsatisfied = 0;
            int j = i;
            while (j < i + minutes) {
                if (grumpy[j] == 1)
                   maxUnsatisfied += customers[j];
                j++;
            }
            max = Math.max(maxUnsatisfied,max);
        }
        return satisfiedCustomers + max;
    }
}

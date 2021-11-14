package com.leetcode.array.medium;

public class BulbSwitcher3 {
    public static void main(String[] args) {
        System.out.println("----------------Test case 1--------------------");
        int [] light1 = {2,1,3,5,4};
        System.out.println("Number of Times Each Bulb is Blue = "+numTimesAllBlue(light1));
        System.out.println();

        System.out.println("----------------Test case 2--------------------");
        int [] light2 = {3,2,4,1,5};
        System.out.println("Number of Times Each Bulb is Blue = "+numTimesAllBlue(light2));
        System.out.println();

        System.out.println("----------------Test case 3--------------------");
        int [] light3 = {4,1,2,3};
        System.out.println("Number of Times Each Bulb is Blue = "+numTimesAllBlue(light3));
        System.out.println();

        System.out.println("----------------Test case 4--------------------");
        int [] light4 = {2,1,4,3,6,5};
        System.out.println("Number of Times Each Bulb is Blue = "+numTimesAllBlue(light4));
        System.out.println();

        System.out.println("----------------Test case 5--------------------");
        int [] light5 = {1,2,3,4,5,6};
        System.out.println("Number of Times Each Bulb is Blue = "+numTimesAllBlue(light5));
        System.out.println();
    }

    public static int numTimesAllBlue(int[] light) {
        int maxOn = 0;
        int result = 0;
        for(int i = 0 ; i < light.length ; i++){
            maxOn = Math.max(maxOn , light[i]);
            if(i+1 == maxOn)
                result++;
        }
        return result;
    }
}

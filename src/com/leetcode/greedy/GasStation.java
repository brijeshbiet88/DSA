package com.leetcode.greedy;

public class GasStation {
    public static void main(String[] args) {
        System.out.println("------------------Test Case 1-------------------");
        int [] gas = {1 , 2, 3, 4, 5};
        int [] cost = {3 ,4 , 5 , 1 , 2};
        System.out.println("Result = "+canCompleteCircuit(gas , cost));
        System.out.println();
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int total = 0;
        int startIndex = 0;
        for (int i = 0 ; i < gas.length ; i++){
            int consume = gas[i] - cost[i];
            tank += consume;
            if(tank < 0){
                startIndex = i + 1;
                tank = 0;
            }
            total += consume;
        }

        return total >= 0 ? startIndex : -1;
    }
}

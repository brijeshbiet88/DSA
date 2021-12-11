package com.leetcode.dp.medium;

import java.util.HashMap;
import java.util.Map;

public class NumberOfDiceRollsToTarget {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1---------------------");
        NumberOfDiceRollsToTarget o1 = new NumberOfDiceRollsToTarget();
        int d = 2;
        int target = 10;
        int f = 6;
        System.out.println("No of Dice Rolls = "+o1.numRollsToTarget(d,f,target));
        System.out.println();

        System.out.println("-----------------Test Case 2---------------------");
        NumberOfDiceRollsToTarget o2 = new NumberOfDiceRollsToTarget();
        d = 30;
        target = 500;
        f = 30;
        System.out.println("No of Dice Rolls = "+o2.numRollsToTarget(d,f,target));
        System.out.println();

        System.out.println("-----------------Test Case 3---------------------");
        NumberOfDiceRollsToTarget o3 = new NumberOfDiceRollsToTarget();
        d = 2;
        target = 10;
        f = 5;
        System.out.println("No of Dice Rolls = "+o3.numRollsToTarget(d,f,target));
        System.out.println();

    }

    Map<String,Integer> dp = new HashMap();
    public int numRollsToTarget(int d, int f, int target) {
        if(target < d || target > d *f)
            return 0;
        if(d == 0) return 0;
        if(d == 1) return target <= f ? 1 : 0;
        String key = d+":"+"f"+":"+""+target;
        if(dp.containsKey(key))
            return dp.get(key);

        int numRolls = 0;
        for(int i = 1 ; i <= f ; i++){
            numRolls += numRollsToTarget(d - 1 , f , target -i ) % 1000000007;
            numRolls %= 1000000007;
        }
        dp.put(key,numRolls);
        return numRolls;
    }
}

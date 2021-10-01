package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1--------------------");
        int n = 12;
        List<String> result = fizzBuzz(n);
        result.forEach(s-> System.out.print(s+" "));
        System.out.println();
    }

    public static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for(int i =1; i <= n; i++){
            if(i%3 == 0 && i%5 ==0) ans.add("FizzBuzz");
            else if(i%3 == 0)       ans.add("Fizz");
            else if(i%5 == 0)       ans.add("Buzz");
            else                    ans.add(i+"");
        }

        return ans;
    }
}

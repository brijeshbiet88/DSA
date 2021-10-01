package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for(int i = 1; i < numRows; i++){
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for(int j = 1; j < i; j++){
                current.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            current.add(1);
            result.add(current);
        }
        return result;
    }
}

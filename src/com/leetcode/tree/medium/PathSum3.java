package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

import java.util.HashMap;

public class PathSum3 {
    static int total = 0;
    public static void main(String [] args) {
        TreeNode root = TreeUtil.getTree2();
        System.out.println("Print Tree ");
        TreeUtil.traverseLevelByLevel(root);
        int targetSum = 21;
        pathSum(root , targetSum);
        System.out.println("Total No Of Paths With Sum "+targetSum+" = "+total);
    }

    public static int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        HashMap<Integer , Integer> hm = new HashMap();
        hm.put(0 , 1);
        findPathSum(root , 0 , targetSum , hm);
        return total;
    }

    private static void findPathSum(TreeNode curr, int sum, int target, HashMap<Integer, Integer> hm) {
        if(curr == null) return ;
        sum += curr.val;
        if(hm.containsKey(sum - target))
            total += hm.get(sum - target);
        hm.put(sum , hm.getOrDefault(sum , 0) + 1);
        findPathSum(curr.left, sum, target, hm);
        findPathSum(curr.right, sum, target, hm);
        hm.put(sum , hm.get(sum) - 1);
        return ;
    }
}

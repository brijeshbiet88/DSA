package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class SumRootToLeafNumbers {
    static int result;

    public static void main(String[] args) {
        TreeNode root = TreeUtil.getTree();
        System.out.println("Print Level Order :");
        TreeUtil.traverseLevelByLevel(root);
        System.out.println("Sum of Root to Leaves = "+sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        result = 0;
        sumNumbersHelper(root , result);
        return result;
    }

    public static void sumNumbersHelper(TreeNode root , int sum){
        if(root == null) return;

        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null){
            result += sum;
            return;
        }
        sumNumbersHelper(root.left , sum);
        sumNumbersHelper(root.right , sum);

    }
}

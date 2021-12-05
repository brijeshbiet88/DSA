package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {
   static Map<TreeNode , Integer> map = new HashMap();
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-----------------");
        TreeNode root = TreeUtil.getTree();
        System.out.println("Level Order of Tree ");
        TreeUtil.traverseLevelByLevel(root);
        System.out.println("Max Robbing = "+rob(root));
        map.clear();
        System.out.println();

        System.out.println("----------------Test Case 2-----------------");
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(5);

        root2.left.left = new TreeNode(3);
        root2.right.left = new TreeNode(1);

        System.out.println("Level Order of Tree ");
        TreeUtil.traverseLevelByLevel(root2);
        System.out.println("Max Robbing = "+rob(root2));
        map.clear();
        System.out.println();
    }

    public static int rob(TreeNode root) {
        if(root == null) return 0;

        if(map.containsKey(root))
            return map.get(root);

        int val = 0;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left != null)
            val += rob(left.left) + rob(left.right);
        if(right != null)
            val += rob(right.left) + rob(right.right);
        int max = Math.max(root.val + val , rob(left) + rob(right));
        map.put(root , max);
        return max;

    }
}

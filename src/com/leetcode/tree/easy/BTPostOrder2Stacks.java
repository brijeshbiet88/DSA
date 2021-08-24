package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPostOrder2Stacks {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.getTree();

        List<Integer> inOrder = postorderTraversal(root);
        inOrder.forEach(System.out::println);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();

        s1.add(root);
        while (!s1.isEmpty()){

            TreeNode temp = s1.pop();
            s2.push(temp);

            if(temp.left != null)
                s1.push(temp.left);
            if(temp.right != null)
                s1.push(temp.right);

        }
        while (!s2.isEmpty()){
            result.add(s2.pop().val);
        }
        return result;
    }
}

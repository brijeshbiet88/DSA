package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInorder {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.getTree();

        List<Integer> inOrder = inorderTraversal(root);
        inOrder.forEach(System.out::println);

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack();
        TreeNode curr = root;

        while (true){

            while (curr != null){
                s.push(curr);
                curr = curr.left;
            }

            if(s.isEmpty())
                break;

            curr = s.pop();
            result.add(curr.val);
            curr = curr.right;


        }
        return result;
    }
}

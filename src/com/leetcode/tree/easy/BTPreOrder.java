package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPreOrder {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.getTree();

        List<Integer> inOrder = preorderTraversal(root);
        inOrder.forEach(System.out::println);

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack();
        TreeNode curr = root;

        while (true){

            while (curr != null){
                s.push(curr);
                result.add(curr.val);
                curr = curr.left;
            }

            if(s.isEmpty())
                break;

            curr = s.pop();
            curr = curr.right;


        }
        return result;
    }
}

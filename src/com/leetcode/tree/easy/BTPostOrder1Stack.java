package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPostOrder1Stack {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.getTree();

        List<Integer> postOrder = postorderTraversal(root);
        postOrder.forEach(System.out::println);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack();

        while(current != null || !stack.isEmpty()){

            if (current != null){
                stack.push(current);
                current = current.left;
            }else {
               TreeNode temp = stack.peek().right;
               if(temp == null){
                   temp = stack.pop();
                   result.add(temp.val);
                   while (!stack.isEmpty() && stack.peek().right == temp){
                       temp = stack.pop();
                       result.add(temp.val);
                   }
               }else {
                   current = temp;
               }
            }
        }
        return result;
    }
}

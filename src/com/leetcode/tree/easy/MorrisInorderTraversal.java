package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.getTree();
        List<Integer> morrisInorder = inorderTraversal(root);
        System.out.println("Print Morris Traversal");
        morrisInorder.forEach(node-> System.out.print(node+" "));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        morrisTraversal(root,result);
        return result;
    }

    private static void morrisTraversal(TreeNode root , List<Integer> list){
        if(root == null)
            return;

        TreeNode curr = null , pre = null;

        curr = root;
        while(curr != null){

            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }
            else{
                pre = curr.left;
                while(pre.right != null && pre.right != curr){
                    pre = pre.right;

                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                }
                else{
                    pre.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
    }
}

package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class SubTreeOfAnotherTree {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree2();
		System.out.println("Level Order ");
		TreeUtil.traverseLevelByLevel(root);
		
		TreeNode root2 = new TreeNode(3);
		root2.left = new TreeNode(6);
		root2.right = new TreeNode(7);
		System.out.println();
		System.out.println("Is T2 Sub tree of T1 ? "+isSubtree(root, root2));
	}

	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        return  isSameTree(root, subRoot) 
                || isSubtree(root.left, subRoot) 
                || isSubtree(root.right, subRoot);

    }
    
    public static boolean isSameTree(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        
        return  node1.val == node2.val 
                && isSameTree(node1.left, node2.left) 
                && isSameTree(node1.right, node2.right);
    }
}

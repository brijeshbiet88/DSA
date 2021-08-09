package com.leetcode.tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree();
		List<List<Integer>> zigzagList = levelOrder(root);
		System.out.println("Print LevelOrder Traversal :");
		zigzagList.forEach( list ->{
			list.forEach(num -> System.out.print(num+" "));
			System.out.println();
		});

	}

	 public static List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        if(root == null) return result;
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        List<Integer> list = new ArrayList<Integer>();
	        q.add(root);
	        while(!q.isEmpty()){
	            
	            int n = q.size();
	            for(int i = 0 ; i < n ; i++){
	                TreeNode temp = q.remove();
	                list.add(temp.val);
	                if(temp.left != null)
	                    q.add(temp.left);
	                if(temp.right != null)
	                    q.add(temp.right);
	            }
	            
	            result.add(list);
	            list = new ArrayList<Integer>();
	        }
	        
	        return result;
	    }
}

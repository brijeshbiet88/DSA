package com.leetcode.tree.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class AllNodesDistanceK {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree2();
		System.out.println("print Tree ");
		TreeUtil.traverseLevelByLevel(root);
		TreeNode target = root.left;
		int k = 2;
		List <Integer> kDistanceNodes = distanceK(root, target, k);
		System.out.println("Print K distance Nodes From target "+target.val+"\n");
		kDistanceNodes.forEach(s->System.out.print(s+" "));
	}
	
	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) return result;
		
		Map<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
		createParentMap(parentMap , root);
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Set<TreeNode> visited = new HashSet<TreeNode>();
		q.add(target);
		int n = 0;
		while(!q.isEmpty()) {
			
			int size = q.size();
			TreeNode temp = null;
			for(int i = 0 ; i < size ; i++) {
				temp = q.poll();
				visited.add(temp);
				if(n == k) {
					result.add(temp.val);
					
				}
				if(temp.left != null && !visited.contains(temp.left)) {
					q.add(temp.left);
					
				}
				if(temp.right != null && !visited.contains(temp.right)) {
					q.add(temp.right);
					
				}
				if(parentMap.get(temp) != null && !visited.contains(parentMap.get(temp)))
					q.add(parentMap.get(temp));	
			}
			
			n++;
			
			if(n > k)
				return result;
		}
		
		
		return result;
		
        
    }

	private static void createParentMap(Map<TreeNode, TreeNode> parentMap, TreeNode root) {
		
		if(root == null ) return ;
		
		if(root.left != null)
			parentMap.put(root.left, root);
		if(root.right != null)
			parentMap.put(root.right, root);
		
		createParentMap(parentMap, root.left);
		createParentMap(parentMap, root.right);
		
	}

}

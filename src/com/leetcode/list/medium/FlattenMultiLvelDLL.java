package com.leetcode.list.medium;

import com.leetcode.list.Node;

public class FlattenMultiLvelDLL {

	public static void main(String[] args) {
	
	}
	
	 public static Node flatten(Node head) {
	        Node current = head;
	        while(current != null) {
	        	if(current.child == null) {
	        		current = current.next;
	        		continue;
	        	}
	        	
	        	Node tmp = current.child;
	        	while(tmp.next != null) {
	        		tmp = tmp.next;
	        	}
	        	
	        	tmp.next = current.next;
	        	if(current.next != null)
	        		current.next.prev = tmp;
	        	
	        	current.next = current.child;
	        	current.child.prev = current;
	        	current.child = null;
	        }
	        
	        return head;
	 }

}

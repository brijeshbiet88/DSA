package com.leetcode.list.easy;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class RemoveDuplicateFromSortedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		System.out.println("Print List Before Removing Duplicates ");
		ListUtil.printList(head);
		System.out.println();
		head = deleteDuplicates(head);
		System.out.println("Print List After Removing Duplicates ");
		ListUtil.printList(head);

	}
	
	 public static ListNode deleteDuplicates(ListNode head) {
	        if(head == null) return head;
	        ListNode tmp = head;
	       
	        ListNode start = new ListNode(101);
	        ListNode tail = start;
	        
	        while(tmp != null){
	        
	            
	            if (tail.val != tmp.val){
	                tail.next = tmp;
	                tmp = tmp.next;
	                tail = tail.next;
	                tail.next = null;
	                
	            }else {
	            	tmp = tmp.next;
	            }
	            }
	        
	        return start.next;
	    }

}

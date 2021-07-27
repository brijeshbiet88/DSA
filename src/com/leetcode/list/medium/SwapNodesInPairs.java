package com.leetcode.list.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class SwapNodesInPairs {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);

		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;

		head = swapPairs(head);

		System.out.println("Print List After Re Ordering Odd and Even ");
		ListUtil.printList(head);

	}
	
	 public static ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy , curr = head; 
		while(curr != null && curr.next != null) {
			 prev.next = curr.next;
			 curr.next = curr.next.next;
			 prev.next.next = curr;
			 
			 curr = curr.next;
			 prev = prev.next.next;
		 }
		 
		return dummy.next;
	        
	    }

}

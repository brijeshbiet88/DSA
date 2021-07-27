package com.leetcode.list.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class PartitionList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(2);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		int x = 3;
		head = partition(head, x);
		
		System.out.println("Print List After Partitioning ");
		ListUtil.printList(head);
		
	}

	public static ListNode partition(ListNode head, int x) {
		if (head == null)
			return head;

		ListNode small = new ListNode(0);
		ListNode big = new ListNode(0);
		
		ListNode smallTail = small;
		ListNode bigTail = big;
		
		while(head != null) {
			
			if(head.val < x) {
				smallTail.next = head;
				smallTail = smallTail.next;
			}else {
				bigTail.next = head;
				bigTail = bigTail.next;
			}
			
			
			head = head.next;
		}

		bigTail.next = null;
		smallTail.next = big.next;
		return small.next;
	}
}

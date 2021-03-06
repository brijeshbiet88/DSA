package com.leetcode.list.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class RemoveDuplicatedSortedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);

		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(3);
		ListNode node7 = new ListNode(4);
		ListNode node8 = new ListNode(4);
		ListNode node9 = new ListNode(5);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;

		head = deleteDuplicates(head);

		System.out.println("Print List After Deleting Duplicate ");
		ListUtil.printList(head);

	}

	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		ListNode tmp1 = head;
		ListNode tmp2 = null;
		
		while(tmp1.next != null) {
			
			tmp2 = tmp1.next;
			while(tmp2 != null && tmp1.val == tmp2.val) {
				tmp2 = tmp2.next;
			}
			
			tmp1.next = tmp2;
			tmp1 = tmp1.next;
			if(tmp1 == null) break;
		}
		
		return head;
		

	}
}

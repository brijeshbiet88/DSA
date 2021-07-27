package com.leetcode.list.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class RemoveDuplicatedSortedList2 {

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

	private static ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0, head);

		ListNode tail = dummy;

		while (head != null) {
			if (head.next != null && head.val == head.next.val) {
				while (head.next != null && head.val == head.next.val) {
					head = head.next;
				}
				tail.next = head.next;
			} else {
				tail = tail.next;
			}

			head = head.next;
		}
		return dummy.next;}

}

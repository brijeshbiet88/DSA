package com.leetcode.list;

public class ListUtil {
	
	public static ListNode getLinkedList() {
		ListNode head = new ListNode(1);
		
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		return head;
	}
	
	public static ListNode getOddLinkedList() {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(7);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		return head;
	}
	
	public static ListNode getEvenLinkedList() {
		ListNode head = new ListNode(2);
		
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(8);
		ListNode node5 = new ListNode(10);
		ListNode node6 = new ListNode(12);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		return head;
	}
	
	
	public static void printList(ListNode head) {
		if (head == null) return;
		System.out.print(head.val+"->");
		printList(head.next);

	}

}

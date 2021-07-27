package com.leetcode.list.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class OddEvenLinkedList {

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

		head = oddEvenList(head);

		System.out.println("Print List After Re Ordering Odd and Even ");
		ListUtil.printList(head);

	}
	
    public static ListNode oddEvenList(ListNode head) {
    	
    	ListNode odd = new ListNode(0);
    	ListNode even = new ListNode(0);
    	
    	ListNode oddTail = odd;
    	ListNode evenTail = even;
    	
    	boolean oddNode = true;
    	
    	while(head != null) {
    		
    		if(oddNode) {
    			oddTail.next = head;
    			oddTail = oddTail.next;
    			head = head.next;
    			oddTail.next = null;
    			
    		}else {
    			evenTail.next = head;
    			evenTail = evenTail.next;
    			head = head.next;
    			evenTail.next = null;
    		}
    		
    		oddNode = !oddNode;
    		
    	}
    	
    	oddTail.next = even.next;
    	
    	
		return odd.next;
        
    }

}

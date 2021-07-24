package com.leetcode.list.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class ReverseBetween {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		int m =2 , n = 4;
		head = reverseBetween(head, m, n);
		System.out.println("Print After Revesring between "+m+" and "+n);
		ListUtil.printList(head);

	}

	
	 public static ListNode reverseBetween(ListNode head, int m, int n) {

	        if (head == null) return null;
	        
	        ListNode curr = head, prev = null;
	        while (m > 1) {
	            prev = curr;
	            curr = curr.next;
	            m--;
	            n--;
	        }

	        ListNode con = prev, tail = curr;

	        ListNode third = null;
	        while (n > 0) {
	            third = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = third;
	            n--;
	        }

	        if (con != null) {
	            con.next = prev;
	        } else {
	            head = prev;
	        }

	        tail.next = curr;
	        return head;
	    }
}

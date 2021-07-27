package com.leetcode.list.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class RotateList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);

		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		int k = 6; 
		head = rotateRight(head , k);

		System.out.println("Print List After Re Ordering Odd and Even ");
		ListUtil.printList(head);

	}

	public static ListNode rotateRight(ListNode head, int k) {
		
		if(head == null || k == 0 ) return head;
		
		ListNode tmp = head;
		int len = 0;
		while(tmp.next != null) {
			tmp = tmp.next;
			len++;
		}
		len++;
		
		
		if(k % len == 0) return head;
		
		k = k % len;
		
		k = len -k -1 ;
		
		int count = 0;
		
		tmp.next = head;
		tmp = head;
		
		while(count < k) {
			count++;
			tmp = tmp.next;
		}
		
		head = tmp.next;
        tmp.next = null;
        
        return head;
    }
}

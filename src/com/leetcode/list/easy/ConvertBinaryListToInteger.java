package com.leetcode.list.easy;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class ConvertBinaryListToInteger {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(0);
		head.next.next = new ListNode(1);
		System.out.println("Print List ");
		ListUtil.printList(head);
		System.out.println("Decimal Equivalent = "+getDecimalValue(head));

	}
	
	 public static int getDecimalValue(ListNode head) {
	        
	        int decimal =0;
	        
	        ListNode tmp = head;
	        while(tmp != null){
	          decimal = decimal *2 + tmp.val;  
	            
	            tmp = tmp.next;
	        }
	        
	        return decimal;
	    }

}

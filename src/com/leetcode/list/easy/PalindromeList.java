package com.leetcode.list.easy;

import java.util.Stack;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class PalindromeList {

	public static void main(String[] args) {
		ListNode head = ListUtil.getEvenPalindromeList();
		System.out.println("Print List ");
		ListUtil.printList(head);
		System.out.println("Is Palindrome "+isPalindrome(head) );

	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		Stack<Integer> s = new Stack<Integer>();

		ListNode tmp = head;
		ListNode two = head;
		while (two != null) {

			two = two.next;
			if(two != null) {
				two = two.next;
				s.push(tmp.val);
				tmp = tmp.next;
				
			}else {
				tmp = tmp.next;
			}

		}
		
		while (!s.isEmpty()) {
			int val = s.pop();
			if (val != tmp.val)
				return false;

			tmp = tmp.next;
		}

		return true;
	}

}

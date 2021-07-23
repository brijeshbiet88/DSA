package com.leetcode.list.easy;

import java.util.Stack;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class PalindromeList {

	public static void main(String[] args) {
		ListNode head = ListUtil.getEvenPalindromeList();
		System.out.println("Print List ");
		ListUtil.printList(head);
		System.out.println("Is Palindrome "+head );

	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		Stack<Integer> s = new Stack<Integer>();

		ListNode tmp = head;
		while (tmp != null) {

			s.push(tmp.val);
			tmp = tmp.next;

		}
		tmp = head;

		while (!s.isEmpty()) {
			int val = s.pop();
			if (val != tmp.val)
				return false;

			tmp = tmp.next;
		}

		return true;
	}

}

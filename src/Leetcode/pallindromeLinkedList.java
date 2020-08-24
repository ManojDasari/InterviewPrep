package Leetcode;

/*
 * Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class pallindromeLinkedList {
	ListNode forward;

	public boolean isPalindrome(ListNode head) {
		forward = head;
		return isPal(head);
	}

	public boolean isPal(ListNode node) {
		if (node == null)
			return true;
		if (!isPal(node.next) || forward.val != node.val)
			return false;
		forward = forward.next;
		return true;
	}
}
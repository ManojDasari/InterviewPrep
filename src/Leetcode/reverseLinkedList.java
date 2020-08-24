package Leetcode;

/*
 * Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class reverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if (head == null)
			return head;
		ListNode curr = head, next = null, prev = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;

	}
}
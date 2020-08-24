package Leetcode;

/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class reverseNodesinKGroups {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head, prev = null, next = null;
		int count = 0;
		if (findLength(head) < k)
			return head;
		while (count < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if (next != null)
			head.next = reverseKGroup(next, k);

		return prev;
	}

	public int findLength(ListNode root) {
		int count = 0;
		while (root != null) {
			root = root.next;
			count++;
		}
		return count;
	}
}

package Leetcode;

public class IntersectionofTwoLinkedlists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode pa = headA, pb = headB;

		while (pa != pb) {
			if (pa != null)
				pa = pa.next;
			else
				pa = headB;
			if (pb != null)
				pb = pb.next;
			else
				pb = headA;
		}
		return pa;
	}
}
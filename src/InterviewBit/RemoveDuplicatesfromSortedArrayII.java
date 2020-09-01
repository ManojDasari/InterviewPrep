package InterviewBit;

/*
 * Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Note that even though we want you to return the new length, make sure to change the original array as well in place

For example,
Given input array A = [1,1,1,2],

Your function should return length = 3, and A is now [1,1,2].
 */
import java.util.ArrayList;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(ArrayList<Integer> a) {
		int start = 0;
		int end = 0;
		int n = a.size();
		while (end < n) {
			int num = a.get(end);
			int count = 0;
			while (end < n && a.get(end) == num) {
				end++;
				count++;
			}
			for (int i = 0; i < Math.min(count, 2); i++) {
				a.set(start++, num);
			}
		}
		return start;
	}
}

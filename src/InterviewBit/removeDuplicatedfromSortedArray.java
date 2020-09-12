package InterviewBit;

/*
 * Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

Note that even though we want you to return the new length, make sure to change the original array as well in place

Do not allocate extra space for another array, you must do this in place with constant memory.

 Example:
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2]. 
 */
import java.util.ArrayList;

public class removeDuplicatedfromSortedArray {
	public int removeDuplicates(ArrayList<Integer> a) {
		int start = 0;
		int end = 0;
		int n = a.size();
		while (end < n) {
			int num = a.get(end);
			while (end < n && a.get(end) == num) {
				end++;
			}
			a.set(start++, num);
		}
		return start;
	}
}

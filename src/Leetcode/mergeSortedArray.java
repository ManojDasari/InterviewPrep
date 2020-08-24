package Leetcode;

/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 

Constraints:

-10^9 <= nums1[i], nums2[i] <= 10^9
nums1.length == m + n
nums2.length == n
 */
public class mergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// start at last element on each array (for nums1 substract the length of nums2)
		int p1 = nums1.length - nums2.length - 1;
		int p2 = nums2.length - 1;

		// This is the last spot on nums1. Each loop below, put there the biggest and
		// move backwards
		int dest = nums1.length - 1;

		// iterate on the smallest array
		while (p2 >= 0) {
			// if there are still elements on nums1, compare p1 vs p2 and put the biggest in
			// nums1[dest]
			// otherwise, just take nums2
			int biggest = p1 >= 0 ? Math.max(nums1[p1], nums2[p2]) : nums2[p2];
			nums1[dest] = biggest;

			// move p1 or p2 back
			if (p1 >= 0 && nums1[p1] > nums2[p2])
				p1--;
			else
				p2--;

			// move back to next destination
			dest--;
		}
	}
}

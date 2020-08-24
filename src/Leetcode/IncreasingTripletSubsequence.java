package Leetcode;

/*
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 */
public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length <= 3)
			return false;
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < b) {
				b = nums[i];
			} else if (nums[i] > b && nums[i] < a) {
				a = nums[i];
			} else if (nums[i] > a)
				return true;
		}

		return false;
	}
}
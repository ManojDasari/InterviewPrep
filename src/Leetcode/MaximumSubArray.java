package Leetcode;

/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubArray {
	public int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if (currSum > maxSum)
				maxSum = currSum;
			if (currSum < 0)
				currSum = 0;
		}
		return maxSum;

	}
}

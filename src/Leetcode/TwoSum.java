package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		char ch = 'a';
		System.out.println(String.valueOf(ch-'a'));
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if (map.containsKey(temp)) {
				int x[] = new int[2];
				x[1] = i;
				x[0] = map.get(temp);
				return x;
			}
			map.put(nums[i], i);
		}

		return nums;
	}
	public static void main(String[] args) {
		System.out.println(twoSum(new int[10], 2));
	}
}
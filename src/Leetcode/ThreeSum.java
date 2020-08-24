package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> result = new HashSet();
		for (int i = 0; i < nums.length - 2; i++) {
			int l = i + 1;
			int r = nums.length - 1;
			while (r > l) {
				if (nums[i] + nums[l] + nums[r] == 0) {
					List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r]));
					result.add(temp);
					l++;
				} else if (nums[i] + nums[l] + nums[r] < 0) {
					l++;
				} else
					r--;
			}

		}
		return result.stream().collect(Collectors.toList());
	}
}
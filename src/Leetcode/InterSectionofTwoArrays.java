package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
 
 */
public class InterSectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		List<Integer> ans = new ArrayList<Integer>();

		for (int i = 0; i < nums1.length; i++) {
			if (!map.containsKey(nums1[i])) {
				map.put(nums1[i], 1);
			}

		}

		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i])) {
				if (!map2.containsKey(nums2[i])) {
					map2.put(nums2[i], 1);
					ans.add(nums2[i]);

				}
			}

		}

		int result[] = new int[ans.size()];

		for (int i = 0; i < ans.size(); i++)
			result[i] = ans.get(i);

		return result;
	}
}

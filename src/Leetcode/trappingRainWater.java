package Leetcode;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */
public class trappingRainWater {
	public int trap(int[] height) {
		int result = 0;
		int start = 0;
		int end = height.length - 1;
		while (start < end) {
			if (height[start] <= height[end]) {
				int current = height[start];
				while (height[++start] < current) {
					result += current - height[start];
				}
			} else {
				int current = height[end];
				while (height[--end] < current) {
					result += current - height[end];
				}
			}
		}
		return result;
	}
}

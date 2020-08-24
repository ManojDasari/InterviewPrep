package Leetcode;

import java.util.Arrays;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */
public class longestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		Arrays.sort(strs);
		String s1 = strs[0];
		String s2 = strs[strs.length - 1];
		StringBuilder sb = new StringBuilder();
		while (s1.length() != 0 & s2.length() != 0) {
			if (s1.charAt(0) == s2.charAt(0)) {
				sb.append(s1.charAt(0));
				s1 = s1.substring(1);
				s2 = s2.substring(1);
			} else {
				return sb.toString();
			}
		}
		return sb.toString();
	}
}
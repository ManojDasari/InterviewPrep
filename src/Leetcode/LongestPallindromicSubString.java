package Leetcode;

public class LongestPallindromicSubString {
	public String longestPalindrome(String s) {
		if (s.isEmpty()) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}
		String longest = s.substring(0, 1);
		// Search from left
		for (int i = 0; i < s.length(); i++) {
			String temp = longesthelper(s, i, i);
			longest = temp.length() > longest.length() ? temp : longest;
			temp = longesthelper(s, i, i + 1);
			longest = temp.length() > longest.length() ? temp : longest;

		}
		return longest;
	}

	// Calculate longest incrementally
	public String longesthelper(String input, int start, int end) {
		int L = start;
		int R = end;
		while (L >= 0 && R <= input.length() - 1 && input.charAt(L) == input.charAt(R)) {
			L--;
			R++;

		}
		return input.substring(L + 1, R);
	}
}
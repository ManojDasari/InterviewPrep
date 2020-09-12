package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class longestPallindromicSubString {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int N = Integer.parseInt(bufferedReader.readLine().trim());
			String input = bufferedReader.readLine().trim();
			longestPalindrome(input);
		}
	}

	public static void longestPalindrome(String A) {
		int start = 0;
		int end = 0;
		for (int i = 0; i < A.length(); i++) {
			int len1 = isPallindrome(A, i, i);
			int len2 = isPallindrome(A, i, i + 1);

			int len = Math.max(len1, len2);
			if (len > end - start + 1) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		System.out.println(end - start + 1);
	}

	public static int isPallindrome(String input, int left, int right) {
		while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
}
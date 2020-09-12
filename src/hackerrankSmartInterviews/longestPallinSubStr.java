package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class longestPallinSubStr {

	static long[] powArr = new long[100002];
	static long mod = (int) (1e9) + 7;
	static long p1 = 59;
	static long[] ForwHash;
	static long[] BackHash;

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		powArr[0] = 1;
		for (int i = 1; i < 10002; i++) {
			powArr[i] = (powArr[i - 1] * p1) % mod;
		}
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int N = Integer.parseInt(bufferedReader.readLine().trim());
			String input = bufferedReader.readLine().trim();
			ForwHash = new long[N];
			BackHash = new long[N];
			ForwHash[0] = input.charAt(0) * p1;
			BackHash[N - 1] = input.charAt(N - 1) * p1;
			for (int k = 1, j = N - 2; k < N && j >= 0; k++, j--) {
				ForwHash[k] = ((ForwHash[k - 1] % mod) + (input.charAt(k) * powArr[k + 1]) % mod) % mod;
				BackHash[j] = ((BackHash[j + 1] % mod) + (input.charAt(j) * powArr[N - j]) % mod) % mod;
			}
			longPallSubStr(input, N);
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

	public static void longPallSubStr(String str, int N) {
		int len = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int len1 = binarySearch(str, i, i);
			int len2 = binarySearch(str, i, i + 1);
			if (Math.max(len1, len2) > len)
				len = Math.max(len1, len2);
		}
		System.out.println(len);
	}

	public static int binarySearch(String str, int c1, int c2) {
		int low = 0;
		int high = (Math.min(c1, str.length() - c2 - 1));
		int mid = 0, ans = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (isValid(c1 - mid, c2 + mid)) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return (2 * ans) + 1 + (c2 - c1);
	}

	public static boolean isValid(int x, int y) {
		long F = (ForwHash[y] - ((x == 0) ? 0 : ForwHash[x - 1]) + mod) % mod;
		long B = (BackHash[x] - ((y == (BackHash.length - 1)) ? 0 : BackHash[y + 1]) + mod) % mod;
		if (x + 1 < BackHash.length - y) {
			F = (F * powArr[(Math.abs((x + 1) - (BackHash.length - y)))])*mod;
		} else if (x + 1 > BackHash.length - y) {
			B = (B * powArr[(Math.abs((x + 1) - (BackHash.length - y)))])*mod;
		}
		return F == B;
	}
}
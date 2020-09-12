package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RabinKarpStringMatching {
	static long[] powArr = new long[10001];
	static long mod = (int) (1e9) + 7;
	static long p1 = 59;

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		powArr[0] = 1;
		for (int i = 1; i < 10001; i++) {
			powArr[i] = (powArr[i - 1] * p1) % mod;
		}
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] array = bufferedReader.readLine().trim().split(" ");
			rabinKarpStringMatchingAlgorithm(array[1], array[0]);
		}
	}

	public static void rabinKarpStringMatchingAlgorithm(String str, String pat) {
		if (pat.length() > str.length()) {
			System.out.println(0);
			return;
		}

		long result = 0;
		long HA = 0;
		long HB = 0;
		for (int i = 0; i < pat.length(); i++) {
			HA += (pat.charAt(i) % mod * powArr[i + 1] % mod) % mod;
			HB += (str.charAt(i) % mod * powArr[i + 1] % mod) % mod;
		}
		if (HA == HB) {
			result++;
		}
		int patLen = pat.length();
		int strLen = str.length();
		for (int i = patLen; i < strLen; i++) {
			HB = (HB - (str.charAt(i - patLen) * powArr[i - patLen + 1]) % mod + (str.charAt(i) * powArr[i + 1]) % mod
					+ mod) % mod;
			HA = (HA * p1) % mod;
			if (HA == HB)
				result++;
		}

		System.out.println(result);
	}
}
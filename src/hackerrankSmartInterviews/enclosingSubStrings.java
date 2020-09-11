package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class enclosingSubStrings {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] input = bufferedReader.readLine().trim().split(" ");
			System.out.println(minWindow(input[1], input[0]));
		}
	}

	public static int minWindow(String A, String B) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : B.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int count = map.size(), idx = 0, start = 0;
		int minLen = Integer.MAX_VALUE;
		int startIdx = -1, endIdx = -1;
		while (idx < A.length()) {
			if (map.containsKey(A.charAt(idx))) {
				map.put(A.charAt(idx), map.get(A.charAt(idx)) - 1);
				if (map.get(A.charAt(idx)) == 0) {
					count--;
				}
			}

			while (start < A.length() && count == 0) {
				if (minLen > idx - start + 1) {
					startIdx = start;
					endIdx = idx + 1;
					minLen = idx - start + 1;
				}
				if (map.containsKey(A.charAt(start))) {
					map.put(A.charAt(start), map.get(A.charAt(start)) + 1);
					if (map.get(A.charAt(start)) == 1) {
						count++;
					}
				}
				start++;
			}
			idx++;
		}
		return minLen == Integer.MAX_VALUE ? -1 : endIdx - startIdx;
	}
}
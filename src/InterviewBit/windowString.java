package InterviewBit;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"

 Note:
If there is no such window in S that covers all characters in T, return the empty string ''.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
 */
import java.util.HashMap;

public class windowString {
	public static String minWindow(String A, String B) {
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
		System.out.println(A.substring(startIdx, endIdx));
		return minLen == Integer.MAX_VALUE ? "" : A.substring(startIdx, endIdx);
	}

	public static void main(String[] args) {
		minWindow("this is a test string", "tist");
	}

}

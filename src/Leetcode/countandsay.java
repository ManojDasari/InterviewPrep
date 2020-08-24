package Leetcode;

/*
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.

Note: Each term of the sequence of integers will be represented as a string.
 */
public class countandsay {
	public String countAndSay(int n) {
		if (n == 1)
			return "1";
		String previousString = countAndSay(n - 1);
		String nextString = getNextString(previousString);
		return nextString;

	}

	public String getNextString(String previous) {
		char current = previous.charAt(0);
		StringBuilder stringBuilder = new StringBuilder();
		int frequence = 1;
		for (int i = 1; i < previous.length(); i++) {
			if (previous.charAt(i) == current) {
				frequence++;
			} else {
				stringBuilder.append(frequence).append(current);
				frequence = 1;
				current = previous.charAt(i);
			}
		}
		stringBuilder.append(frequence).append(current);
		return stringBuilder.toString();
	}
}
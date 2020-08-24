package Leetcode;
/*
 * Given an integer n, find the closest integer (not including itself), which is a palindrome.

The 'closest' is defined as absolute difference minimized between two integers.

Example 1:
Input: "123"
Output: "121"
Note:
The input n is a positive integer represented by string, whose length will not exceed 18.
If there is a tie, return the smaller one as answer.
 */

public class findtheClosestPallindrome {
	public String nearestPalindromic(String n) {
		// Handles cases of Single Digit characters
		if (n.length() == 1)
			return "" + (n.charAt(0) - '0' - 1);
		// Handles cases of 10 and 11 - There onwards, generic solution works
		if (n.equals("10") || n.equals("11"))
			return "9";

		// Stores the closest and second highest multiple of 10 to the number.
		// Edge cases are powers of 10 where it is just the highest and closest multiple
		// of 10
		/*
		 * Examples: 123 => 10, 100 => 10 ( and not 0 or itself ), 1000 => 100 (and not
		 * 10 or itself), 1212 => 100
		 */
		int order = (int) Math.pow(10, n.length() / 2);

		// The Long Value of the input
		Long k = Long.valueOf(n);

		// Mirror of the first half of the number append to the second half - No Special
		// Case here
		/*
		 * Examples : 1000 becomes 1001, 998 becomes 999 and so on
		 */
		Long curr = mirror(k);

		// Mirror of the first half of the number AFTER manipulations ( Increasing the
		// first half )
		/*
		 * g == Greater
		 * 
		 * Normal Case: g = mirror(k/order*order + order + 1) Examples : 123 =>
		 * 123/10*10 + 10 + 1 = 131 1454 => 1450 + 100 + 1 = 1551
		 * 
		 * Case for powers of 10: g = mirror(k/order*order + 1) - You can ignore this.
		 * Question can be solved without it based on the ask Examples : 1000 =>
		 * 1000/10*10 + 1 = 1001
		 */
		Long g = mirror((k / order) * order + order + 1);
		if (order * 10 == k && k / 10 == order)
			g = mirror((k / order) * order + 1);

		// Mirror of the first half of the number AFTER manipulations ( Decreasing the
		// first half )
		/*
		 * s == Smaller
		 * 
		 * Normal Case: s = mirror((k/order)*order - order + 1); Examples : 123 =>
		 * 123/10*10 - 10 + 1 = 111 1454 => 1450 - 10 + 1 = 1441
		 * 
		 * Case for powers of 10: = mirror(k/order*order - 1) Examples : 1000 =>
		 * 1000/10*10 - 1 = 999
		 */
		Long s = mirror((k / order) * order - order + 1);
		if (order * 10 == k && k / 10 == order)
			s = mirror((k / order) * order - 1);

		// Obtain the nearest value among s, curr and g
		Long f = getClosest(curr, g, s, k);

		// Return the cloest palindrome
		return f + "";
	}

	// Append first half to second half of Long
	private Long mirror(Long n) {
		String s = String.valueOf(n);
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length / 2; i++)
			arr[arr.length - 1 - i] = arr[i];
		return Long.valueOf(new String(arr));
	}

	// Obtain Closest Value to k
	// You will always end up with at most 1 larger value to k and one smaller value
	// from k
	// Return the closest among these 2
	private Long getClosest(Long curr, Long g, Long s, Long k) {
		Long larger = g;
		Long smaller = s;
		if (curr > k) {
			larger = Math.min(curr, g); // Choose the Ceiling
		} else if (curr < k) {
			smaller = Math.max(curr, s); // Choose the floor
		}
		// Return the value closest. If there's a tie, use the smaller number ( Hence,
		// the Less than or Equal to operator )
		return k - smaller <= larger - k ? smaller : larger;
	}
}

package Leetcode;

/*
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
 */
public class BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		int res = 0;
		while (m > 0 && n > 0) {
			int msb1 = msb(m);
			int msb2 = msb(n);
			if (msb1 != msb2)
				break;
			int msb_val = (1 << msb1);
			res = res + msb_val;
			m = m - msb_val;
			n = n - msb_val;
		}
		return res;
	}

	public int msb(long n) {
		int msb = -1;
		while (n > 0) {
			n = n >> 1;
			msb++;
		}
		return msb;
	}
}

package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/*
 * Please Note:
There are certain problems which are asked in the interview to also check how you take care of overflows in your problem.
This is one of those problems.
Please take extra care to make sure that you are type-casting your ints to long properly and at all places. Try to verify if your solution works if number of elements is as large as 105

 Food for thought :
Even though it might not be required in this problem, in some cases, you might be required to order the operations cleverly so that the numbers do not overflow.
For example, if you need to calculate n! / k! where n! is factorial(n), one approach is to calculate factorial(n), factorial(k) and then divide them.
Another approach is to only multiple numbers from k + 1 ... n to calculate the result.
Obviously approach 1 is more susceptible to overflows.
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4
 */
public class RepeatandMissingNumberArray {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
		int xor = 0;
		for (int i = 0; i < A.size(); i++) {
			xor = xor ^ A.get(i) ^ (i + 1);
		}
		int bit = 0;
		while (xor != 0) {
			if ((xor & 1) != 0) {
				break;
			}
			bit++;
			xor >>= 1;
		}

		int set_bit_num = 0;
		int unset_bit_num = 0;
		for (int i = 0; i < A.size(); i++) {
			if (checkBit(A.get(i), bit)) {
				set_bit_num ^= A.get(i);
			} else {
				unset_bit_num ^= A.get(i);
			}
			if (checkBit(i + 1, bit)) {
				set_bit_num ^= i + 1;
			} else {
				unset_bit_num ^= i + 1;
			}
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (A.contains(set_bit_num)) {
			result.add(0, set_bit_num);
			result.add(1, unset_bit_num);
		} else {
			result.add(0, unset_bit_num);
			result.add(1, set_bit_num);
		}

		return result;
	}

	public static boolean checkBit(int n, int i) {
		return ((n >> i) & 1) != 0;
	}
}

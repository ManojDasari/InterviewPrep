package InterviewBit;

/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
Return the sum of the three integers.

Assume that there will only be one solution

Example:
given array S = {-1 2 1 -4},
and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

 */
import java.util.ArrayList;
import java.util.Collections;

public class ThreeSum {
	public int threeSumClosest(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		int res = 0;
		int closest = Integer.MAX_VALUE;
		for (int i = 0; i < A.size(); i++) {
			int k = i + 1, l = A.size() - 1;
			while (k < l) {
				int currSum = A.get(i) + A.get(k) + A.get(l);
				int diff = Math.abs(currSum - B);
				if (diff == 0) {
					return B;
				}
				if (diff < closest) {
					closest = diff;
					res = currSum;
				}
				if (currSum <= B) {
					k++;
				} else {
					l--;
				}
			}
		}
		return res;
	}
}

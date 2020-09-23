package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem Description

Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].



Input Format
First and only argument is an integer array A.



Output Format
Return an integer denoting the maximum value of j - i;



Example Input
Input 1:

 A = [3, 5, 4, 2]


Example Output
Output 1:

 2


Example Explanation
Explanation 1:

 Maximum value occurs for pair (3, 4).
 */
public class maxDistance {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static int maximumGap(final List<Integer> A) {
		int maxDiff;
		int i, j;

		int n = A.size();
		int rightMax[] = new int[n];
		int leftMin[] = new int[n];

		leftMin[0] = A.get(0);

		for (i = 1; i < n; ++i) {
			leftMin[i] = Math.min(A.get(i), leftMin[i - 1]);
		}

		rightMax[n - 1] = A.get(n - 1);
		for (j = n - 2; j >= 0; --j) {
			rightMax[j] = Math.max(A.get(j), rightMax[j + 1]);
		}

		i = 0;
		j = 0;
		maxDiff = 0;
		while (j < n && i < n) {
			if (leftMin[i] <= rightMax[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j++;
			} else {
				i++;
			}
		}

		return maxDiff;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0, 3);
		list.add(1, 2);
		list.add(2, 0);
		System.out.println(maximumGap(list));
	}
}

package Leetcode;

/*
 * The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
 */
public class permutationSequence {
	int count = 0;

	public String getPermutation(int n, int k) {
		if (n <= 0 || k <= 0) {
			return "";
		}
		String result = "";
		int num[] = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = i + 1;
		}

		getPermutationHelper(num, k, 0);
		for (int i = 0; i < num.length; i++) {
			result = result + num[i];
		}

		return result;
	}

	private boolean getPermutationHelper(int[] num, int k, int start) {
		if (start >= num.length) {
			count++;
			if (count == k) {
				return true;
			}
			return false;
		}

		for (int i = start; i < num.length; i++) {
			for (int j = start; j < i; j++) {
				swap(num, j, i);
			}
			if (getPermutationHelper(num, k, start + 1) == true) {
				return true;
			}

			for (int j = i - 1; j >= start; j--) {
				swap(num, j, i);
			}
		}
		return false;
	}

	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}

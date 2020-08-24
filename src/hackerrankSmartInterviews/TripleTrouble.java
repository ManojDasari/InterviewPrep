package hackerrankSmartInterviews;
/*
 * Given an array of size 3X+1, where every element occurs three times, except one element, which occurs only once. Find the element that occurs only once.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size of the array (of the form 3X + 1) and second line contains the elements of the array.

Constraints

1 <= T <= 300
1 <= N <= 104
1 <= A[i] <= 109

Output Format

For each test case, print the number which occurs only once, separated by new line.

Sample Input 0

2
10
5 7 8 7 7 5 5 9 8 8 
7
10 20 20 30 20 10 10 
Sample Output 0

9
30
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TripleTrouble {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int count = Integer.parseInt(bufferedReader.readLine().trim());
			String[] array = bufferedReader.readLine().trim().split(" ");
			// ArrayList<Integer> inputList = new ArrayList<Integer>();
			int[] input = new int[count];
			for (int j = 0; j < count; j++) {
				// inputList.add(Integer.parseUnsignedInt((array[j])));
				input[j] = Integer.parseInt(array[j]);
			}
			// uniqueNumber(inputList);
			mergeSort(input, 0, count - 1);
			System.out.println(checkTripleTrouble(input, count));
		}
	}

	public static void uniqueNumber(ArrayList<Integer> A) {
		int result = 0;
		for (int i = 0; i < 32; ++i) {
			int sum = 0;
			for (int j = 0; j < A.size(); ++j) {
				if (((A.get(j) >> i) & 1) == 1) {
					++sum;
					sum %= 3;
				}
			}
			if (sum != 0)
				result |= sum << i;
		}
		System.out.println(result);
	}

	public static void mergeSort(int[] input, int low, int high) {
		if (low == high)
			return;
		int mid = (low + high) / 2;
		mergeSort(input, low, mid);
		mergeSort(input, mid + 1, high);
		merge(input, low, high);
	}

	public static void merge(int[] input, int low, int high) {
		int[] temp = new int[high - low + 1];
		int mid = (high + low) / 2;
		int p1 = low, p2 = mid + 1;
		int k = 0;
		while (p1 <= mid && p2 <= high) {
			if (input[p1] < input[p2])
				temp[k++] = input[p1++];
			else
				temp[k++] = input[p2++];
		}
		while (p1 <= mid)
			temp[k++] = input[p1++];
		while (p2 <= high)
			temp[k++] = input[p2++];
		for (int i = low; i <= high; i++) {
			input[i] = temp[i - low];
		}
	}

	public static int checkTripleTrouble(int[] input, int N) {
		int i;
		for (i = 0; i < N - 2; i += 3) {
			if (input[i] != input[i + 1] && input[i] != input[i + 2])
				return input[i];
		}
		return input[i];
	}
}
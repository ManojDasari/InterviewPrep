package hackerrankSmartInterviews;
/*Given an array, you have to find the floor of a number x. The floor of a number x is nothing but the largest number in the array less than or equal to x.

Input Format

First line of input contains N - size of the array. The next line contains N integers, the elements of the array. The next line contains Q - number of queries. Each of the next Q lines contains a single integer X, for which you have to find the floor of X in the given array.

Constraints

30 points
1 <= N <= 105
1 <= Q <= 102
-108 <= ar[i] <= 108

70 points
1 <= N <= 105
1 <= Q <= 105
-108 <= ar[i] <= 108

Output Format

For each query, print the floor of X, separated by newline. If floor not found, print the value of "INT_MIN"

Sample Input 0

6
-6 10 -1 20 15 5 
5
-1
10
8
-10
-4
Sample Output 0

-1
10
5
-2147483648
-6
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindingtheFloor {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(bufferedReader.readLine().trim());
		String[] array = bufferedReader.readLine().trim().split(" ");
		int[] input = new int[count];
		for (int j = 0; j < count; j++) {
			input[j] = Integer.parseInt(array[j]);
		}
		int querieCount = Integer.parseInt(bufferedReader.readLine().trim());
		int[] queries = new int[querieCount];
		for (int j = 0; j < querieCount; j++) {
			queries[j] = Integer.parseInt(bufferedReader.readLine().trim());
		}
		Arrays.sort(input);
		for (int i = 0; i < querieCount; i++)
			System.out.println(findFloorforInput(input, 0, count - 1, queries[i]));
	}

	public static int findFloorforInput(int[] input, int low, int high, int x) {
		int ans = Integer.MIN_VALUE;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (input[mid] > x) {
				high = mid - 1;
			} else {
				ans = Math.max(ans, input[mid]);
				low = mid + 1;
			}

		}
		return ans;
	}

}
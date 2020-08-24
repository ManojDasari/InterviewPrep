package hackerrankSmartInterviews;

/*
 * You are given an integer array and a positive integer K. You have to tell if there exists a pair of integers in the given array such that ar[i]-ar[j]=K and i≠j.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N and K - the size of the array and the number K. The second line contains the elements of the array.

Constraints

1 <= T <= 50
2 <= N <= 100000
1 <= K <= 100000
-100000 <= A[i] <= 100000

Output Format

For each test case, print "true" if the arrays contains such elements, false otherwise, separated by new line.

Sample Input 0

2
5 60
1 20 40 100 80 
10 11
12 45 52 65 21 645 234 14 575 112 
Sample Output 0

true
false
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PairwithDifferenceK {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] lengthandSumValues = bufferedReader.readLine().trim().split(" ");
			int count = Integer.parseInt(lengthandSumValues[0]);
			int sum = Integer.parseInt(lengthandSumValues[1]);
			String[] array = bufferedReader.readLine().trim().split(" ");
			int[] input = new int[count];
			for (int j = 0; j < count; j++) {
				input[j] = Integer.parseInt(array[j]);
			}
			Arrays.sort(input);
			checkSumPairsBS(input, count - 1, sum);
		}
	}

	public static void checkSumPairsBS(int[] input, int count, int sum) {
		int low = 0, high = count;
		for (int i = 1; i <= count; i++) {
			int x = sum + input[i - 1];
			if (binarySearch(input, i, count, x)) {
				System.out.println("true");
				return;
			}
		}
		System.out.println("false");
	}

	public static boolean binarySearch(int[] input, int low, int high, int x) {
		while (low <= high) {
			int mid = (high + low) / 2;
			if (input[mid] == x)
				return true;
			if (input[mid] < x)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return false;
	}

}
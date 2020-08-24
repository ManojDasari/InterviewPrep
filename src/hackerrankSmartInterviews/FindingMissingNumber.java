package hackerrankSmartInterviews;

/*
 * Given an array of size N, it contains all the numbers from 1 to N+1 inclusive, except one number. You have to find the missing number.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, first line of each test case contains N - size of the array and the next line contains N integers - the elements of the array.

Constraints

1 <= T <= 500
1 <= N <= 10000
1 <= ar[i] <= N+1

Output Format

For each test case, print the missing number, separated by newline.

Sample Input 0

3
8
1 2 7 9 5 6 3 8 
7
3 5 8 1 4 7 2 
10
8 11 10 2 7 4 3 5 1 6 
Sample Output 0

4
6
9
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindingMissingNumber {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int input = Integer.parseInt(bufferedReader.readLine().trim());
			String[] array = bufferedReader.readLine().trim().split(" ");
			int result = 0;
			int k = 0, j = 1;
			for (; k < input; k++, j++) {
				result ^= (j ^ Integer.parseInt(array[k]));
			}
			result ^= j;
			System.out.println(result);
		}
	}
}
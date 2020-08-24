package hackerrankSmartInterviews;

/*
 * Given an array of integers, find the largest number that can be constructed by concatenating all the elements of the given array.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - size of the array and the second line contains N integers - elements of the array.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 1000

Output Format

For each test case, print the largest number that can be constructed by concatenating all the elements of the given array, separated by newline.

Sample Input 0

3
8
49 73 58 30 72 44 78 23 
4
69 9 57 60 
2
40 4 
Sample Output 0

7873725849443023
9696057
440
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestConcatenatedNumber {

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
			List<String> input = new ArrayList<String>();
			for (String s : array) {
				input.add(s);
			}
			printLargestNumber(input, count);
		}
	}

	public static void printLargestNumber(List<String> input, int N) {
		Collections.sort((List<String>) input, ((a, b) -> {
			String s1 = a.toString() + b.toString();
			String s2 = b.toString() + a.toString();
			return s2.compareTo(s1);
		}));
		if (input.get(0).equals("0")) {
			System.out.println(0);
			return;
		}
		StringBuilder largestNumberStr = new StringBuilder();
		for (String numAsStr : input) {
			largestNumberStr.append(numAsStr);
		}

		System.out.println(largestNumberStr.toString());
	}
}
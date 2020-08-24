package hackerrankSmartInterviews;
/*
 * Given a number, check if it is a power of 2.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line containing a single positive integer.

Constraints

1 <= T <= 10000
1 <= N <= 1018

Output Format

For each test case, print "True" or "False", separated by new line.

Sample Input 0

5
1
8
10
25
512
Sample Output 0

True
True
False
False
True
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckPowerofTwo {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			long input = Long.parseUnsignedLong(bufferedReader.readLine().trim());
			System.out.println(isPower(input));
		}
	}

	public static String isPower(long input) {
		int count = 0;
		while (input > 0) {
			if (input % 2 != 0)
				count++;
			input = input >> 1;
		}
		if (count > 1)
			return "False";
		else
			return "True";
	}
}
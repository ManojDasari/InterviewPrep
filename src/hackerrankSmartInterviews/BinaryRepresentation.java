package hackerrankSmartInterviews;

/*
 * Given a positive integer, print its binary representation.
Note: Do not use any inbuilt functions/libraries for your main logic.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line containing a single integer.

Constraints

1 <= T <= 10000
0 <= N <= 109

Output Format

For each test case, print binary representation, separated by new line.

Sample Input 0

5
10
15
7
1
120
Sample Output 0

1010
1111
111
1
1111000
 */
import java.io.*;
import java.util.*;

public class BinaryRepresentation {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			long input = Long.parseLong(bufferedReader.readLine().trim());
			printBinary(input);
			System.out.println("");
		}
	}

	public static void printBinary(long input) {
		StringBuilder result = new StringBuilder();
		if (input == 0) {
			System.out.print("0");
			return;
		}

		while (input > 0) {
			result.append(String.valueOf(input % 2));
			input = input >> 1;
		}
		System.out.print(result.reverse().toString());
	}
}
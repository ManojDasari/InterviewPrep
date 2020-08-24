package hackerrankSmartInterviews;

/*
 * Given a number, swap the adjacent bits in the binary representation of the number, and print the new number formed after swapping.

Input Format

First line of input contains T - number of test cases. Each of the next T lines contains a number N.

Constraints

1 <= T <= 100000
0 <= N <= 109

Output Format

For each test case, print the new integer formed after swapping adjacent bits, separated by new line.

Sample Input

4
10
7
43
100

Sample Output

5
11
23
152

Explanation

Test Case 1

Binary Representation of 10: 000...1010
After swapping adjacent bits: 000...0101 (5)

Test Case 2

Binary Representation of 7: 000...0111
After swapping adjacent bits: 000...1011 (11)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapBits {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int input1 = Integer.parseUnsignedInt(bufferedReader.readLine().trim());
			swapBits(input1);
			System.out.println("");
		}
	}

	public static void swapBits(int input) {
		long result = (((input & 0xAAAAAAAA) >> 1) | ((input & 0x55555555) << 1));
		System.out.print(result);
	}
}

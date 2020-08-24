package hackerrankSmartInterviews;

/*
 * Given a number, reverse the bits in the binary representation (consider 32-bit unsigned data) of the number, and print the new number formed.

Input Format

First line of input contains T - number of test cases. Each of the next T lines contains a number integer N.

Constraints

1 <= T <= 100000
0 <= N <= 109

Output Format

For each test case, print the new number formed after reversing the bits, separated by new line.

Sample Input

4
4
15
6
1000000000

Sample Output

536870912
4026531840
1610612736
5462492

Explanation

Test Case 1

Binary Representation of 4: 000...100
After reversing the bits: 001...000 (536870912)

Test Case 2

Binary Representation of 15: 000...1111
After reversing the bits: 1111...000 (4026531840)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reversebits {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int input1 = Integer.parseUnsignedInt(bufferedReader.readLine().trim());
			reverseBits(input1);
			System.out.println("");
		}
	}

	public static void reverseBits(int input) {
		long result = 0;
		int n = 31;
		while (input > 0) {
			result += (input % 2) * Math.pow(2, n);
			n--;
			input = input >> 1;
		}
		System.out.print(result);
	}
}
package hackerrankSmartInterviews;

/*
 * You are given two numbers A and B. Write a program to count the number of bits to be flipped to change the number A to the number B. Flipping a bit of a number means changing a bit from 1 to 0 or vice versa.

Input Format

First line of input contains T - number of test cases. Each of the next T lines contains 2 integer A and B, separated by space.

Constraints

1 <= T <= 100000
0 <= N <= 109

Output Format

For each test case, print the number of bit flips required to convert A to B, separated by new line.

Sample Input 0

4
20 10
16 8
1 153
549 24
Sample Output 0

4
2
3
6
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlipBits {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] array = bufferedReader.readLine().trim().split(" ");
			long input1 = Long.parseLong(array[0]);
			long input2 = Long.parseLong(array[1]);
			flipBits(input1, input2);
			System.out.println("");
		}
	}

	public static void flipBits(long input1, long input2) {
		long count = 0;
		if (input1 == input2) {
			System.out.print(count);
			return;
		}
		long maxValue = Math.max(input1, input2);
		long minValue = Math.min(input1, input2);
		while (maxValue > 0) {
			if (maxValue % 2 != minValue % 2)
				count++;
			maxValue = maxValue >> 1;
			minValue = minValue >> 1;
		}
		System.out.print(count);
	}
}
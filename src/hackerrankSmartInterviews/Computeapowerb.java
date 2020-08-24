package hackerrankSmartInterviews;

/*
 * Given 2 numbers - a and b, evaluate ab.
Note: Do not use any inbuilt functions/libraries for your main logic.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line containing 2 numbers - a and b, separated by space.

Constraints

30 points
1 <= T <= 1000
0 <= a <= 106
0 <= b <= 103

70 points
1 <= T <= 1000
0 <= a <= 106
0 <= b <= 109

Output Format

For each test case, print ab, separated by new line. Since the result can be very large, print result % 1000000007

Sample Input 0

4
5 2
1 10
2 30
10 10
Sample Output 0

25
1
73741817
999999937
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Computeapowerb {
	static long MOD = (long) (1e9 + 7);

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] array = bufferedReader.readLine().trim().split(" ");
			long input1 = Long.parseUnsignedLong(array[0]);
			long input2 = Long.parseUnsignedLong(array[1]);
			System.out.print(recuapowerb(input1, input2));
			System.out.println("");
		}
	}

	public static void apowerb(long a, long b) {
		long MOD = (long) (1e9 + 7);
		long result = Long.parseUnsignedLong("1");
		for (int i = 0; b > 0; i++) {
			if (b % 2 == 1) {
				result = result * a % MOD;
			}
			b = b / 2;
			a = a * a % MOD;
		}
		System.out.print(result);
	}

	public static long recuapowerb(long a, long b) {
		if (b == 0)
			return (long) 1;
		long x = recuapowerb(a, b / 2);
		x = x * x % MOD;
		if (b % 2 == 0)
			return x;
		return (a * x) % MOD;
	}
}
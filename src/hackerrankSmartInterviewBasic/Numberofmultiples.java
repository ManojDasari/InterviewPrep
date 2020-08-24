package hackerrankSmartInterviewBasic;

/*
 * Given a positive integer - N. Print the number of multiples of 3, 5 between [1, N].

Input Format

Input contains positive integer - N.

Constraints

1 <= N <=1018

Output Format

Print the number of multiples of 3, 5 in range of 1 to N.

Sample Input 0

11
Sample Output 0

5
Explanation 0

Multiples of 3 and 5 in range of 1 to 11 are 3, 5, 6, 9, 10.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numberofmultiples {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		long input = Long.parseLong(bufferedReader.readLine());
		long count = 0;
		count = (input / 3) + (input / 5) - (input / 15);
		System.out.println(count);
	}
}
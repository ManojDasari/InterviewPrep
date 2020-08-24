package hackerrankSmartInterviews;

/*
 * You are given an array of n+2 elements. All elements of the array are in range 1 to n. All elements occur once except two numbers, which occur twice. Your task is to find the two repeating numbers.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size of the array and second line contains the elements of the array.

Constraints

30 points
1 <= T <= 100
4 <= N <= 103

70 points
1 <= T <= 100
4 <= N <= 106

Output Format

Print the 2 repeated numbers in sorted manner, for each test case, separated by new line.

Sample Input 0

2
8
1 3 2 3 4 6 5 5 
10
1 5 2 8 1 4 7 4 3 6 
Sample Output 0

3 5
1 4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatedNumbers {

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
			int[] input = new int[count];
			for (int j = 0; j < count; j++) {
				input[j] = Integer.parseInt(array[j]);
			}
			repeatedNumbers(input, count);
			System.out.println();
		}
	}

	public static void repeatedNumbers(int[] input, int N) {
		int xor = 0;
		for (int i = 0; i < N; i++)
			xor = xor ^ input[i];

		for (int i = 1; i <= N - 2; i++) {
			xor ^= i;
		}
		int bit = 0;
		while (xor != 0) {
			if ((xor & 1) != 0) {
				break;
			}
			bit++;
			xor >>= 1;
		}

		int set_bit_num = 0;
		int unset_bit_num = 0;
		for (int i = 0; i < N; i++) {
			if (checkBit(input[i], bit)) {
				set_bit_num ^= input[i];
			} else {
				unset_bit_num ^= input[i];
			}
		}
		for (int i = 1; i <= N - 2; i++) {
			if (checkBit(i, bit)) {
				set_bit_num ^= i;
			} else {
				unset_bit_num ^= i;
			}
		}
		System.out.print(
				set_bit_num < unset_bit_num ? set_bit_num + " " + unset_bit_num : unset_bit_num + " " + set_bit_num);
	}

	public static boolean checkBit(int n, int i) {
		return ((n >> i) & 1) != 0;
	}
}
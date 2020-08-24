package hackerrankSmartInterviews;

/*
 * There are 2 teams, each having N players. There will be N rounds played between the 2 teams. In every round, a player from team A plays against a player from team B. The more powerful player wins the game. Given the strength of the players of both the teams, you have to find the maximum number of rounds team A can win. Note that a player cannot play more than 1 round.

Input Format

First line of input contains T - number of test cases. Its followed by 3T lines. The first line contains N - size of the team. The next 2 lines contains N numbers each - strength of the players of team A and team B respectively.

Constraints

1 <= T <= 500
1 <= N <= 10000
0 <= A[i], B[i] <= 10000

Output Format

For each test case, print the maximum number of rounds team A can win, separated by newline.

Sample Input 0

3
4
1 5 7 4 
3 8 2 10 
2
2 3 
10 5 
3
3 7 10 
5 20 15 
Sample Output 0

2
0
1
Explanation 0

Test Case 1
Player with strength 5 in team A can defeat player with strength 3 in team B.
Player with strength 7 in team A can defeat player with strength 2 in team B.

Test Case 2
No Player in team A can defeat any player in team B.

Test Case 1
Player with strength 7 in team A can defeat player with strength 5 in team B.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PowerGame {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int count = Integer.parseInt(bufferedReader.readLine().trim());
			String[] input1 = bufferedReader.readLine().trim().split(" ");
			String[] input2 = bufferedReader.readLine().trim().split(" ");
			int[] array1 = new int[count];
			int[] array2 = new int[count];
			for (int j = 0; j < count; j++) {
				array1[j] = Integer.parseInt(input1[j]);
			}
			for (int j = 0; j < count; j++) {
				array2[j] = Integer.parseInt(input2[j]);
			}
			maxCountInput1(array1, array2, count);
		}
	}

	public static void maxCountInput1(int[] input1, int[] input2, int N) {
		int result = 0;
		int previous = -1;
		Arrays.sort(input1);
		Arrays.sort(input2);
		for (int i = 0; i < N; i++) {
			for (int j = previous + 1; j < N; j++) {
				if (input1[i] > input2[j]) {
					previous = j;
					j++;
					result++;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
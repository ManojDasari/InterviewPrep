package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NumberofDiceRollsforgivensum {
	static int[] dp = new int[100002];
	static int M = (int) (1e9 + 7);

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		numberRollDices(100001);
		for (int i = 0; i < testCases; i++) {
			int N = Integer.parseInt(bufferedReader.readLine().trim());
			bufferedWriter.write(dp[N] + "\n");
		}
		bufferedWriter.flush();
	}

	public static void numberRollDices(int N) {
		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 6 && i - j >= 0; j++) {
				dp[i] = (dp[i] + dp[i - j]) %M;
			}
		}
	}
}
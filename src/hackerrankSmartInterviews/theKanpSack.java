package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class theKanpSack {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		int[][] dp;
		for (int i = 0; i < testCases; i++) {
			String[] arr = bufferedReader.readLine().trim().split(" ");
			int S = Integer.parseInt(arr[0]);
			int N = Integer.parseInt(arr[1]);
			dp = new int[N + 1][S + 1];
			int[] w = new int[N];
			int[] v = new int[N];
			for (int j = 0; j < N; j++) {
				String[] array = bufferedReader.readLine().trim().split(" ");
				w[j] = Integer.parseInt(array[0]);
				v[j] = Integer.parseInt(array[1]);
			}
			int res = knapSack(N, S, w, v, dp);
			bufferedWriter.write(res + "\n");
		}
		bufferedWriter.flush();
	}

	public static int knapSack(int N, int K, int[] w, int[] v, int[][] dp) {
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (j >= w[i-1]) {
					dp[i][j] = Math.max(dp[i - 1][j - w[i - 1]] + v[i - 1], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[N][K];
	}
}
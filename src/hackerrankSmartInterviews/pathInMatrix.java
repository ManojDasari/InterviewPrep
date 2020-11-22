package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class pathInMatrix {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		int Mod = (int) (1e9 + 7);
		for (int i = 0; i < testCases; i++) {
			String[] arr = bufferedReader.readLine().trim().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			int P = Integer.parseInt(arr[2]);
			int[][] forbidenCells = new int[P][2];
			for (int j = 0; j < P; j++) {
				String[] array = bufferedReader.readLine().trim().split(" ");
				for (int k = 0; k < 2; k++) {
					forbidenCells[j][k] = Integer.parseInt(array[k]);
				}
			}
			collectApples(N, M, forbidenCells, Mod, bufferedWriter);
		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	public static void collectApples(int N, int M, int[][] input, int Mod, BufferedWriter bw) throws IOException {
		int[][] dp = new int[N+1][M+1];
		HashSet<Integer> hsRow = new HashSet<Integer>();
		HashSet<Integer> hsCol = new HashSet<Integer>();
		for (int i = 0; i < input.length; i++) {
			hsRow.add(input[i][0]);
			hsCol.add(input[i][1]);
		}
		boolean flag = true;
		for (int i = 0; i <= M; i++) {
			if (hsRow.contains(0) && hsCol.contains(i)) {
				flag = false;
			}
			if (flag)
				dp[0][i] = 1;
			else
				dp[0][i] = 0;
		}
		flag = true;
		for (int i = 0; i <= N; i++) {
			if (hsRow.contains(i) && hsCol.contains(0)) {
				flag = false;
			}
			if (flag)
				dp[i][0] = 1;
			else
				dp[i][0] = 0;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (hsRow.contains(i) && hsCol.contains(j)) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % Mod;
				}
			}
		}
		bw.write(dp[N][M] + "\n");
	}

}
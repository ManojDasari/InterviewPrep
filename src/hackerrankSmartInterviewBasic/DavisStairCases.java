package hackerrankSmartInterviewBasic;

//https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DavisStairCases {
	static int MOD = (int) 1e10 + 7;

	// Complete the stepPerms function below.
	static int stepPerms(int n) {
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;

		if (n >= 2) {
			res[2] = 2;
			for (int i = 3; i <= n; i++) {
				res[i] = res[i - 1] + res[i - 2] + res[i - 3];
				res[i] = res[i] % MOD;
			}
		}
		return res[n];
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int s = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int sItr = 0; sItr < s; sItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int res = stepPerms(n);

			bufferedWriter.write(String.valueOf(res));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}

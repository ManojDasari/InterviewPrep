package FinalTestSI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class partitionStringsSI {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] arr = bufferedReader.readLine().trim().split(" ");
			int N = Integer.parseInt(arr[0]);
			int K = Integer.parseInt(arr[1]);
			String input = bufferedReader.readLine().trim();
			partitionStrings(input, N, K, bufferedWriter);
		}
		bufferedWriter.flush();
	}

	public static void partitionStrings(String str, int N, int K, BufferedWriter bw) throws IOException {
		int count = 0;
		int M = (int) (1e9 + 7);
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				int right = Integer.valueOf(str.substring(i, N));
				if (right >= 1 && right <= K) {
					count = (count + 1) % M;
				}
			} else {
				int left = Integer.valueOf(str.substring(0, i));
				int right = Integer.valueOf(str.substring(i, N));
				if (left >= 1 && left <= K && right >= 1 && right <= K) {
					count = (count + 1) % M;
				}
			}

		}
		bw.write(count + "\n");
	}

}
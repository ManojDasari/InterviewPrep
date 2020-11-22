package FinalTestSI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class maxSumZero {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int N = Integer.parseInt(bufferedReader.readLine().trim());
			String[] array = bufferedReader.readLine().trim().split(" ");
			int[] input = new int[N];
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(array[j]);
			}
			longestSumZero(input, N, bufferedWriter);
		}
		bufferedWriter.flush();
	}

	public static void longestSumZero(int[] input, int N, BufferedWriter bw) throws IOException {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0, maxlen = 0;
		for (int i = 0; i < N; i++) {
			sum += input[i];
			if (sum == 0 && maxlen == 0) {
				maxlen = 1;
			}
			if (sum == 0)
				maxlen = i + 1;
			Integer prev = map.get(sum);
			if (prev != null) {
				maxlen = Math.max(maxlen, i - prev);
			} else {
				map.put(sum, i);
			}
		}
		bw.write(maxlen + "\n");
	}
}
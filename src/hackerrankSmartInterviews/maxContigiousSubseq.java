package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class maxContigiousSubseq {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < testCases; i++) {
			int N = Integer.parseInt(bufferedReader.readLine());
			String[] array = bufferedReader.readLine().split(" ");
			int[] input = new int[N];
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(array[j]);
			}
			System.out.println(maxContigiousSubsequence(input, N));
		}
	}

	public static int maxContigiousSubsequence(int[] input, int N) {
		Arrays.sort(input);
		int maxCount = 1, currCount = 1;
		for (int i = 0; i < N; i++) {
			if (i > 0 && input[i] == input[i - 1])
				continue;
			if (i > 0 && input[i] == (input[i - 1] + 1))
				currCount++;
			else {
				currCount = 1;
			}
			maxCount = Math.max(maxCount, currCount);
		}

		return maxCount;
	}
}
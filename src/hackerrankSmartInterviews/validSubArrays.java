package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class validSubArrays {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int N = Integer.parseInt(bufferedReader.readLine().trim());
			String[] array = bufferedReader.readLine().trim().split(" ");
			int[] input = new int[N];
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(array[j]);
			}
			validSubArrays(input, N);
		}
	}

	public static void validSubArrays(int[] input, int N) {
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (input[i] == 0)
				input[i] = -1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += input[k];
				}
				if (sum == 0)
					result++;
			}
		}
		System.out.println(result);
	}

}
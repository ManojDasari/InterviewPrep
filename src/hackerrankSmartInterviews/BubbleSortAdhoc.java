package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSortAdhoc {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int count = Integer.parseInt(bufferedReader.readLine().trim());
			int[] input = new int[count];
			int j = 0;
			for (String s : bufferedReader.readLine().trim().split(" ")) {
				input[j] = Integer.parseInt(s);
				j++;
			}
			bubbleSort(input, count);
		}
	}

	public static void bubbleSort(int[] input, int N) {
		int result = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N - i - 1; j++)
				if (input[j] > input[j + 1]) {
					int temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
					result++;
				}
		}
		System.out.println(result);
	}

}
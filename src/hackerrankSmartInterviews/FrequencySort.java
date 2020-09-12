package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrequencySort {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < testCases; i++) {
			int N = Integer.parseInt(bufferedReader.readLine());
			String[] array = bufferedReader.readLine().trim().split(" ");
			int[] input = new int[N];
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(array[j]);
			}
			frequencySort(input, N);
			System.out.println();
		}

	}

	public static void frequencySort(int[] input, int N) {
		int a = -1000, b = 1000;
		int[] countArray = new int[b - a + 1];
		for (int i = 0; i < N; i++) {
			countArray[input[i] - a]++;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < b - a + 1; j++) {
				if (countArray[j] == i) {
					int temp = countArray[j];
					while (temp > 0) {
						System.out.print((j + a) + " ");
						temp--;
					}
				}
			}
		}
	}
}
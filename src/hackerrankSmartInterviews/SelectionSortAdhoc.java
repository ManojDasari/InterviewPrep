package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSortAdhoc {

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
			selectionSort(input, count);
			System.out.println();
		}
	}

	public static void selectionSort(int[] input, int N) {
		for (int i = N - 1; i > 0; i--) {
			int maxIndex = i;
			for (int j = i - 1; j >= 0; j--) {
				if (input[j] >= input[maxIndex]) {
					maxIndex = j;
				}
			}
			System.out.print(maxIndex + " ");
			int temp = input[i];
			input[i] = input[maxIndex];
			input[maxIndex] = temp;
		}
	}

}
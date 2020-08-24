package hackerrankSmartInterviewBasic;
//https://www.hackerrank.com/challenges/magic-square-forming/problem

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class formingMagicSqaure {
	static int minCost = Integer.MAX_VALUE;

	// Complete the formingMagicSquare function below.
	static int formingMagicSquare(int[][] s) {
		permuteHelper(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 0, s);
		return minCost;

	}

	private static void permuteHelper(int[] arr, int index, int[][] input2) {

		if (index >= arr.length - 1) { // If we are at the last element - nothing left to permute
			int[][] result = getMatrix(arr);
			int permutationCost = 0;
			if (isMagicSquare(result, 3)) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++)
						permutationCost += Math.abs(input2[i][j] - result[i][j]);
				}
				minCost = Math.min(minCost, permutationCost);
			}
			return;
		}

		for (int i = index; i < arr.length; i++) { // For each index in the sub array arr[index...end]

			// Swap the elements at indices index and i
			int t = arr[index];
			arr[index] = arr[i];
			arr[i] = t;

			// Recurse on the sub array arr[index+1...end]
			permuteHelper(arr, index + 1, input2);

			// Swap the elements back
			t = arr[index];
			arr[index] = arr[i];
			arr[i] = t;
		}
	}

	public static int[][] getMatrix(int[] input) {
		int[][] result = new int[3][3];
		int k = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				result[i][j] = input[k];
				k++;
			}
		}
		return result;
	}

	static boolean isMagicSquare(int mat[][], int N) {

		int sum = 0, sum2 = 0;
		for (int i = 0; i < N; i++)
			sum = sum + mat[i][i];

		for (int i = 0; i < N; i++)
			sum2 = sum2 + mat[i][N - 1 - i];

		if (sum != sum2)
			return false;

		for (int i = 0; i < N; i++) {

			int rowSum = 0;
			for (int j = 0; j < N; j++)
				rowSum += mat[i][j];

			if (rowSum != sum)
				return false;
		}
		for (int i = 0; i < N; i++) {

			int colSum = 0;
			for (int j = 0; j < N; j++)
				colSum += mat[j][i];

			if (sum != colSum)
				return false;
		}

		return true;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int[][] s = new int[3][3];

		for (int i = 0; i < 3; i++) {
			String[] sRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int sItem = Integer.parseInt(sRowItems[j]);
				s[i][j] = sItem;
			}
		}

		int result = formingMagicSquare(s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}

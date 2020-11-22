package FinalTestSI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SmartSquare {
	static int minCost = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int k = 0; k < testCases; k++) {
			int[][] s = new int[3][3];
			for (int i = 0; i < 3; i++) {
				String[] sRowItems = bufferedReader.readLine().trim().split(" ");
				for (int j = 0; j < 3; j++) {
					int sItem = Integer.parseInt(sRowItems[j]);
					s[i][j] = sItem;
				}
			}
			int result = formingMagicSquare(s);
			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}
		bufferedWriter.flush();

	}

	static int formingMagicSquare(int[][] s) {
		minCost = Integer.MAX_VALUE;
		permuteHelper(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 0, s);
		return minCost;

	}

	private static void permuteHelper(int[] arr, int index, int[][] input2) {

		if (index >= arr.length - 1) {
			int[][] result = getMatrix(arr);
			int permutationCost = 0;
			if (isSmartSquare(result, 3)) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++)
						permutationCost += Math.abs(input2[i][j] - result[i][j]);
				}
				minCost = Math.min(minCost, permutationCost);
			}
			return;
		}

		for (int i = index; i < arr.length; i++) {

			int t = arr[index];
			arr[index] = arr[i];
			arr[i] = t;

			permuteHelper(arr, index + 1, input2);

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

	static boolean isSmartSquare(int mat[][], int N) {

		int sum = 0, sum2 = 0;
		for (int i = 0; i < N; i++)
			sum = sum + mat[i][i];
		if (sum % 5 != 0)
			return false;

		for (int i = 0; i < N; i++)
			sum2 = sum2 + mat[i][N - 1 - i];

		if (sum2 % 5 != 0)
			return false;

		for (int i = 0; i < N; i++) {

			int rowSum = 0;
			for (int j = 0; j < N; j++)
				rowSum += mat[i][j];

			if (rowSum % 5 != 0)
				return false;
		}
		for (int i = 0; i < N; i++) {

			int colSum = 0;
			for (int j = 0; j < N; j++)
				colSum += mat[j][i];

			if (colSum % 5 != 0)
				return false;
		}

		return true;
	}
}
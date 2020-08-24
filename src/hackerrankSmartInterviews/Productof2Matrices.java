package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Productof2Matrices {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] size1 = bufferedReader.readLine().trim().split(" ");
			int[][] input1 = new int[Integer.parseInt(size1[0])][Integer.parseInt(size1[1])];
			for (int j = 0; j < Integer.parseInt(size1[0]); j++) {
				String[] array = bufferedReader.readLine().trim().split(" ");
				for (int k = 0; k < Integer.parseInt(size1[1]); k++) {
					input1[j][k] = Integer.parseInt(array[k]);
				}
			}
			String[] size2 = bufferedReader.readLine().trim().split(" ");
			int[][] input2 = new int[Integer.parseInt(size2[0])][Integer.parseInt(size2[1])];
			for (int j = 0; j < Integer.parseInt(size2[0]); j++) {
				String[] array = bufferedReader.readLine().trim().split(" ");
				for (int k = 0; k < Integer.parseInt(size2[1]); k++) {
					input2[j][k] = Integer.parseInt(array[k]);
				}
			}
			productMatrix(input1, input2, Integer.parseInt(size1[0]), Integer.parseInt(size1[1]),
					Integer.parseInt(size2[0]), Integer.parseInt(size2[1]));
		}
	}

	public static void productMatrix(int[][] input1, int[][] input2, int N1, int M1, int N2, int M2) {
		int[][] result = new int[N1][M2];
		for (int i = 0; i < N1; i++) {
			for (int j = 0; j < M2; j++) {
				for (int k = 0; k < N2; k++) {
					result[i][j] += input1[i][k] * input2[k][j];
				}
			}
		}

		for (int i = 0; i < N1; i++) {
			for (int j = 0; j < M2; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
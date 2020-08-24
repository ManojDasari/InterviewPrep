package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpiralTraversalofMatrix {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int size = Integer.parseInt(bufferedReader.readLine().trim());
			int[][] input = new int[size][size];
			for (int j = 0; j < size; j++) {
				String[] array = bufferedReader.readLine().trim().split(" ");
				for (int k = 0; k < size; k++) {
					input[j][k] = Integer.parseInt(array[k]);
				}
			}
			spiralMatrix(input, size);
			System.out.println("");
		}
	}

	public static void spiralMatrix(int[][] input, int N) {
		int row = N, col = N, l = 0, m = 0;
		while (l < row && m < col) {
			for (int i = m; i < col; i++) {
				System.out.print(input[l][i] + " ");
			}
			l++;
			for (int i = l; i < row; i++) {
				System.out.print(input[i][col - 1] + " ");
			}
			col--;
			if (l < row) {
				for (int i = col - 1; i >= m; i--) {
					System.out.print(input[row - 1][i] + " ");
				}
				row--;
			}
			if (m < col) {
				for (int i = row - 1; i >= l; i--) {
					System.out.print(input[i][m] + " ");
				}
				m++;
			}
		}

	}
}
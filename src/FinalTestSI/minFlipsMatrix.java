package FinalTestSI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class minFlipsMatrix {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] arr = bufferedReader.readLine().trim().split(" ");
			int R = Integer.parseInt(arr[0]);
			int C = Integer.parseInt(arr[1]);
			int[][] input = new int[R][C];
			for (int j = 0; j < R; j++) {
				String array = bufferedReader.readLine().trim();
				for (int k = 0; k < C; k++) {
					input[j][k] = Integer.parseInt(String.valueOf(array.charAt(k)));
				}
			}
			minFlips(input, R, C, bufferedWriter);
		}
		bufferedWriter.flush();
	}

	public static void minFlips(int[][] input, int R, int C, BufferedWriter bw) throws IOException {
		int minFlips = 0;
		int[] index = lastZero(input, R, C);
		while (index[0] != -1 && index[1] != -1) {
			minFlips++;
			input = flipMatrix(input, index[0], index[1], R, C);
			index = lastZero(input, R, C);
		}
		bw.write(minFlips + "\n");
		return;
	}

	public static int[][] flipMatrix(int[][] input, int x, int y, int R, int C) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (i == x && j == y) {
					input[i][j] = input[i][j] == 1 ? 0 : 1;
					return input;
				}
				input[i][j] = input[i][j] == 1 ? 0 : 1;
			}
		}
		return input;
	}

	public static int[] lastZero(int[][] input, int R, int C) {
		int[] index = new int[2];
		index[0] = -1;
		index[1] = -1;
		for (int i = R - 1; i >= 0; i--) {
			for (int j = C - 1; j >= 0; j--) {
				if (input[i][j] == 0) {
					index[0] = i;
					index[1] = j;
					return index;
				}
			}
		}
		return index;
	}
}
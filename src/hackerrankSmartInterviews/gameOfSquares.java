package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class gameOfSquares {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] win = new boolean[1000001];
		int squares[] = new int[1001];
		for (int i = 1; i < 1001; i++)
			squares[i] = i * i;
		Arrays.fill(win, false);
		for (int i = 1; i < 1000001; i++) {
			for (int j = 1; squares[j] <= i; j++) {
				win[i] |= (!win[i - squares[j]]);
				if (win[i])
					break;
			}
		}
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int j = 0; j < testCases; j++) {
			int input = Integer.parseInt(bufferedReader.readLine().trim());
			if (win[input])
				bufferedWriter.write("Win" + "\n");
			else
				bufferedWriter.write("Lose" + "\n");
		}
		bufferedWriter.flush();

	}
}
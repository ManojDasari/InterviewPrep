package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class TwoSetBits {
	static ArrayList<Integer> result;

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = (int) (1e9) + 7;
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		result = new ArrayList<Integer>();
		twoSetBits((long) (1e14), M);
		for (int i = 0; i < testCases; i++) {
			long input = Long.parseLong(bufferedReader.readLine().trim());
			bufferedWriter.write(result.get((int) input) + "\n");
		}
		bufferedWriter.flush();
	}

	public static void twoSetBits(long input, int M) {
		long x = 1;
		long y = 0;
		while (input > 0) {
			y = 0;
			while (y < x) {
				result.add(((1 << x) + (1 << y)) % M);
				input--;
				if (input == 0) {
					return;
				}
				y++;
			}
			x++;
		}
		result.add(((1 << x) + (1 << y)) % M);
	}
}
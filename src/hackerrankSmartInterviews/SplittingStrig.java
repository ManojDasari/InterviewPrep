package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SplittingStrig {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String input = bufferedReader.readLine().trim();
			System.out.println(printCuts(input, input.length(), 0));
		}
	}

	public static int printCuts(String input, int length, int count) {
		if (length == 1 || isPerfectString(input))
			return count;

		if (length % 2 != 0) {
			return -1;
		}
		int cnta = printCuts(input.substring(0, length / 2), length / 2, count + 1);
		int cntb = printCuts(input.substring(length / 2, length), length / 2, count + 1);

		if ((cnta >= 0 && cntb == -1))
			return cnta;
		else if (cnta == -1 && cntb >= 0)
			return cntb;
		if (cnta <= cntb)
			return cnta;
		else
			return cntb;

	}

	public static boolean isPerfectString(String input) {
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) != input.charAt(i - 1))
				return false;
		}
		return true;
	}
}
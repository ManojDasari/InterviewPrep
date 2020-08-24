package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindingCubeRoot {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			long input = Long.parseLong(bufferedReader.readLine().trim());
			System.out.println(cubeRoot(input));
		}
	}

	public static long cubeRoot(long input) {
		boolean flag = false;
		if (input < 0) {
			input *= -1;
			flag = true;
		}
		long start = 0, end = (long) 1e6;
		long mid = (start + end) / 2;
		while (start <= end) {
			mid = (start + end) / 2;
			long res = mid * mid * mid;
			if (res == input)
				break;
			else if (res < input) {
				start = mid + 1;
			} else
				end = mid - 1;

		}
		if (flag)
			return mid *= -1;
		else
			return mid;
	}
}
package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pwoerfulSubsets {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int N = Integer.parseInt(bufferedReader.readLine().trim());
			int[] input = new int[N];
			String[] array = bufferedReader.readLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(array[j]);
			}
			powerfulSubsets(input, N);
		}
	}

	static void powerfulSubsets(int[] input, int N) {
		if (N == 1) {
			if (isPowerOfTwo(input[0])) {
				System.out.println("YES");
				return;
			}
			System.out.println("NO");
			return;
		}
		int total = 0;
        for (int i = 0; i < 31; i++)
            total = total | (1 << i);

		for (int i = 0; i <= 31; i++) {
			long ans = total;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					ans &= input[j];
				}
			}
			if (isPowerOfTwo(ans)) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

	public static boolean isPowerOfTwo(long num) {
		if (num != 0 && (num & (num - 1)) == 0)
			return true;
		return false;
	}
}
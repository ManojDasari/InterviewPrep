package FinalTestSI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class TestClass {

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
			int N = Integer.parseInt(arr[0]);
			int K = Integer.parseInt(arr[1]);
			String[] array = bufferedReader.readLine().trim().split(" ");
			int[] input = new int[N];
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(array[j]);
			}
			int Q = Integer.parseInt(bufferedReader.readLine().trim());
			Arrays.sort(input);
			for (int j = 0; j < Q; j++) {
				String[] queries = bufferedReader.readLine().trim().split(" ");
				bufferedWriter.write(
						countInRange(input, N, Integer.parseInt(queries[0]), Integer.parseInt(queries[1])) + "\n");
			}
		}
		bufferedWriter.flush();
	}

	public static int lowerIndex(int[] input, int n, int x) {
		int l = 0, h = n - 1;
		while (l <= h) {
			int mid = (l + h) / 2;
			if (input[mid] >= x)
				h = mid - 1;
			else
				l = mid + 1;
		}
		return l;
	}

	public static int upperIndex(int[] input, int n, int y) {
		int l = 0, h = n - 1;
		while (l <= h) {
			int mid = (l + h) / 2;
			if (input[mid] <= y)
				l = mid + 1;
			else
				h = mid - 1;
		}
		return h;
	}

	public static int countInRange(int[] arr, int n, int x, int y) {
		int count = 0;
		count = upperIndex(arr, n, y) - lowerIndex(arr, n, x) + 1;
		return count;
	}

}
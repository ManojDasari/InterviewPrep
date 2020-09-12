package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cabinetPartitions {
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] array = bufferedReader.readLine().trim().split(" ");
			int N = Integer.parseInt(array[0]);
			int workers = Integer.parseInt(array[1]);
			int[] input = new int[N];
			String[] array1 = bufferedReader.readLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(array1[j]);
			}
			cabinetPartition(input, N, workers, 0, 0);
			System.out.println(ans);
		}
	}

	public static void cabinetPartition(int[] input, int N, int k, int currAns, int index) {
		if (k == 1) {
			currAns = Math.max(currAns, sumArray(input, index, N));
			ans = Math.min(ans, currAns);
			return;
		}
		int sum = 0;
		for (int i = index; i < N; i++) {
			sum += input[index];
			currAns = Math.max(currAns, sum);
			cabinetPartition(input, N, k - 1, currAns, i + 1);
		}
	}

	public static int sumArray(int[] input, int index, int n) {
		int result = 0;
		while (index < n) {
			result += input[index++];
		}
		return result;
	}
}
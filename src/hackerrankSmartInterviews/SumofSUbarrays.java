package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumofSUbarrays {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine().trim());
		long[] sumArray = new long[N];
		int[] input = new int[N];
		String[] array = bufferedReader.readLine().trim().split(" ");
		long sum = 0;
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(array[i]);
			sum += input[i];
			sumArray[i] = sum;
		}
		int queries = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < queries; i++) {
			String[] arr = bufferedReader.readLine().trim().split(" ");
			int low = Integer.parseInt(arr[0]);
			int high = Integer.parseInt(arr[1]);
			if (low == 0) {
				System.out.println(sumArray[high]);
			} else
				System.out.println(sumArray[high] - sumArray[low - 1]);
		}
	}
}
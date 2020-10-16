package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class rangeSumSubArray {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] array = bufferedReader.readLine().trim().split(" ");
			int N = Integer.parseInt(array[0]);
			int A = Integer.parseInt(array[1]);
			int B = Integer.parseInt(array[2]);
			array = bufferedReader.readLine().trim().split(" ");
			int[] input = new int[N];
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(array[j]);
			}
			rangeSubArray(input, A, B, N, bufferedWriter);
		}
		bufferedWriter.flush();
	}

	public static void rangeSubArray(int[] input, int A, int B, int N, BufferedWriter bw) throws IOException {
		long count = 0;
		if (input.length == 0) {
			bw.write(count + "\n");
		}
		for (int i = 0; i < N; i++) {
			BigInteger sum = BigInteger.ZERO;
			for (int j = i; j < N; j++) {
				sum = sum.add(BigInteger.valueOf(input[j]));

				if (sum.compareTo(BigInteger.valueOf(A)) >= 0 && sum.compareTo(BigInteger.valueOf(B)) <= 0) {
					count++;
				}
				if (sum.compareTo(BigInteger.valueOf(B)) > 0) {
					break;
				}
			}
		}
		bw.write(count + "\n");
	}

	public static void rangeSum(int[] input, int A, int B, int N, BufferedWriter bw) throws IOException {
		int i = 0;
		int j = 0;
		long sum = 0;
		long count = 0;

		while (i < N) {
			sum = sum + input[j];
			if ((sum >= A) && (sum <= B)) {
				count++;
				j++;
			} else if (sum < A) {
				j++;
			} else if (sum > B) {
				i++;
				j = i;
				sum = 0;
			}
			if (j == N) {
				sum = 0;
				i++;
				j = i;
			}
		}

		bw.write(count + "\n");
	}
}
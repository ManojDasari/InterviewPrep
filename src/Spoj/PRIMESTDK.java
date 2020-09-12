package Spoj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class PRIMESTDK {
	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine().trim());
		int[] queries = new int[N];
		for (int i = 0; i < N; i++) {
			queries[i] = Integer.parseInt(bufferedReader.readLine().trim());
		}
		int[] primes = generatePrimes(100000000);
		printPrimes(queries, primes, bufferedWriter);
		bufferedWriter.flush();
	}

	public static void printPrimes(int[] queries, int[] primes, BufferedWriter bw) throws IOException {
		for (int i : queries) {
			bw.write(String.valueOf(primes[i - 1]) + '\n');
		}
	}

	public static int[] generatePrimes(int b) {
		int[] arr = new int[5000001];
		boolean[] primesArr = new boolean[b+1];
		Arrays.fill(primesArr, true);
		primesArr[0] = false;
		primesArr[1] = false;
		for (int i = 4; i <= b; i = i + 2)
			primesArr[i] = false;

		for (int i = 3; i * i <= b; i = i + 2) {
			if (primesArr[i]) {
				int j = i * i;
				while (j <= b) {
					primesArr[j] = false;
					j = j + (2 * i);
				}
			}
		}
		int count = 0;
		arr[count++] = 2;
		for (int i = 3; i < primesArr.length && count < 5000001; i = i + 2) {
			if (primesArr[i]) {
				arr[count++] = i;
			}
		}
		return arr;
	}
}
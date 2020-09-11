package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class primeFear {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> list = new ArrayList<Integer>();
		getPrimes(list);
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int input = Integer.parseInt(bufferedReader.readLine().trim());
			bufferedWriter.write(getCount(list, input) + "\n");
		}
		bufferedWriter.flush();
	}

	public static int getCount(ArrayList<Integer> list, int N) {
		int low = 0, high = list.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int temp = list.get(mid);
			if (temp <= N) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	public static void getPrimes(ArrayList<Integer> list) {
		boolean primes[] = new boolean[10000001];

		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; (i * i) <= 1000000; i++) {
			if (primes[i] != false) {
				for (int j = i * i; j <= 1000000; j = j + i) {
					primes[j] = false;
				}
			}
		}
		for (int i = 2; i <= 1000000; i++) {
			if (primes[i]) {
				list.add(i);
				int num = i;
				int sum = 0;
				StringBuilder sb = new StringBuilder();
				while (num != 0) {
					int d = num % 10;
					sb.insert(0, d);
					sum = Integer.parseInt(sb.toString());
					if ((d == 0) || !list.contains(sum)) {
						list.remove(new Integer(i));
						break;
					}
					num = num / 10;
				}
			}
		}
	}
}
package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class rangePrimes {
	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> primes = getPrimes();
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] arr = bufferedReader.readLine().trim().split(" ");
			int A = Integer.parseInt(arr[0]);
			int B = Integer.parseInt(arr[1]);
			bufferedWriter.write(getCount(primes, A, B) + "\n");
		}
		bufferedWriter.flush();
	}

	public static int getCount(ArrayList<Integer> list, int A, int B) {
		int count = 0;
		count = findFloorforInput(list, 0, list.size()-1, B) - findCeil(list, list.size()-1, A);
		return count + 1;
	}

	public static ArrayList<Integer> getPrimes() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		boolean primes[] = new boolean[1000001];
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
		for (int i = 0; i < 1000001; i++) {
			if (primes[i])
				result.add(i);
		}
		return result;
	}

	public static int findFloorforInput(ArrayList<Integer> input, int low, int high, int x) {
		int ans = 0;
		int index = low;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (input.get(mid) > x) {
				high = mid - 1;
			} else {
				ans = Math.max(ans, input.get(mid));
				index = mid;
				low = mid + 1;
			}

		}
		return index;
	}

	public static int findCeil(ArrayList<Integer> input, int N, int K) {
		int result;
		int index = N;
		int low = 0, high = N - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (K > input.get(mid))
				low = mid + 1;
			else {
				result = input.get(mid);
				index = mid;
				high = mid - 1;
			}

		}
		return index;
	}
}
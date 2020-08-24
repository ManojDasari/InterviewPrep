package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FindingFrequency {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int inputSize = Integer.parseInt(bufferedReader.readLine().trim());
		String[] array = bufferedReader.readLine().trim().split(" ");
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(inputSize);
		for (String s : array) {
			map.put(Integer.parseInt(s), map.getOrDefault(Integer.parseInt(s), 0) + 1);
		}
		int querySize = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < querySize; i++) {
			int input = Integer.parseInt(bufferedReader.readLine().trim());
			if (map.containsKey(input))
				System.out.println(map.get(input));
			else
				System.out.println(0);
		}
	}

	public static int getFrequencyBruteForce(int[] input, int N, int x) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (input[i] == x)
				count++;
		}
		return count;
	}

	public static int getFrequencyExpand(int[] arr, int N, int x) {
		int ind = binarySearch(arr, 0, N - 1, x);

		if (ind == -1)
			return 0;

		int count = 1;
		int left = ind - 1;
		while (left >= 0 && arr[left] == x) {
			count++;
			left--;
		}
		int right = ind + 1;
		while (right < N && arr[right] == x) {
			count++;
			right++;
		}

		return count;
	}

	// public static int findFrequenctCountArray(int[] input, int N, int x){
	// int b=(int)(-1e8), a=(int)(1e8);
	// int size = (int) a-b+1;
	// int[] countArray = new int[size];
	// for(int i:input){
	// countArray[i-b]++;
	// }
	// return countArray[x-b];
	// }

	public static int findFrequency2pointer(int[] input, int N, int x) {
		int p1 = 0, p2 = N - 1;
		while (p1 < p2) {
			if (input[p1] == x)
				break;
			if (input[p2] == x)
				break;
			if (input[p1] < x)
				p1++;
			else
				p2--;
		}
		while (p1 < N && input[p1] != x)
			p1++;
		while (p2 >= 0 && input[p2] != x)
			p2--;
		if (p2 < 0)
			return 0;
		return p2 - p1 + 1;
	}

	public static int binarySearch(int[] arr, int l, int r, int x) {
		if (r < l)
			return -1;

		int mid = (r + l) / 2;

		if (arr[mid] == x)
			return mid;

		if (arr[mid] > x)
			return binarySearch(arr, l, mid - 1, x);

		return binarySearch(arr, mid + 1, r, x);
	}

	static int first(int[] arr, int low, int high, int x, int n) {
		if (high >= low) {
			int mid = (low + high) / 2;
			if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
				return mid;
			else if (x > arr[mid])
				return first(arr, (mid + 1), high, x, n);
			else
				return first(arr, low, (mid - 1), x, n);
		}
		return -1;
	}

	static int last(int[] arr, int low, int high, int x, int n) {
		if (high >= low) {
			int mid = (low + high) / 2;
			if ((mid == n - 1 || x < arr[mid + 1]) && arr[mid] == x)
				return mid;
			else if (x < arr[mid])
				return last(arr, low, (mid - 1), x, n);
			else
				return last(arr, (mid + 1), high, x, n);
		}
		return -1;
	}

	static int countFrequency2BS(int[] arr, int x, int n) {

		int i, j;
		i = first(arr, 0, n - 1, x, n);
		if (i == -1)
			return 0;
		j = last(arr, i, n - 1, x, n);

		return j - i + 1;
	}
}
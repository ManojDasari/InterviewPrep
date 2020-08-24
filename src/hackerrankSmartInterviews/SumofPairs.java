package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class SumofPairs {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] array = bufferedReader.readLine().trim().split(" ");
			int arraySize = Integer.parseInt(array[0]);
			int sumValue = Integer.parseInt(array[1]);
			String[] input = bufferedReader.readLine().trim().split(" ");
			int[] arr = new int[arraySize];
			for (int j = 0; j < arraySize; j++)
				arr[j] = Integer.parseInt(input[j]);
			sumPairsusingunsortedMap(arr, arraySize, sumValue);
		}
	}

	public static void sumPairsusingunsortedMap(int[] input, int N, int sum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : input) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for (int i = 0; i < N; i++) {
			int temp = sum - input[i];
			if (map.containsKey(temp)) {
				if (input[i] == temp && map.get(temp) > 1) {
					System.out.println("True");
					return;
				} else if (input[i] != temp) {
					System.out.println("True");
					return;
				}
			}
		}
		System.out.println("False");
	}

	public static void sumPairsusingunsortedSet(int[] input, int N, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			int temp = sum - input[i];
			if (set.contains(temp)) {
				System.out.println("True");
				return;
			} else {
				set.add(input[i]);
			}
		}
		System.out.println("False");
	}

	public static void checkSumPairs(int[] input, int count, int sum) {
		int p1 = 0, p2 = count;
		while (p1 < p2) {
			if (input[p1] + input[p2] == sum) {
				System.out.println("True");
				return;
			} else if (input[p1] + input[p2] < sum)
				p1++;
			else
				p2--;
		}
		System.out.println("False");
	}

	public static void mergeSort(int[] input, int low, int high) {
		if (low == high)
			return;
		int mid = (high + low) / 2;
		mergeSort(input, low, mid);
		mergeSort(input, mid + 1, high);
		merge(input, low, high);
	}

	public static void merge(int[] input, int low, int high) {
		int[] temp = new int[high - low + 1];
		int mid = (high + low) / 2;
		int p1 = low, p2 = mid + 1;
		int k = 0;
		while (p1 <= mid && p2 <= high) {
			if (input[p1] < input[p2])
				temp[k++] = input[p1++];
			else
				temp[k++] = input[p2++];
		}
		while (p1 <= mid)
			temp[k++] = input[p1++];
		while (p2 <= high)
			temp[k++] = input[p2++];
		for (int i = low; i <= high; i++) {
			input[i] = temp[i - low];
		}
	}
}
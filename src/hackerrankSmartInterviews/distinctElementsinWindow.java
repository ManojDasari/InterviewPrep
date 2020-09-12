package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class distinctElementsinWindow {

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
			int window = Integer.parseInt(array[1]);
			String[] array1 = bufferedReader.readLine().trim().split(" ");
			int[] input = new int[N];
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(array1[j]);
			}
			distinctWindowElements(input, N, window);
			System.out.println();
		}
	}

	public static void distinctWindowElements(int[] input, int N, int window) {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();

		for (int i = 0; i < window; i++) {
			hs.put(input[i], hs.getOrDefault(input[i], 0) + 1);
		}
		System.out.print(hs.size() + " ");
		for (int i = window; i < N; i++) {
			if (hs.get(input[i - window]) == 1)
				hs.remove(input[i - window]);
			else
				hs.put(input[i - window], hs.getOrDefault(input[i - window], 0) - 1);

			hs.put(input[i], hs.getOrDefault(input[i], 0) + 1);
			System.out.print(hs.size() + " ");
		}
	}
}
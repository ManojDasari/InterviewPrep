package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class QuadrapulsXOR {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int N = Integer.parseInt(bufferedReader.readLine().trim());
			int[] input1 = new int[N];
			int[] input2 = new int[N];
			int[] input3 = new int[N];
			int[] input4 = new int[N];
			String[] array1 = bufferedReader.readLine().trim().split(" ");
			String[] array2 = bufferedReader.readLine().trim().split(" ");
			String[] array3 = bufferedReader.readLine().trim().split(" ");
			String[] array4 = bufferedReader.readLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				input1[j] = Integer.parseInt(array1[j]);
				input2[j] = Integer.parseInt(array2[j]);
				input3[j] = Integer.parseInt(array3[j]);
				input4[j] = Integer.parseInt(array4[j]);
			}
			quadruplesofXOR(input1, input2, input3, input4, N);
		}
	}

	public static void quadruplesofXOR(int[] A, int[] B, int[] C, int[] D, int N) {
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map1.put(A[i] ^ B[j], map1.getOrDefault(A[i] ^ B[j], 0) + 1);
				map2.put(0 ^ C[i] ^ D[j], map2.getOrDefault(0 ^ C[i] ^ D[j], 0) + 1);
			}
		}
		for (Entry<Integer, Integer> e : map1.entrySet()) {
			int temp = e.getKey();
			if (map2.containsKey(temp)) {
				result += map1.get(temp)*map2.get(temp);
			}
		}
		System.out.println(result);
	}
}
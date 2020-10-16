package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class maxWindow {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] arr = bufferedReader.readLine().trim().split(" ");
			int N = Integer.parseInt(arr[0]);
			int k = Integer.parseInt(arr[1]);
			int[] input = new int[N];
			String[] array = bufferedReader.readLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(array[j]);
			}
			windowMaximun(input, N, k);
		}
	}

	public static void windowMaximun(int[] arr, int N, int k) {
		Deque<Integer> deQueue = new LinkedList<Integer>();
		int i, result = 0;
		for (i = 0; i < k; ++i) {
			while (!deQueue.isEmpty() && arr[i] >= arr[deQueue.peekLast()])
				deQueue.removeLast();
			deQueue.addLast(i);
		}
		for (; i < N; ++i) {
			result += arr[deQueue.peek()];
			while ((!deQueue.isEmpty()) && deQueue.peek() <= i - k)
				deQueue.removeFirst();
			while ((!deQueue.isEmpty()) && arr[i] >= arr[deQueue.peekLast()])
				deQueue.removeLast();
			deQueue.addLast(i);
		}
		result += arr[deQueue.peek()];
		System.out.println(result);
	}
}
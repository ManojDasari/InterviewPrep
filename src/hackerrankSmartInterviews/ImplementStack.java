package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImplementStack {
	static int stack[] = new int[10000];
	static int top = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] arr = bufferedReader.readLine().trim().split(" ");
			if (arr[0].equalsIgnoreCase("push")) {
				push(Integer.parseInt(arr[1]));
			} else {
				pop();
			}
		}
	}

	public static void push(int x) {
		if (top >= 10000 - 1) {
			System.out.println("Stack overflow");
			return;
		}
		stack[++top] = x;
		return;
	}

	public static void pop() {
		if (top < 0) {
			System.out.println("Empty");
			return;
		}
		System.out.println(stack[top--]);
	}
}
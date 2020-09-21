package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class stockSpanofi {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int N = Integer.parseInt(bufferedReader.readLine().trim());
			int[] input = new int[N];
			String[] arr = bufferedReader.readLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(arr[j]);
			}
			stockSpan(input, N, bufferedWriter);
			bufferedWriter.write("\n");
		}
		bufferedWriter.flush();
	}

	public static void stockSpan(int[] price, int N, BufferedWriter bw) throws IOException {
		int[] S = new int[N];
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		S[0] = 1;
		for (int i = 1; i < N; i++) {
			while (!st.empty() && price[st.peek()] <= price[i])
				st.pop();
			S[i] = (st.empty()) ? (i + 1) : (i - st.peek());
			st.push(i);
		}
		for (int i : S) {
			bw.write(i + " ");
		}
	}
}
package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class mangoesCollection {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int queries = Integer.parseInt(bufferedReader.readLine().trim());
			bufferedWriter.write("Case " + (i + 1) + ":" + "\n");
			Stack<Integer> st = new Stack<Integer>();
			Stack<Integer> maxStack = new Stack<Integer>();
			for (int j = 0; j < queries; j++) {
				String[] arr = bufferedReader.readLine().trim().split(" ");
				if (arr[0].equals("A")) {
					if (!maxStack.isEmpty() && maxStack.peek() <= Integer.parseInt(arr[1])) {
						maxStack.push(Integer.parseInt(arr[1]));
					}
					if (maxStack.isEmpty())
						maxStack.push(Integer.parseInt(arr[1]));
					st.push(Integer.parseInt(arr[1]));
				} else if (arr[0].equals("R")) {
					if (!st.isEmpty()) {
						int temp = st.pop();
						if (temp == maxStack.peek()) {
							maxStack.pop();
						}
					}
				} else {
					if (maxStack.isEmpty())
						bufferedWriter.write("Empty" + "\n");
					else
						bufferedWriter.write(maxStack.peek() + "\n");
				}
			}
		}
		bufferedWriter.flush();
	}
}
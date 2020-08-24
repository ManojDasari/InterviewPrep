package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ComputeFactorial {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int factorial[] = new int[1000001];
		factorial[0] = 1;
		long fact = 1;
		int m = (int) 1e9 + 7;
		for (int i = 1; i < factorial.length; i++) {
			fact = (fact * i) % m;
			factorial[i] = (int) fact;
		}
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int input = Integer.parseInt(bufferedReader.readLine().trim());
			bufferedWriter.write(factorial[input] + "\n");

		}
		bufferedWriter.flush();
	}
}
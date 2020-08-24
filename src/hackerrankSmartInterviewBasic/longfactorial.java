package hackerrankSmartInterviewBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class longfactorial {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(bufferedReader.readLine().trim());
		System.out.println(factorial(input));
	}

	public static long factorial(int input) {
		if (input == 0)
			return 1;
		return (long) input * factorial(input - 1);
	}
}
package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintRightAngledTrianglePattern {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(bufferedReader.readLine().trim());
		int[] input = new int[count];
		for (int i = 0; i < count; i++) {
			input[i] = Integer.parseInt(bufferedReader.readLine().trim());
		}
		for (int var = 0; var < count; var++) {
			System.out.println("Case #" + (var + 1) + ":");
			int n = input[var];
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < n - i; j++) {
					System.out.print(" ");
				}
				for (int k = 0; k <= i; k++) {
					System.out.print("*");
				}
				System.out.println("");
			}
		}

	}
}
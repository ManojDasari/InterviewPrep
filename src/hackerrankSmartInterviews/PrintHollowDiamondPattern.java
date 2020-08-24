package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintHollowDiamondPattern {

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
			int rows = input[var];
			rows = (rows / 2) + 1;
			for (int i = 1; i <= rows; i++) {
				for (int j = rows; j > i; j--) {
					System.out.print(" ");
				}
				System.out.print("*");
				for (int k = 1; k < 2 * (i - 1); k++) {
					System.out.print(" ");
				}
				if (i == 1) {
					System.out.println("");
				} else {
					System.out.println("*");
				}
			}
			for (int i = rows - 1; i >= 1; i--) {
				for (int j = rows; j > i; j--) {
					System.out.print(" ");
				}
				System.out.print("*");
				for (int k = 1; k < 2 * (i - 1); k++) {
					System.out.print(" ");
				}
				if (i == 1)
					System.out.println("");
				else
					System.out.println("*");
			}
		}
	}
}
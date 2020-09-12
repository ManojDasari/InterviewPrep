package Hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MarsExploration {

	// Complete the marsExploration function below.
	static int marsExploration(String s) {
		int count = 0;
		int currentPos = 0;
		for (char letter : s.toCharArray()) {
			if (currentPos % 3 == 1) {
				count += (letter != 'O') ? 1 : 0;
			} else {
				count += (letter != 'S') ? 1 : 0;
			}
			currentPos++;
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = scanner.nextLine();

		int result = marsExploration(s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}

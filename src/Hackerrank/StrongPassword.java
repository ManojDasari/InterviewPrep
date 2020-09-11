package Hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StrongPassword {

	// Complete the minimumNumber function below.
	static int minimumNumber(int n, String password) {
		// Return the minimum number of characters to make the password strong
		int count = 0;
		String SPECIAL_CHARACTERS = "!@#$%^&*()-+";
		if (!password.chars().anyMatch(Character::isDigit)) {
			count++;
		}
		if (!password.chars().anyMatch(Character::isLowerCase)) {
			count++;
		}
		if (!password.chars().anyMatch(Character::isUpperCase)) {
			count++;
		}
		if (!password.chars().anyMatch(ch -> SPECIAL_CHARACTERS.indexOf((char) ch) >= 0)) {
			count++;
		}
		count = Math.max(count, 6 - password.length());

		return count;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String password = scanner.nextLine();

		int answer = minimumNumber(n, password);

		bufferedWriter.write(String.valueOf(answer));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}

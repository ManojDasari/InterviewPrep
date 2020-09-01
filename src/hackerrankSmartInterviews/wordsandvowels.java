package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class wordsandvowels {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			StringBuilder input = new StringBuilder();
			input.append(bufferedReader.readLine().trim());
			wordsVowelsConsonants(input);
			System.out.println();

		}
	}

	public static void wordsVowelsConsonants(StringBuilder input) {
		int vowelCount = 0, consonantCount = 0;
		String[] array = input.toString().split("\\s+");
		System.out.print(array[0].isEmpty() ? "0 " : array.length + " ");
		for (String s : array) {
			for (Character ch : s.toCharArray()) {
				if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O'
						|| ch == 'u' || ch == 'U') {
					vowelCount++;
				}
			}
		}
		System.out.print(vowelCount + " ");
		for (String s : array) {
			for (Character ch : s.toCharArray()) {
				if (ch != 'a' && ch != 'A' && ch != 'e' && ch != 'E' && ch != 'i' && ch != 'I' && ch != 'o' && ch != 'O'
						&& ch != 'u' && ch != 'U') {
					consonantCount++;
				}
			}
		}

		System.out.print(consonantCount + " ");
	}
}
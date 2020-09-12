package Hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class gemStones {

	// Complete the gemstones function below.
	static int gemstones(String[] arr) {
		int gemStones = 0;
		boolean flag = true;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			for (String s : arr) {
				if (s.indexOf(ch) < 0) {
					flag = false;
					break;
				}
			}
			if (flag)
				gemStones++;
			else
				flag = true;
		}
		return gemStones;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			String arrItem = scanner.nextLine();
			arr[i] = arrItem;
		}

		int result = gemstones(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}

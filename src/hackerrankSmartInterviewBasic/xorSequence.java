package hackerrankSmartInterviewBasic;

//https://www.hackerrank.com/challenges/xor-se/problem

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class xorSequence {

	// Complete the xorSequence function below.
	static long xorSequence(long l, long r) {
		long Xor2 = 0, Xor1 = 0;
		long pos = l;
		while (true) {
			if ((pos) % 8 == 0) {
				break;
			}
			Xor1 ^= func(pos);
			pos++;
		}
		pos = r;
		while (true) {
			if ((pos) % 8 == 0) {
				Xor2 ^= func(pos);
				break;
			}
			Xor2 ^= func(pos);
			pos--;
		}
		return (Xor1 ^ Xor2);
	}

	public static long func(long i) {
		if (i % 4 == 0) {
			return i;
		} else if ((i - 1) % 4 == 0) {
			return 1;
		} else if ((i - 2) % 4 == 0) {
			return i + 1;
		} else
			return 0;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] lr = scanner.nextLine().split(" ");

			long l = Long.parseLong(lr[0]);

			long r = Long.parseLong(lr[1]);

			long result = xorSequence(l, r);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}

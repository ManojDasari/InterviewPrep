package hackerrankSmartInterviewBasic;

//https://www.hackerrank.com/challenges/maximizing-xor/problem
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MaximizingXOR {

	// Complete the maximizingXor function below.
	static int maximizingXor(int l, int r) {
		int lxr = l ^ r;
		int msb = 0;
		while (lxr > 0) {
			msb++;
			lxr = lxr >> 1;
		}
		int result = 0;
		int one = 1;
		while (msb > 0) {
			result += one;
			one = one << 1;
			msb--;
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int l = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int r = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int result = maximizingXor(l, r);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
